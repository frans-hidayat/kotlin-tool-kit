package com.frame.kotlintoolkit.data.common

import com.google.gson.annotations.SerializedName

data class ResponseWrapper<T>(
    var code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("status") val status: Boolean,
    @SerializedName("data") val data: T,
) {

}