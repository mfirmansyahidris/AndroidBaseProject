package com.fi.androidbaseproject.models

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

26/11/2020, 07:28 PM
 ****************************************
 */

data class ApplicationGeneralSetup(
    val baseUrl: String? = "",
    val blockUi: Boolean? = false,
    val alwaysDoSetup: Boolean? = true,
    val message: Message? = null
) {
    data class Message(val type: String? = "", val value: String? = "")
}