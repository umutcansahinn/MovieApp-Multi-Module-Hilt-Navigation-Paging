package com.umutcansahin.data.mapper

import com.umutcansahin.common.orEmptyList
import com.umutcansahin.common.orFalse
import com.umutcansahin.common.orZero
import com.umutcansahin.data.response.MovieResult
import com.umutcansahin.data.response.PopularMovieResponse
import com.umutcansahin.domain.model.popular_movie.MovieResultUiModel
import com.umutcansahin.domain.model.popular_movie.PopularMovieUiModel

fun MovieResult.toMap(): MovieResultUiModel {
    return MovieResultUiModel(
        adult = adult.orFalse(),
        backdropPath = backdropPath.orEmpty(),
        genreIds = genreIds.orEmptyList(),
        id = id.orZero(),
        originalLanguage = originalLanguage.orEmpty(),
        originalTitle = originalTitle.orEmpty(),
        overview = overview.orEmpty(),
        popularity = popularity.orZero(),
        posterPath = posterPath.orEmpty(),
        releaseDate = releaseDate.orEmpty(),
        title = title.orEmpty(),
        video = video.orFalse(),
        voteAverage = voteAverage.orZero(),
        voteCount = voteCount.orZero()
    )
}

fun PopularMovieResponse.toMap(): PopularMovieUiModel {
    return PopularMovieUiModel(
        page = page.orZero(),
        results = results.orEmptyList().map { it.toMap() },
        totalPages = totalPages.orZero(),
        totalResults = totalResults.orZero()
    )
}