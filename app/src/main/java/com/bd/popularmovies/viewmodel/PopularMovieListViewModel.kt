package com.bd.popularmovies.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.DataSource
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.bd.popularmovies.datasource.PopularMovieListDataSource
import com.bd.popularmovies.model.data.PopularMovieModel

class PopularMovieListViewModel : ViewModel() {


    var loading = MutableLiveData<Boolean>().also {
        it.value = true
    }

    // paging
    private val config = PagedList.Config.Builder()
        .setPageSize(20)
        .setEnablePlaceholders(false)
        .build()

    val popularMovieList = initializedPagedListBuilder(config).build()

    private fun initializedPagedListBuilder(config: PagedList.Config): LivePagedListBuilder<Int, PopularMovieModel> {

        val dataSourceFactory = object : DataSource.Factory<Int, PopularMovieModel>() {
            override fun create(): DataSource<Int, PopularMovieModel> {
                return PopularMovieListDataSource()
            }
        }
        return LivePagedListBuilder<Int, PopularMovieModel>(dataSourceFactory, config)
    }
}