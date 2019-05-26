package com.bd.popularmovies.api

import com.bd.popularmovies.Config
import com.bd.popularmovies.model.response.GetMovieDetailResponse
import com.bd.popularmovies.model.response.GetPopularMoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WebService {

    /**
     *  @param page yüklenmesini istediğiniz sayfa numarası. Her sorgu 20 veri çekmektedir.
     */
    @GET("popular?api_key=${Config.API_KEY}&language=tr-TR&page={page}")
    fun getPopularMovies(@Path("page") page: Int): Call<GetPopularMoviesResponse>


    @GET("{movie_id}?api_key=${Config.API_KEY}&language=tr-TR")
    fun getMovieDetail(@Path("movie_id") movie_id: Int): Call<GetMovieDetailResponse>

}