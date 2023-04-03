package com.umutcansahin.common

fun Int?.orZero() = this ?: 0
fun <T> List<T>?.orEmptyList() = this ?: emptyList()
fun Boolean?.orFalse() = this ?: false
fun String?.orEmpty() = this ?: ""
fun Double?.orZero() = this ?: 0.0
fun Any?.orEmpty() = this ?: ""