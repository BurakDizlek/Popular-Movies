package com.bd.popularmovies.di

import com.bd.popularmovies.repository.GetPopularMovieDetailRepository
import com.bd.popularmovies.viewmodel.PopularMovieDetailViewModel
import com.bd.popularmovies.viewmodel.PopularMovieListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module {
    viewModel { PopularMovieDetailViewModel(get()) }
    viewModel { PopularMovieListViewModel() }
    single { GetPopularMovieDetailRepository() }
}