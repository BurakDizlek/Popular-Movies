package com.bd.popularmovies.model.response

import com.bd.popularmovies.model.data.PopularMovieModel

data class GetPopularMoviesResponse(
    val page: Int,
    val total_pages: Int,
    val total_results: Int,
    val results: List<PopularMovieModel>
)