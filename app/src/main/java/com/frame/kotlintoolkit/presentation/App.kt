package com.frame.kotlintoolkit.presentation

import android.app.Application
import com.clevertap.android.sdk.ActivityLifecycleCallback

class App : Application() {
    override fun onCreate() {
        ActivityLifecycleCallback.register(this)
        super.onCreate()
    }
}