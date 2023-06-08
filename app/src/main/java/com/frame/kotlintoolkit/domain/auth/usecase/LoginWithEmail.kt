package com.frame.kotlintoolkit.domain.auth.usecase

import com.frame.kotlintoolkit.core.interactor.UseCase
import com.frame.kotlintoolkit.data.auth.remote.dto.UserEntity
import com.frame.kotlintoolkit.data.auth.repository.AuthRepository
import com.frame.kotlintoolkit.data.common.ResponseWrapper
import com.frame.kotlintoolkit.domain.auth.usecase.LoginWithEmail.Params
import javax.inject.Inject

class LoginWithEmail
@Inject constructor(private val authRepository: AuthRepository) :
    UseCase<ResponseWrapper<UserEntity>, Params>() {
    override suspend fun run(params: Params) = authRepository.login(params)

    data class Params(val email: String, val password: String)
}
