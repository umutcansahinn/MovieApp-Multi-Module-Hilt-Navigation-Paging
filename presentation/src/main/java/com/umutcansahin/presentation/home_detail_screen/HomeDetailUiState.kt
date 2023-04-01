package com.umutcansahin.presentation.home_detail_screen

import androidx.annotation.StringRes
import com.umutcansahin.data.response.single_movie.SingleMovieResponse

sealed interface HomeDetailUiState {
    object Loading : HomeDetailUiState
    data class Success(val data: SingleMovieResponse) : HomeDetailUiState
    data class Error(@StringRes val message: Int) : HomeDetailUiState
}