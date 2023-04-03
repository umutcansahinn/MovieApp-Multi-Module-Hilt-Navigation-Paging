package com.umutcansahin.domain.model.single_movie

data class SingleMovieUiModel(
    val adult: Boolean,
    val backdropPath: String,
    val belongsToCollection: Any,
    val budget: Int,
    val genres: List<GenreUiModel>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val productionCompanies: List<ProductionCompanyUiModel>,
    val productionCountries: List<ProductionCountryUiModel>,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val spokenLanguages: List<SpokenLanguageUiModel>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)

data class GenreUiModel(
    val id: Int,
    val name: String
)

data class ProductionCompanyUiModel(
    val id: Int,
    val logoPath: String,
    val name: String,
    val originCountry: String
)

data class ProductionCountryUiModel(
    val iso31661: String,
    val name: String
)

data class SpokenLanguageUiModel(
    val englishName: String,
    val iso6391: String,
    val name: String
)