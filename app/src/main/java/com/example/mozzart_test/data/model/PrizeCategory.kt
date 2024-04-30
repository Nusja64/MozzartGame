package com.example.mozzart_test.data.model

data class PrizeCategory(
    val categoryType: Int,
    val distributed: Int,
    val divident: Int,
    val fixed: Double,
    val gameType: String,
    val id: Int,
    val jackpot: Int,
    val winners: Int
)