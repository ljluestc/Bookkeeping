package com.hannah.demo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * AUTHOR: hannah
 * DATE: 2020-11-11
 */
@HiltAndroidApp
class BookkeepingApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

}