package com.fi.androidbaseproject.screen.splash

import android.content.Intent
import android.os.Build
import android.util.Log
import android.view.View
import android.widget.Toast
import com.fi.androidbaseproject.R
import com.fi.androidbaseproject.base.BaseActivity
import com.fi.androidbaseproject.models.ApplicationGeneralSetup
import com.fi.androidbaseproject.screen.MainActivity

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

27/11/2020, 05:29 PM
 ****************************************
 */

class SplashActivity : BaseActivity(), SplashView.View {
    private lateinit var presenter: SplashPresenter
    private var abortTimer = false

    override fun setLayoutResource(): Int = R.layout.activity_splash

    override fun setToolbarResource(): Int = 0

    override fun setToolbarActionButton(): Boolean = false

    override fun initUI() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        presenter = SplashPresenter(this)
        presenter.processTimer()
    }

    override fun onTimersDone() {
        if (!abortTimer) {
            if(prefManager.getGeneralSetup() != null ) {
                if (prefManager.getGeneralSetup()?.alwaysDoSetup != false) {
                    presenter.getGeneralSetup()
                } else {
                    startMainActivity()
                }
            }else{
                presenter.getGeneralSetup()
            }
        }
    }

    override fun onProcessGeneralSetup() {}

    override fun onSuccessGeneralSetup(generalSetup: ApplicationGeneralSetup?) {
        if(generalSetup != null){
            if(generalSetup.blockUi != null){
                Log.d("DEBUG", generalSetup.blockUi.toString())
                if(generalSetup.blockUi){
                    when (generalSetup.message?.type) {
                        "DIALOG" -> {
                            showDialogPositive(generalSetup.message.value.toString()){finish()}
                        }
                        "TOAST" -> {
                            Toast.makeText(this, generalSetup.message.value.toString(), Toast.LENGTH_LONG).show()
                        }
                        else -> {
                            finish()
                        }
                    }
                }else{
                    Log.d("DEBUG", "1")
                    prefManager.setGeneralSetup(generalSetup)
                    startMainActivity()
                }
            }else{
                Log.d("DEBUG", "2")
                prefManager.setGeneralSetup(generalSetup)
                startMainActivity()
            }
        }
    }

    override fun onErrorGeneralSetup(code: Int?, message: String) {

    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}