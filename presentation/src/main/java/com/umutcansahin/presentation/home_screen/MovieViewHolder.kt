package com.umutcansahin.presentation.home_screen

import androidx.recyclerview.widget.RecyclerView
import com.umutcansahin.data.response.MovieResult
import com.umutcansahin.presentation.databinding.PopularMovieItemBinding

class MovieViewHolder(
    private val binding: PopularMovieItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movieResult: MovieResult) {
        binding.tvTitle.text = movieResult.title
    }
}