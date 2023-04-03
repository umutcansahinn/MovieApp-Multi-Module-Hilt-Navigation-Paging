package com.umutcansahin.presentation.home_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.umutcansahin.data.response.MovieResult
import com.umutcansahin.domain.model.popular_movie.MovieResultUiModel
import com.umutcansahin.presentation.databinding.PopularMovieItemBinding

class MovieAdapter( private val itemClickListener: ((Int) -> Unit)) : PagingDataAdapter<MovieResultUiModel, MovieViewHolder>(DiffUtils) {

    object DiffUtils : DiffUtil.ItemCallback<MovieResultUiModel>() {
        override fun areItemsTheSame(oldItem: MovieResultUiModel, newItem: MovieResultUiModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieResultUiModel, newItem: MovieResultUiModel): Boolean {
            return oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movieResultItem = getItem(position)
        if (movieResultItem != null) {
            holder.bind(movieResultItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            PopularMovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            itemClickListener
        )
    }
}