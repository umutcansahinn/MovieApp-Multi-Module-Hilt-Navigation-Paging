package com.umutcansahin.presentation.search_screen

import androidx.annotation.StringRes
import androidx.paging.PagingData
import com.umutcansahin.data.response.MovieResult

sealed interface SearchUiState {
    object Loading : SearchUiState
    data class Success(val data: PagingData<MovieResult>) : SearchUiState
    data class Error(@StringRes val message: Int) : SearchUiState
}