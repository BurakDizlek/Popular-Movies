package com.bd.popularmovies.ui

import android.databinding.BindingAdapter
import android.graphics.Bitmap
import android.util.Log
import android.widget.ImageView
import com.bd.popularmovies.Config
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

object DataBindingAdapter {
    private val TAG = this.javaClass.simpleName

    @JvmStatic
    @BindingAdapter("android:loadPathUrl")
    fun loadUrlImage(view:ImageView,url:String){
        val fullUrl:String = "${Config.API_IMAGE_HOST}$url"
        Log.d(TAG,"url glide ile yüklendi : $fullUrl")
        Glide.with(view.context)
            .load(fullUrl)
            .apply(RequestOptions().centerCrop())
            .into(view)
    }

}