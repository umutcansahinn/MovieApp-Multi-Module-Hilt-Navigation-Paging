package com.umutcansahin.domain.use_case

import androidx.paging.PagingData
import com.umutcansahin.domain.model.popular_movie.MovieResultUiModel
import com.umutcansahin.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPopularMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(): Flow<PagingData<MovieResultUiModel>> = repository.getPopularMovie()
}