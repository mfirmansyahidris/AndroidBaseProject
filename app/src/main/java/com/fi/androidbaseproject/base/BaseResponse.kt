package com.fi.androidbaseproject.base

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

29/06/2020, 01:19 PM
 ****************************************
 */

data class BaseResponse<T>(
    val status: String? = null,
    val message: String? = null,
    val data: T? = null
)