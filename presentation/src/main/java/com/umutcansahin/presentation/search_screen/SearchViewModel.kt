package com.umutcansahin.presentation.search_screen

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
class SearchViewModel @Inject constructor(
   private val movieRepository: MovieRepository
) : ViewModel() {

    private val _searchMovie = MutableStateFlow<SearchUiState>(SearchUiState.Loading)
    val searchMovie get() = _searchMovie.asStateFlow()

    fun searchMovie(query: String) {
        viewModelScope.launch {
            movieRepository.searchMovie(query)
                .cachedIn(viewModelScope)
                .collect {
                    _searchMovie.value = SearchUiState.Success(it)
                }
        }
    }
}