package com.bd.popularmovies.ui.adapter

import android.arch.paging.PagedListAdapter
import android.databinding.DataBindingUtil
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bd.popularmovies.R
import com.bd.popularmovies.databinding.ItemPopularMovieListBinding
import com.bd.popularmovies.model.data.PopularMovieModel


class PopularMovieListAdapter : PagedListAdapter<PopularMovieModel, PopularMovieListAdapter.ViewHolder>(diffUtilCallBack) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_popular_movie_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)
        holder.binding?.data = movie  // datayı bind ettik ve herkes mutlu.
    }


    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var binding: ItemPopularMovieListBinding? = DataBindingUtil.bind(v)
    }


    companion object {
        private val diffUtilCallBack =
            object : DiffUtil.ItemCallback<PopularMovieModel>() {
                override fun areItemsTheSame(oldItem: PopularMovieModel, newItem: PopularMovieModel): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(oldItem: PopularMovieModel, newItem: PopularMovieModel): Boolean {
                    return oldItem.title == newItem.title && oldItem.release_date == newItem.release_date
                }
            }
    }
}