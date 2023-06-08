package com.frame.kotlintoolkit.data.common

import com.frame.kotlintoolkit.core.exception.Failure
import com.frame.kotlintoolkit.core.functional.Either
import retrofit2.Call

open class BaseRepository {
    internal fun <T, R> request(
        call: Call<T>,
        transform: (T) -> R
    ): Either<Failure, R> {
        return try {
            val response = call.execute()
            when (response.isSuccessful) {
                true -> {
                    response.body()?.let {
                        Either.Right(transform((it)))
                    } ?: run {
                        Either.Left(Failure.ServerError)
                    }
                }
                false -> Either.Left(Failure.ServerError)
            }
        } catch (exception: Throwable) {
            Either.Left(Failure.ServerError)
        }
    }
}