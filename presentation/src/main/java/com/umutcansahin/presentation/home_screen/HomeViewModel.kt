package com.umutcansahin.presentation.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umutcansahin.data.api.MovieApi
import com.umutcansahin.data.response.PopularMovieResponse
import com.umutcansahin.presentation.BuildConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val api: MovieApi
) : ViewModel() {

    private val _popularMovie = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val popularMovie get() = _popularMovie.asStateFlow()

    init {
        getPopularMovie()
    }
    fun getPopularMovie() {
        viewModelScope.launch {
            _popularMovie.value = HomeUiState.Success(
                api.getPopularMovie(page = 2)
            )
        }
    }
}