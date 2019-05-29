package com.bd.popularmovies.api

import com.bd.popularmovies.model.response.GetPopularMovieDetailResponse
import com.bd.popularmovies.model.response.GetPopularMoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebService {

    /**
     *  @param page yüklenmesini istediğiniz sayfa numarası. Her sorgu 20 veri çekmektedir.
     */
    @GET("popular")
    fun getPopularMovies(
        @Query("page") page: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Call<GetPopularMoviesResponse>


    @GET("{movie_id}")
    fun getMovieDetail(
        @Path("movie_id") movieID: Long,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Call<GetPopularMovieDetailResponse>

}