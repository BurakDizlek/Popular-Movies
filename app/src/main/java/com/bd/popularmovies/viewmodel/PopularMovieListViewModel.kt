package com.bd.popularmovies.viewmodel

import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.bd.popularmovies.datasource.factory.PopularMovieListDataSourceFactory
import com.bd.popularmovies.model.data.PopularMovieModel

class PopularMovieListViewModel : BaseViewModel() {

    private val config = PagedList.Config.Builder()
        .setPageSize(20)
        .setEnablePlaceholders(false)
        .build()
    private val livePagedBuilder = LivePagedListBuilder<Int, PopularMovieModel>(PopularMovieListDataSourceFactory(loading), config)
    val popularMovieList = livePagedBuilder.build()

}