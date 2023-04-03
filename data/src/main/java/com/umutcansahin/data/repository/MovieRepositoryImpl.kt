package com.umutcansahin.data.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.umutcansahin.data.mapper.toMap
import com.umutcansahin.data.source.RemoteDataSource
import com.umutcansahin.domain.model.popular_movie.MovieResultUiModel
import com.umutcansahin.domain.model.single_movie.SingleMovieUiModel
import com.umutcansahin.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : MovieRepository {
    override fun getPopularMovie(): Flow<PagingData<MovieResultUiModel>> {
        return remoteDataSource.getPopularMovie().map { pagingData ->
            pagingData.map {
                it.toMap()
            }
        }
    }

    override suspend fun getMovieById(movieId: Int): SingleMovieUiModel {
        return remoteDataSource.getMovieById(movieId).toMap()
    }

    override fun searchMovie(query: String): Flow<PagingData<MovieResultUiModel>> {
        return remoteDataSource.searchMovie(query).map { pagingData ->
            pagingData.map {
                it.toMap()
            }
        }
    }
}