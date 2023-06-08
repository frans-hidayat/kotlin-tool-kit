package com.frame.kotlintoolkit.presentation.auth

import androidx.lifecycle.viewModelScope
import com.frame.kotlintoolkit.core.platform.BaseViewModel
import com.frame.kotlintoolkit.data.auth.remote.dto.UserEntity
import com.frame.kotlintoolkit.data.common.ResponseWrapper
import com.frame.kotlintoolkit.domain.auth.usecase.LoginWithEmail
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginWithEmail: LoginWithEmail) : BaseViewModel() {
    fun login(email: String, password: String) {
        loginWithEmail(LoginWithEmail.Params(email, password), viewModelScope) {
            it.fold(
                ::handleFailure,
                ::onLoginSuccess
            )
        }
    }

    private fun onLoginSuccess(response: ResponseWrapper<UserEntity>) {

    }
}