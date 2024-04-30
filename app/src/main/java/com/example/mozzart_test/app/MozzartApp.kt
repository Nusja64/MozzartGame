package com.example.mozzart_test.app

import android.app.Application
import com.example.mozzart_test.BuildConfig
import timber.log.Timber

class MozzartApp : Application() {
    companion object {
        private lateinit var instance: MozzartApp

        fun getInstance(): MozzartApp {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
