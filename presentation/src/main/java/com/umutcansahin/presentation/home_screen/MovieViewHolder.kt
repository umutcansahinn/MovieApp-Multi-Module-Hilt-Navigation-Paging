package com.umutcansahin.presentation.home_screen

import androidx.recyclerview.widget.RecyclerView
import com.umutcansahin.common.Constants.BASE_IMAGE_URL
import com.umutcansahin.common.loadImage
import com.umutcansahin.data.response.MovieResult
import com.umutcansahin.presentation.databinding.PopularMovieItemBinding

class MovieViewHolder(
    private val binding: PopularMovieItemBinding,
    private val itemClickListener: ((Int) -> Unit)
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movieResult: MovieResult) {
        binding.ivPicture.loadImage(BASE_IMAGE_URL+movieResult.posterPath)
        binding.tvTitle.text = movieResult.title
        binding.tvTitle.setOnClickListener {
            itemClickListener.invoke(movieResult.id!!)
        }
    }
}