package com.bd.popularmovies.utils

import android.content.Context
import android.net.ConnectivityManager


fun checkConnectivity(context: Context): Boolean {
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = cm.activeNetworkInfo
    val isConnected = activeNetwork != null && activeNetwork.isConnected
    return isConnected
}