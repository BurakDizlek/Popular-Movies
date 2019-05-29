package com.bd.popularmovies.ui

import android.databinding.BindingAdapter
import android.graphics.Color
import android.util.Log
import android.widget.ImageView
import android.widget.TextClock
import android.widget.TextView
import com.bd.popularmovies.Config
import com.bd.popularmovies.utils.getAverageColor
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

object DataBindingAdapter {
    private val TAG = this.javaClass.simpleName

    @JvmStatic
    @BindingAdapter("android:loadPathUrl")
    fun loadUrlImage(view: ImageView, url: String) {
        val fullUrl: String = "${Config.API_IMAGE_HOST}$url"
        Log.d(TAG, "url glide ile yüklendi : $fullUrl")
        Glide.with(view.context)
            .load(fullUrl)
            .apply(RequestOptions().centerCrop())
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("android:emptyOverview")
    fun emptyOverview(view:TextView,text:String){
        if (text.isBlank()){
            view.text = "Türkçe'ye çevrilmiş bir özet henüz bulunmuyor. Film için bir tane ekleyerek katkıda bulunabilirsiniz."
        }
    }

    @JvmStatic
    @BindingAdapter("android:average")
    fun rateView(view:TextView,average:Double){
        val floatAverage = (average/10).toFloat()
        view.text = "$average"
        view.setBackgroundColor(floatAverage.getAverageColor())
    }

}