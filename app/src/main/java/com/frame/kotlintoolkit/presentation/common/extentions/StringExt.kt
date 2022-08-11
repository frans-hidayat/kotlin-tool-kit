package com.frame.kotlintoolkit.presentation.common.extentions

import android.util.Patterns

fun String.isEmail() : Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
}