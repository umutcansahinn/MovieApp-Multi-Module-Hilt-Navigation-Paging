package com.umutcansahin.domain.repository

import androidx.paging.PagingData
import com.umutcansahin.domain.model.popular_movie.MovieResultUiModel
import com.umutcansahin.domain.model.single_movie.SingleMovieUiModel
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getPopularMovie(): Flow<PagingData<MovieResultUiModel>>
    suspend fun getMovieById(movieId: Int): SingleMovieUiModel
    fun searchMovie(query: String): Flow<PagingData<MovieResultUiModel>>
}