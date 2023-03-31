package com.umutcansahin.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.umutcansahin.data.api.MovieApi
import com.umutcansahin.data.paging_source.MoviePagingSource
import com.umutcansahin.data.response.MovieResult
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieApi: MovieApi
) {

    fun getMovie(): Flow<PagingData<MovieResult>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
               // enablePlaceholders = false
            ),
            pagingSourceFactory = { MoviePagingSource(movieApi) }
        ).flow
    }
    companion object {
        const val NETWORK_PAGE_SIZE = 50
    }
}