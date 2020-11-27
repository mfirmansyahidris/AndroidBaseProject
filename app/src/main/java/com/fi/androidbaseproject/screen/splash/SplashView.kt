package com.fi.androidbaseproject.screen.splash

import com.fi.androidbaseproject.models.ApplicationGeneralSetup

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

27/11/2020, 05:30 PM
 ****************************************
 */

interface SplashView {
    interface View {
        fun onTimersDone()
        fun onProcessGeneralSetup()
        fun onSuccessGeneralSetup(generalSetup: ApplicationGeneralSetup?)
        fun onErrorGeneralSetup(code: Int?, message: String)
    }

    interface Presenter {
        fun processTimer()
        fun getGeneralSetup()
        fun dispose()
    }
}