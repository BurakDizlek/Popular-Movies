package com.bd.popularmovies

import android.app.Application
import android.content.Context
import com.bd.popularmovies.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            androidContext(this@MyApplication)
            modules(appModule)
        }

    }

    companion object {

        lateinit var instance: MyApplication
        fun getContext(): Context {
            return instance.applicationContext
        }
    }


}