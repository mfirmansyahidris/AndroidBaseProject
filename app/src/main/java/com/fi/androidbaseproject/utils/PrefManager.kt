package com.fi.androidbaseproject.utils

import android.content.Context
import android.content.SharedPreferences
import com.fi.androidbaseproject.BuildConfig

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

29/06/2020, 12:07 PM
 ****************************************
 */

class PrefManager(private val context: Context) {
    private val sharedPref: SharedPreferences =
        context.getSharedPreferences(BuildConfig.APPLICATION_NAME, Context.MODE_PRIVATE)

    private fun setString(key: String, value: String?) {
        val editor = sharedPref.edit()
        editor.putString(key, value)
        editor.apply()
    }

    private fun getString(key: String): String? = sharedPref.getString(key, "")

    private fun setInt(key: String, value: Int) {
        val editor = sharedPref.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    private fun getInt(key: String): Int = sharedPref.getInt(key, 0)

    private fun getBoolean(key: String): Boolean = sharedPref.getBoolean(key, false)

    private fun setBoolean(key: String, value: Boolean) {
        val editor = sharedPref.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }


    fun clear() {
        sharedPref.edit().clear().apply()
    }
}