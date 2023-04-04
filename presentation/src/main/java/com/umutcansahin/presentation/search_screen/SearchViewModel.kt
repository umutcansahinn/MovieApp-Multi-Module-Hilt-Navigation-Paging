package com.umutcansahin.presentation.search_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.umutcansahin.domain.use_case.GetPopularMovieUseCase
import com.umutcansahin.domain.use_case.SearchMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
   private val searchMovieUseCase: SearchMovieUseCase,
   private val popularMovieUseCase: GetPopularMovieUseCase
) : ViewModel() {

    private val _getMovie = MutableStateFlow<SearchUiState>(SearchUiState.Loading)
    val getMovie get() = _getMovie.asStateFlow()

    fun searchMovie(query: String) {
        viewModelScope.launch {
            searchMovieUseCase(query = query).cachedIn(viewModelScope).collect {
                _getMovie.value = SearchUiState.Success(it)
            }
        }
    }

    fun getPopularMovie() {
        viewModelScope.launch {
            popularMovieUseCase().cachedIn(viewModelScope).collect {
                _getMovie.value = SearchUiState.Success(it)
            }
        }
    }
}