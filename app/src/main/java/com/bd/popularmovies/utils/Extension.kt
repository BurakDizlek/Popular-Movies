package com.bd.popularmovies.utils

import android.graphics.Color


fun Float.getAverageColor() : Int{
        val inverseRation = 1f - this
        val color1 = Color.parseColor("#1B5E20")
        val color2 = Color.parseColor("#B71C1C")
        val r = (Color.red(color1) * this) + (Color.red(color2) * inverseRation)
        val g = (Color.green(color1) * this) + (Color.green(color2) * inverseRation)
        val b = (Color.blue(color1) * this) + (Color.blue(color2) * inverseRation)
        return Color.rgb(r.toInt(),g.toInt(),b.toInt())
}