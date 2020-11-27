package com.fi.androidbaseproject.network

import com.fi.androidbaseproject.base.BaseResponse
import com.fi.androidbaseproject.models.ApplicationGeneralSetup
import com.fi.androidbaseproject.models.Name
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.QueryMap

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

29/06/2020, 01:16 PM
 ****************************************
 */

interface Api{
    @GET("AndroidBaseProject.json")
    fun getGeneralConfig(): Observable<Response<ApplicationGeneralSetup>>

    @GET("0bd6a069-2918-4fa7-b9c8-9485feb0d529")
    fun getName(@HeaderMap headerMap: LinkedHashMap<String, String>, @QueryMap queryMap: LinkedHashMap<String, String>):
            Observable<
                    Response<
                            BaseResponse<List<Name>>
                            >
                    >
}