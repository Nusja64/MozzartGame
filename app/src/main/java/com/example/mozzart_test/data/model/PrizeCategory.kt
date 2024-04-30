package com.example.mozzart_test.data.model

data class PrizeCategory(
    val categoryType: Int,
    val distributed: Double,
    val divident: Double,
    val fixed: Double,
    val gameType: String,
    val id: Int,
    val jackpot: Double,
    val winners: Int
)