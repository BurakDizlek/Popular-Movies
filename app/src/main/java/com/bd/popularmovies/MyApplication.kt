package com.bd.popularmovies

import android.app.Application
import com.bd.popularmovies.di.appModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(appModule)
        }
        if (BuildConfig.DEBUG)
            Stetho.initializeWithDefaults(this)
    }


}