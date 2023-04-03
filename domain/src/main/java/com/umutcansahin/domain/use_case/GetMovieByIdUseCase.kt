package com.umutcansahin.domain.use_case

import com.umutcansahin.domain.model.single_movie.SingleMovieUiModel
import com.umutcansahin.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieByIdUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(movieId: Int): SingleMovieUiModel =
        repository.getMovieById(movieId = movieId)
}


