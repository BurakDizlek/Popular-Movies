package com.bd.popularmovies.api

import com.bd.popularmovies.BuildConfig
import com.bd.popularmovies.Config
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.GsonBuilder
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.CookieHandler
import java.net.CookieManager
import java.net.CookiePolicy
import java.util.concurrent.TimeUnit

object ApiClient {
    private var TIMEOUTOFSECOND = 16
    val instance: WebService by lazy {
        setupHttpClient()
    }

    private fun setupHttpClient(): WebService {
        val cookieManager = CookieManager()
        CookieHandler.setDefault(cookieManager)
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL)


        val client = clientBuilder()
            .connectTimeout(TIMEOUTOFSECOND.toLong(), TimeUnit.SECONDS)
            .writeTimeout(TIMEOUTOFSECOND.toLong(), TimeUnit.SECONDS)
            .readTimeout(TIMEOUTOFSECOND.toLong(), TimeUnit.SECONDS)
            .connectionPool(ConnectionPool())
            .build()
        val gson = GsonBuilder().create()
        val retrofit = Retrofit.Builder()
            .baseUrl(Config.API_HOST)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit.create(WebService::class.java)
    }

    private fun clientBuilder(): OkHttpClient.Builder {
        return if (BuildConfig.DEBUG)  // stetho sadece debug modunda çalışacak.
            OkHttpClient.Builder().addNetworkInterceptor(StethoInterceptor())
        else
            OkHttpClient.Builder()
    }

}