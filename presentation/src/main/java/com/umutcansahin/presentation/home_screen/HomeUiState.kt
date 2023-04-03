package com.umutcansahin.presentation.home_screen

import androidx.annotation.StringRes
import androidx.paging.PagingData
import com.umutcansahin.domain.model.popular_movie.MovieResultUiModel

sealed interface HomeUiState {
    object Loading : HomeUiState
    data class Success(val data: PagingData<MovieResultUiModel>) : HomeUiState
    data class Error(@StringRes val message: Int) : HomeUiState
}