package com.umutcansahin.presentation.home_detail_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umutcansahin.domain.use_case.GetMovieByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeDetailViewModel @Inject constructor(
    private val getMovieByIdUseCase: GetMovieByIdUseCase
) : ViewModel() {

    private val _singleMovie = MutableStateFlow<HomeDetailUiState>(HomeDetailUiState.Loading)
    val singleMovie get() = _singleMovie.asStateFlow()
    fun getMovieById(movieId: Int) {
        viewModelScope.launch {
            _singleMovie.value = HomeDetailUiState.Success(getMovieByIdUseCase(movieId = movieId))
        }
    }
}
