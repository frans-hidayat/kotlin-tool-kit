package com.frame.kotlintoolkit.data.auth.remote.api

import com.frame.kotlintoolkit.data.auth.remote.dto.UserEntity
import com.frame.kotlintoolkit.data.common.ResponseWrapper
import com.frame.kotlintoolkit.domain.auth.usecase.LoginWithEmail
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.POST
import javax.inject.Inject
import javax.inject.Singleton

interface AuthApi {
    @POST("auth/login")
    fun login(params: LoginWithEmail.Params): Call<ResponseWrapper<UserEntity>>
}

@Singleton
class AuthService
@Inject constructor(retrofit: Retrofit) : AuthApi {
    private val authApi by lazy { retrofit.create(AuthApi::class.java) }

    override fun login(params: LoginWithEmail.Params) = authApi.login(params)
}