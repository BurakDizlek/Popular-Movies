package com.bd.popularmovies.repository

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.bd.popularmovies.Config
import com.bd.popularmovies.api.ApiClient
import com.bd.popularmovies.model.response.GetPopularMovieDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetPopularMovieDetailRepository(private val apiClient: ApiClient) {
    private val TAG = this.javaClass.simpleName

    fun getMovieDetail(data: MutableLiveData<GetPopularMovieDetailResponse>, movieID: Long) {
        val call = apiClient.shared.getMovieDetail(movieID, Config.API_KEY, Config.API_LANGUAGE)
        call.enqueue(object : Callback<GetPopularMovieDetailResponse> {
            override fun onResponse(
                call: Call<GetPopularMovieDetailResponse>,
                response: Response<GetPopularMovieDetailResponse>
            ) {
                Log.d(TAG, "getMovieDetail onResponse")
                data.value = response.body()
            }

            override fun onFailure(call: Call<GetPopularMovieDetailResponse>, t: Throwable) {
                Log.d(TAG, "getMovieDetail onFailure message : ${t.message}")
                data.value = null
            }
        })
    }
}