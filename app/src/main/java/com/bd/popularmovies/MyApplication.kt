package com.bd.popularmovies

import android.app.Application
import android.content.Context

class MyApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {

        lateinit var instance: MyApplication
        fun getContext(): Context {
            return instance.applicationContext
        }
    }


}