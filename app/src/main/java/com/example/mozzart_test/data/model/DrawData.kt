package com.example.mozzart_test.data.model

data class DrawData(
    val drawBreak: Int,
    val drawId: Long?,
    val drawTime: Long,
    val gameId: Int,
    val pricePoints: PricePoints,
    val prizeCategories: List<PrizeCategory>,
    val status: String,
    val visualDraw: Int,
    val wagerStatistics: WagerStatistics
)

fun DrawData.asDraw() = Draw(
    drawId = drawId,
    drawTime = drawTime
)