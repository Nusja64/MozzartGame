package com.example.mozzart_test.data.model

data class ResultData(
    val content: List<Content>? = null,
    val totalPages: Int? = null,
    val totalElements: Int? = null,
    val numberOfElements: Int? = null,
    val last: Boolean? = null,
    val sort: List<Sort>? = null,
    val first: Boolean? = null,
    val size: Int? = null,
    val number: Int? = null,
)

data class Sort(
    val direction: String? = null,
    val property: String? = null,
    val nullHandling: String? = null,
    val ignoreCase: Boolean? = null,
    val descending: Boolean? = null,
    val ascending: Boolean? = null,
)

data class Content(
    val gameId: Int? = null,
    val drawId: Long? = null,
    val drawTime: Long? = null,
    val status: String? = null,
    val drawBreak: Int? = null,
    val visualDraw: Long? = null,
    val pricePoints: PricePoints? = null,
    val winningNumbers: WinningNumbers? = null,
    val prizeCategories: List<PrizeCategory?>? = null,
    val wagerStatistics: WagerStatistics? = null
)


data class Sidebets(
    val evenNumbersCount: Int? = null,
    val oddNumbersCount: Int? = null,
    val winningColumn: Int? = null,
    val winningParity: String? = null,
    val oddNumbers: List<Int>? = null,
    val evenNumbers: List<Int>? = null,
    val columnNumbers: HashMap<String, List<Int>>? = null,
)


data class WinningNumbers(
    val list: List<Int>?,
    val bonus: List<Int>? = null,
    val sidebets: Sidebets? = null,
)

fun ResultData.asResult(drawId: Long) = ResultDraw(
    drawId = drawId,
    drawTime = this.content?.find { it.drawId == drawId }?.drawTime,
    winningNumbers = this.content?.find { it.drawId == drawId }?.winningNumbers?.list
)

