package com.umutcansahin.domain.model.popular_movie

data class PopularMovieUiModel(
    val page: Int,
    val results: List<MovieResultUiModel>,
    val totalPages: Int,
    val totalResults: Int
)

data class MovieResultUiModel(
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Int>,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)
