package com.bd.popularmovies.datasource

import android.arch.paging.PageKeyedDataSource
import android.util.Log
import com.bd.popularmovies.Config
import com.bd.popularmovies.api.ApiClient
import com.bd.popularmovies.model.data.PopularMovieModel
import com.bd.popularmovies.model.response.GetPopularMoviesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularMovieListDataSource : PageKeyedDataSource<Int, PopularMovieModel>() {

    private val TAG = this.javaClass.simpleName

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, PopularMovieModel>) {
        val call = ApiClient.instance.getPopularMovies(1, Config.API_KEY, "tr-TR")
        call.enqueue(object : Callback<GetPopularMoviesResponse> { //şimdilik sadece başarılı durumu test ediyoruz.
            override fun onResponse(
                call: Call<GetPopularMoviesResponse>,
                response: Response<GetPopularMoviesResponse>
            ) {
                if (response.isSuccessful) {
                    val dataList = response.body()?.results ?: arrayListOf()
                    val totalPage = response.body()?.total_pages ?: 1
                    val page = response.body()?.page ?: 1
                    callback.onResult(dataList, page, totalPage, null, 2)
                } else {
                    Log.d(TAG, "loadInitial response false : ${response.message()}")
                }
            }

            override fun onFailure(call: Call<GetPopularMoviesResponse>, t: Throwable) {
                Log.d(TAG, "loadInitial onFailure message : ${t.message}")
            }
        })

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, PopularMovieModel>) {
        val call = ApiClient.instance.getPopularMovies(params.key, Config.API_KEY, "tr-TR")
        call.enqueue(object : Callback<GetPopularMoviesResponse> { //şimdilik sadece başarılı durumu test ediyoruz.
            override fun onResponse(
                call: Call<GetPopularMoviesResponse>, response: Response<GetPopularMoviesResponse>
            ) {
                if (response.isSuccessful) {
                    val dataList = response.body()?.results ?: arrayListOf()
                    callback.onResult(dataList, params.key + 1)
                } else {
                    Log.d(TAG, "loadInitial response false : ${response.message()}")
                }
            }

            override fun onFailure(call: Call<GetPopularMoviesResponse>, t: Throwable) {
                Log.d(TAG, "loadInitial onFailure message : ${t.message}")
            }
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, PopularMovieModel>) {
        // Bu senaryoda kullanmaya gerek yok.
    }


}