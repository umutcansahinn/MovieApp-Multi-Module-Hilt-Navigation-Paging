package com.umutcansahin.presentation.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.umutcansahin.data.repository.MovieRepositoryImpl
import com.umutcansahin.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _popularMovie = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val popularMovie get() = _popularMovie.asStateFlow()

    init {
        getPopularMovie()
    }

    private fun getPopularMovie() {
        viewModelScope.launch {
            movieRepository.getPopularMovie().cachedIn(viewModelScope).collect {
                _popularMovie.value = HomeUiState.Success(it)
            }
        }
    }
}