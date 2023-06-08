package com.frame.kotlintoolkit.data.auth.repository

import com.frame.kotlintoolkit.core.exception.Failure
import com.frame.kotlintoolkit.core.exception.Failure.NetworkConnection
import com.frame.kotlintoolkit.core.functional.Either
import com.frame.kotlintoolkit.core.functional.Either.Left
import com.frame.kotlintoolkit.core.platform.NetworkHandler
import com.frame.kotlintoolkit.data.auth.remote.api.AuthService
import com.frame.kotlintoolkit.data.auth.remote.dto.UserEntity
import com.frame.kotlintoolkit.data.common.BaseRepository
import com.frame.kotlintoolkit.data.common.ResponseWrapper
import com.frame.kotlintoolkit.domain.auth.usecase.LoginWithEmail
import javax.inject.Inject

interface AuthRepository {
    fun login(params: LoginWithEmail.Params): Either<Failure, ResponseWrapper<UserEntity>>

    class Network @Inject constructor(
        private val networkHandler: NetworkHandler,
        private val service: AuthService
    ) : BaseRepository(), AuthRepository {
        override fun login(params: LoginWithEmail.Params): Either<Failure, ResponseWrapper<UserEntity>> {
            return when (networkHandler.isNetworkAvailable()) {
                true -> request(service.login(params), {it})
                false -> Left(NetworkConnection)
            }
        }
    }
}