package com.fi.androidbaseproject.base

import android.app.Application
import android.util.Log.d
import com.fi.androidbaseproject.utils.Utils

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

29/06/2020, 11:43 AM
 ****************************************
 */

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        d(Utils.tag, "application starting")
    }
}