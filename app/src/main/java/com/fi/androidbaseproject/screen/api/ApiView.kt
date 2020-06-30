package com.fi.androidbaseproject.screen.api

import com.fi.androidbaseproject.models.Name

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

29/06/2020, 02:32 PM
 ****************************************
 */

interface ApiView {
    interface View {
        fun onProcess()
        fun onSuccess(result: List<Name>?)
        fun onError(code: Int?, message: String)
    }

    interface Presenter {
        fun getData()
        fun dispose()
    }
}