package com.frame.kotlintoolkit.domain.common.base

sealed class BaseResult<out T : Any, out U : Any> {
    data class Success<T : Any>(val data: T) : BaseResult<T, Nothing>()
    data class Error<U : Any>(val response: U) : BaseResult<Nothing, U>()
}