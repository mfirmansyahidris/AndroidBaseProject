package com.fi.androidbaseproject.screen.splash

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import com.fi.androidbaseproject.network.NetworkServices
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

27/11/2020, 05:30 PM
 ****************************************
 */

class SplashPresenter(private val view: SplashView.View) : SplashView.Presenter {
    //countdown time
    private var _currentTime = MutableLiveData<Long>()
    private var mCompositeDisposable = CompositeDisposable()

    override fun processTimer() {
        val timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND) {
            override fun onFinish() {
                _currentTime.value = DONE
                view.onTimersDone()
            }

            override fun onTick(millisUntilFinished: Long) {
                _currentTime.value = millisUntilFinished / ONE_SECOND
            }
        }
        timer.start()
    }

    override fun getGeneralSetup() {
        view.onProcessGeneralSetup()
        try {
            val service = NetworkServices.create()
            mCompositeDisposable.add(
                service.getGeneralConfig()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe({
                        if (it.code() == 200) {
                            view.onSuccessGeneralSetup(it.body())
                        } else {
                            view.onErrorGeneralSetup(it.code(), it.message())
                        }
                    }, {
                        view.onErrorGeneralSetup(0, it.message.toString())
                    })
            )
        } catch (e: IllegalArgumentException) {
            view.onErrorGeneralSetup(0, e.message.toString())
        }
    }

    override fun dispose() {
        mCompositeDisposable.dispose()
    }

    companion object {
        //Time when the game is over
        private const val DONE = 0L

        //Countdown time interval
        private const val ONE_SECOND = 1000L

        //Total time for the game
        private const val COUNTDOWN_TIME = 2000L
    }
}