package com.example.mozzart_test.data.model

data class Rokaj(
    val content: List<Content>,
    val first: Boolean,
    val last: Boolean,
    val number: Int,
    val numberOfElements: Int,
    val size: Int,
    val sort: List<Sort>,
    val totalElements: Int,
    val totalPages: Int
)