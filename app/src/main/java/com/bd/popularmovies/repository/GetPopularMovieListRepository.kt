package com.bd.popularmovies.repository

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.bd.popularmovies.Config
import com.bd.popularmovies.api.ApiClient
import com.bd.popularmovies.model.response.GetPopularMoviesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object GetPopularMovieListRepository {
    private val TAG = this.javaClass.simpleName
    // singleton oluşturulacak. koin...

    fun getMovieList(data: MutableLiveData<GetPopularMoviesResponse>) {
        // 1 hard gönderiliyor. paging library'e çevirilecek.
        val call = ApiClient.instance.getPopularMovies(1, Config.API_KEY,"tr-TR")
        call.enqueue(object : Callback<GetPopularMoviesResponse> {
            override fun onResponse(call: Call<GetPopularMoviesResponse>, response: Response<GetPopularMoviesResponse>) {
                Log.d(TAG, "getMovieList onResponse")
                data.value = response.body()
            }

            override fun onFailure(call: Call<GetPopularMoviesResponse>, t: Throwable) {
                data.value = null
                Log.d(TAG, "getMovieList onFailure message : ${t.message}")
            }
        })
    }
}