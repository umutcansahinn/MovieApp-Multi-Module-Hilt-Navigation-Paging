package com.umutcansahin.presentation.home_screen

import androidx.annotation.StringRes
import androidx.paging.PagingData
import com.umutcansahin.data.response.MovieResult

sealed interface HomeUiState {
    object Loading : HomeUiState
    data class Success(val data: PagingData<MovieResult>) : HomeUiState
    data class Error(@StringRes val message: Int) : HomeUiState
}