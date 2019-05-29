package com.bd.popularmovies.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    var loading = MutableLiveData<Boolean>().also {
        it.value = true
    }
}