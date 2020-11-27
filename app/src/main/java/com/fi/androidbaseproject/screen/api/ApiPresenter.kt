package com.fi.androidbaseproject.screen.api

import android.content.Context
import com.fi.androidbaseproject.network.NetworkServices
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

29/06/2020, 02:32 PM
 ****************************************
 */

class ApiPresenter(
    private val view: ApiView.View
) : ApiView.Presenter {

    private var mCompositeDisposable = CompositeDisposable()

    override fun getData(context: Context) {
        val headerMap = linkedMapOf<String, String>()
        val queryMap = linkedMapOf<String, String>()
        view.onProcess()
        try {
            val service = NetworkServices.create(context)
            mCompositeDisposable.add(
                service.getName(headerMap, queryMap)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe({
                        if (it.code() == 200) {
                            view.onSuccess(it.body()?.data)
                        } else {
                            view.onError(it.code(), it.message())
                        }
                    }, {
                        view.onError(0, it.message.toString())
                    })
            )
        } catch (e: IllegalArgumentException) {
            view.onError(0, e.message.toString())
        }
    }

    override fun dispose() {
        mCompositeDisposable.dispose()
    }
}