package com.frame.kotlintoolkit.core.interceptor

import com.frame.kotlintoolkit.BuildConfig
import com.frame.kotlintoolkit.core.SharedPrefs
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor constructor(private val pref: SharedPrefs) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = pref.getUser()
        val language = pref.getLanguage().toString()
        val version = BuildConfig.VERSION_NAME

        val newRequest = chain.request().newBuilder()
            .addHeader("Authorization", token)
            .addHeader("App-Version", version)
            .addHeader("Language", language)
            .build()
        return chain.proceed(newRequest)
    }
}