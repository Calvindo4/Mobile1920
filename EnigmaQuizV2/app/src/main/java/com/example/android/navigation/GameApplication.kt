package com.example.android.navigation

import android.app.Application
import timber.log.Timber

class GameApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}