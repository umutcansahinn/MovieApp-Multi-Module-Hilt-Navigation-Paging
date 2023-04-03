package com.umutcansahin.domain.use_case

import androidx.paging.PagingData
import com.umutcansahin.domain.model.popular_movie.MovieResultUiModel
import com.umutcansahin.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(query: String): Flow<PagingData<MovieResultUiModel>> = repository.searchMovie(query)
}