package com.umutcansahin.data.api

import com.umutcansahin.data.BuildConfig
import com.umutcansahin.data.response.PopularMovieResponse
import com.umutcansahin.data.response.single_movie.SingleMovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    suspend fun getPopularMovie(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): PopularMovieResponse

    @GET("movie/{movieId}")
    suspend fun getMovieById(
        @Path("movieId") movieId: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): SingleMovieResponse
}