package com.bd.popularmovies.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.bd.popularmovies.model.response.GetPopularMovieDetailResponse
import com.bd.popularmovies.repository.GetPopularMovieDetailRepository

class PopularMovieDetailViewModel : BaseViewModel() {
    val movieDetailData = MutableLiveData<GetPopularMovieDetailResponse>()


    fun getMovieDetail(movieID: Long) {
        GetPopularMovieDetailRepository.getMovieDetail(movieDetailData, movieID)
    }

}