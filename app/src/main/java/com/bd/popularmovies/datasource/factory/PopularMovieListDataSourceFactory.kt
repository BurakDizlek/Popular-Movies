package com.bd.popularmovies.datasource.factory

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import com.bd.popularmovies.datasource.PopularMovieListDataSource
import com.bd.popularmovies.model.data.PopularMovieModel

class PopularMovieListDataSourceFactory(private val loading: MutableLiveData<Boolean>) : DataSource.Factory<Int, PopularMovieModel>() {

    override fun create(): DataSource<Int, PopularMovieModel> {
        return PopularMovieListDataSource(loading)
    }
}