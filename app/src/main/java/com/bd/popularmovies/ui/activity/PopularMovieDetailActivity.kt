package com.bd.popularmovies.ui.activity

import android.arch.lifecycle.Observer
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bd.popularmovies.R
import com.bd.popularmovies.databinding.ActivityPopularMovieDetailBinding
import com.bd.popularmovies.viewmodel.PopularMovieDetailViewModel
import org.koin.android.ext.android.inject

class PopularMovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPopularMovieDetailBinding
    private val viewmodel: PopularMovieDetailViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val movieID = intent?.extras?.getLong("movie_id") ?: 1
        val title = intent?.extras?.getString("title") ?: ""
        binding = DataBindingUtil.setContentView(this, R.layout.activity_popular_movie_detail)
        binding.setLifecycleOwner(this)
        supportActionBar?.title = title

        viewmodel.movieDetailData.observe(this, Observer { responseData ->
            binding.data = responseData
            binding.loading = false
        })

        viewmodel.getMovieDetail(movieID)

    }


    companion object {
        fun popularMovieDetailActivityCreater(movieID: Long, title: String, activity: AppCompatActivity) {
            val i = Intent(activity, PopularMovieDetailActivity::class.java)
            i.putExtra("title", title)
            i.putExtra("movie_id", movieID)
            activity.startActivity(i)
        }
    }
}