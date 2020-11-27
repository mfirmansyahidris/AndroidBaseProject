package com.fi.androidbaseproject.network

import android.content.Context
import com.fi.androidbaseproject.BuildConfig
import com.fi.androidbaseproject.utils.PrefManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 ****************************************
created by -fi-
.::manca.fi@gmail.com ::.

29/06/2020, 01:15 PM
 ****************************************
 */

object NetworkServices {
    private fun okHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val builder = OkHttpClient.Builder()
        builder.connectTimeout(30, TimeUnit.SECONDS)
        builder.readTimeout(30, TimeUnit.SECONDS)
        builder.writeTimeout(30, TimeUnit.SECONDS)
        builder.retryOnConnectionFailure(true)
        builder.addInterceptor(loggingInterceptor)
        return builder.build()
    }

    fun create(context: Context? = null): Api {
        val retrofit: Retrofit = if (context == null) {
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient())
                .baseUrl(BuildConfig.BASE_URL)
                .build()
        } else {
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient())
                .baseUrl(PrefManager(context).getGeneralSetup()?.baseUrl ?: BuildConfig.BASE_URL)
                .build()
        }
        return retrofit.create(Api::class.java)
    }
}