package com.umutcansahin.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.umutcansahin.data.BuildConfig
import com.umutcansahin.data.api.MovieApi
import com.umutcansahin.data.response.MovieResult

class MoviePagingSource(
    private val movieApi: MovieApi
) : PagingSource<Int, MovieResult>() {

    override fun getRefreshKey(state: PagingState<Int, MovieResult>): Int? {
        return state.anchorPosition?.let {anchorPosition->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieResult> {
        val position = params.key ?: 1
        return try {
            val response = movieApi.getPopularMovie(BuildConfig.API_KEY, position)
            val nextKey = if (response.totalPages == null) {
                null
            } else if (position < response.totalPages) {
                position + 1
            } else {
                null
            }
            LoadResult.Page(
                data = response.results ?: emptyList(),
                prevKey = if (position > 1) position - 1 else null,
                nextKey = nextKey
            )
        }catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}