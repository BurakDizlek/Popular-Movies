package com.bd.popularmovies.ui.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.bd.popularmovies.R
import com.bd.popularmovies.viewmodel.PopularMovieListViewModel

class PopularMovieListActivity : AppCompatActivity() {

    private val TAG = this.javaClass.simpleName
    private lateinit var viewmodel: PopularMovieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popular_movie_list)
        viewmodel = ViewModelProviders.of(this).get(PopularMovieListViewModel::class.java)
        viewmodel.popularMovieListResponseData.observe(this, Observer {
            Log.d(TAG, "viewmodel observer : $it")
        })
        viewmodel.getPopularMovieList()
    }
}
