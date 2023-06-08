package com.frame.kotlintoolkit.domain.auth.model

import com.frame.kotlintoolkit.core.extentions.empty

data class User(
    val userId: Long?,
    val name: String?,
    val email: String?,
    val token: String?
) {
    companion object {
        val empty = User(
            userId = 0,
            name = String.empty(),
            email = String.empty(),
            token = String.empty()
        )
    }
}