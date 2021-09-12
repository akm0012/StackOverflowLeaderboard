package com.andrewkingmarshall.stackoverflowleaderboard

import android.app.Application
import androidx.viewbinding.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class StackOverflowLeaderboardApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        setUpLogging()
    }

    private fun setUpLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}