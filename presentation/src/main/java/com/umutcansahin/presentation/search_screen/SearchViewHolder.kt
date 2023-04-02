package com.umutcansahin.presentation.search_screen

import androidx.recyclerview.widget.RecyclerView
import com.umutcansahin.common.Constants
import com.umutcansahin.common.loadImage
import com.umutcansahin.data.response.MovieResult
import com.umutcansahin.presentation.databinding.PopularMovieItemBinding

class SearchViewHolder(private val binding: PopularMovieItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(movieResult: MovieResult) {
        binding.ivPicture.loadImage(Constants.BASE_IMAGE_URL +movieResult.posterPath)
        binding.tvTitle.text = movieResult.title
    }
}