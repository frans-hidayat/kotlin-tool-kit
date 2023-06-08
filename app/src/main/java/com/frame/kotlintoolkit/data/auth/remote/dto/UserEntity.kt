package com.frame.kotlintoolkit.data.auth.remote.dto

import com.frame.kotlintoolkit.domain.auth.model.User
import com.frame.kotlintoolkit.core.extentions.empty
import com.google.gson.annotations.SerializedName

data class UserEntity(
    @SerializedName("id") val userId: Long? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("email") val email: String? = null,
    @SerializedName("token") val token: String? = null
) {
    companion object {
        val empty = UserEntity(
            userId = 0,
            name = String.empty(),
            email = String.empty(),
            token = String.empty()
        )
    }

    fun toUser() = User(
        userId = userId,
        name = name,
        email = email,
        token = token
    )
}