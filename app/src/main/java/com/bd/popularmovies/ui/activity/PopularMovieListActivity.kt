package com.bd.popularmovies.ui.activity

import android.arch.lifecycle.Observer
import android.arch.paging.PagedList
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.bd.popularmovies.R
import com.bd.popularmovies.databinding.ActivityPopularMovieListBinding
import com.bd.popularmovies.model.data.PopularMovieModel
import com.bd.popularmovies.ui.adapter.PopularMovieListAdapter
import com.bd.popularmovies.ui.listener.ItemClickListener
import com.bd.popularmovies.utils.checkConnectivity
import com.bd.popularmovies.viewmodel.PopularMovieListViewModel
import org.koin.android.ext.android.inject

class PopularMovieListActivity : AppCompatActivity(), ItemClickListener {


    private val TAG = this.javaClass.simpleName
    private val adapter = PopularMovieListAdapter(this)
    private val viewmodel: PopularMovieListViewModel by inject()
    private lateinit var binding: ActivityPopularMovieListBinding
    private var lastPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_popular_movie_list)
        binding.data = viewmodel
        binding.setLifecycleOwner(this)
        if (!checkConnectivity(this)) {
            Toast.makeText(this, "Lütfen bağlantınızı kontrol ediniz.", Toast.LENGTH_SHORT).show()
            viewmodel.loading.value = false
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewmodel.popularMovieList.observe(this, Observer<PagedList<PopularMovieModel>> { movieList ->
            adapter.submitList(movieList)
        })

        binding.recyclerView.adapter = adapter
    }

    override fun onItemClick(view: View, position: Int) {  // recyclerView tıklamaları
        val selectedItem = viewmodel.popularMovieList.value?.get(position)
        selectedItem?.let {
            PopularMovieDetailActivity.popularMovieDetailActivityCreater(it.id, it.title, this)
        }
    }

    override fun onPause() {
        super.onPause()
        lastPosition = (binding.recyclerView.layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()
    }

    override fun onResume() {
        super.onResume()
        (binding.recyclerView.layoutManager as LinearLayoutManager).scrollToPosition(lastPosition)
        lastPosition = 0
    }
}
