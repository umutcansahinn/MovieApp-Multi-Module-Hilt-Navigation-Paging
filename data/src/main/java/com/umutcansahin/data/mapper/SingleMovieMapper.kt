package com.umutcansahin.data.mapper

import com.umutcansahin.common.orEmpty
import com.umutcansahin.common.orEmptyList
import com.umutcansahin.common.orFalse
import com.umutcansahin.common.orZero
import com.umutcansahin.data.response.single_movie.*
import com.umutcansahin.domain.model.single_movie.*

fun Genre.toMap(): GenreUiModel {
    return GenreUiModel(
        id = id.orZero(),
        name = name.orEmpty()
    )
}

fun ProductionCompany.toMap(): ProductionCompanyUiModel {
    return ProductionCompanyUiModel(
        id = id.orZero(),
        logoPath = logoPath.orEmpty(),
        name = name.orEmpty(),
        originCountry = originCountry.orEmpty()
    )
}

fun ProductionCountry.toMap(): ProductionCountryUiModel {
    return ProductionCountryUiModel(
        iso31661 = iso31661.orEmpty(),
        name = name.orEmpty()
    )
}

fun SpokenLanguage.toMap(): SpokenLanguageUiModel {
    return SpokenLanguageUiModel(
        englishName = englishName.orEmpty(),
        iso6391 = iso6391.orEmpty(),
        name = name.orEmpty()
    )
}

fun SingleMovieResponse.toMap(): SingleMovieUiModel {
    return SingleMovieUiModel(
        adult = adult.orFalse(),
        backdropPath = backdropPath.orEmpty(),
        belongsToCollection = belongsToCollection.orEmpty(),
        budget = budget.orZero(),
        genres = genres.orEmptyList().map { it.toMap() },
        homepage = homepage.orEmpty(),
        id = id.orZero(),
        imdbId = imdbId.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        originalTitle = originalTitle.orEmpty(),
        overview = overview.orEmpty(),
        popularity = popularity.orZero(),
        posterPath = posterPath.orEmpty(),
        productionCompanies = productionCompanies.orEmptyList().map { it.toMap() },
        productionCountries = productionCountries.orEmptyList().map { it.toMap() },
        releaseDate = releaseDate.orEmpty(),
        revenue = revenue.orZero(),
        runtime = runtime.orZero(),
        spokenLanguages = spokenLanguages.orEmptyList().map { it.toMap() },
        status = status.orEmpty(),
        tagline = tagline.orEmpty(),
        title = title.orEmpty(),
        video = video.orFalse(),
        voteAverage = voteAverage.orZero(),
        voteCount = voteCount.orZero()
    )
}