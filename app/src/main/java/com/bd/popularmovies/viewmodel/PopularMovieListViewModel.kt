package com.bd.popularmovies.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.bd.popularmovies.model.response.GetPopularMoviesResponse
import com.bd.popularmovies.repository.GetPopularMovieListRepository

class PopularMovieListViewModel : ViewModel() {
    var popularMovieListResponseData: MutableLiveData<GetPopularMoviesResponse> = MutableLiveData()

    fun getPopularMovieList() {
        GetPopularMovieListRepository.getMovieList(popularMovieListResponseData)
    }
}