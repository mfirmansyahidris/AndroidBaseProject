package com.fi.androidbaseproject.utils

import android.annotation.SuppressLint
import com.fi.androidbaseproject.BuildConfig
import java.text.SimpleDateFormat
import java.util.*

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

29/06/2020, 11:44 AM
 ****************************************
 */

class Utils {
    companion object {
        const val tag = "__${BuildConfig.APPLICATION_NAME}"

        @SuppressLint("SimpleDateFormat")
        fun getCurrentTime(): String {
            val c = Calendar.getInstance()
            val df = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            return df.format(c.time)
        }
    }
}