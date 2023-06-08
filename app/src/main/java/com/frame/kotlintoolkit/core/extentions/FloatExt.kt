package com.frame.kotlintoolkit.core.extentions

import android.content.res.Resources
import kotlin.math.ceil

val Float.dp: Float
    get() {
        return if (this == 0f) {
            0f
        } else ceil((Resources.getSystem().displayMetrics.density * this).toDouble()).toFloat()
    }