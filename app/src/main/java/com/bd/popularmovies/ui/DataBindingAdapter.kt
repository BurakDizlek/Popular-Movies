package com.bd.popularmovies.ui

import android.databinding.BindingAdapter
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bd.popularmovies.Config
import com.bd.popularmovies.utils.getAverageColor
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.text.SimpleDateFormat
import java.util.*

object DataBindingAdapter {
    private val TAG = this.javaClass.simpleName
    private val onlyYearDateFormat = SimpleDateFormat("yyyy")


    @JvmStatic
    @BindingAdapter("android:loadPathUrl")
    fun loadUrlImage(view: ImageView, url: String?) {
        if (!url.isNullOrBlank()) {
            val fullUrl: String = "${Config.API_IMAGE_HOST}$url"
            Log.d(TAG, "url glide ile yüklendi : $fullUrl")
            Glide.with(view.context)
                .load(fullUrl)
                .apply(RequestOptions().centerCrop())
                .into(view)
        } else {
            Log.d(TAG, "url : $url")
        }
    }

    @JvmStatic
    @BindingAdapter("android:emptyOverview")
    fun emptyOverview(view: TextView, text: String?) {
        if (text.isNullOrBlank()) {
            view.text =
                "Türkçe'ye çevrilmiş bir özet henüz bulunmuyor. Film için bir tane ekleyerek katkıda bulunabilirsiniz."
        }
    }

    @JvmStatic
    @BindingAdapter("android:average")
    fun rateView(view: TextView, average: Double?) {
        average?.let {
            val floatAverage = (average / 10).toFloat()
            view.text = "$average"
            view.setBackgroundColor(floatAverage.getAverageColor())
        }
    }

    @JvmStatic
    @BindingAdapter("android:yearFromDate")
    fun yearFromDate(view: TextView, dateStr: String?) {
        dateStr?.let {
            val date = onlyYearDateFormat.parse(dateStr)
            val yearText = "(${onlyYearDateFormat.format(date)})"
            view.text = yearText
        }
    }


}