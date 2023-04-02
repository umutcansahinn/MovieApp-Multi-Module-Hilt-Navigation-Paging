package com.umutcansahin.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.umutcansahin.common.Constants.NETWORK_PAGE_SIZE
import com.umutcansahin.common.MovieEnum
import com.umutcansahin.data.api.MovieApi
import com.umutcansahin.data.paging_source.MoviePagingSource
import com.umutcansahin.data.response.MovieResult
import com.umutcansahin.data.response.single_movie.SingleMovieResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieApi: MovieApi
) {

    fun getMovie(): Flow<PagingData<MovieResult>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                MoviePagingSource(
                    movieApi = movieApi,
                    movieEnum = MovieEnum.POPULAR_MOVIE
                )
            }
        ).flow
    }

    suspend fun getMovieById(movieId: Int): SingleMovieResponse {
        return movieApi.getMovieById(movieId)
    }

    fun searchMovie(query: String): Flow<PagingData<MovieResult>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE
            ),
            pagingSourceFactory = {
                MoviePagingSource(
                    movieApi = movieApi,
                    query = query,
                    movieEnum = MovieEnum.SEARCH_MOVIE
                )
            }
        ).flow
    }
}