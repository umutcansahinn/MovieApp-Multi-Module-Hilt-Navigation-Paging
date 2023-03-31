package com.umutcansahin.presentation.home_screen

import androidx.annotation.StringRes
import com.umutcansahin.data.response.PopularMovieResponse

sealed interface HomeUiState {
    object Loading : HomeUiState
    data class Success(val data: PopularMovieResponse?) : HomeUiState
    data class Error(@StringRes val message: Int) : HomeUiState
}