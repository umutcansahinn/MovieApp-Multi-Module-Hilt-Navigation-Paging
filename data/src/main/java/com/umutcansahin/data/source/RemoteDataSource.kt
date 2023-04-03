package com.umutcansahin.data.source

import androidx.paging.PagingData
import com.umutcansahin.data.response.MovieResult
import com.umutcansahin.data.response.single_movie.SingleMovieResponse
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getPopularMovie(): Flow<PagingData<MovieResult>>
    suspend fun getMovieById(movieId: Int): SingleMovieResponse
    fun searchMovie(query: String): Flow<PagingData<MovieResult>>
}