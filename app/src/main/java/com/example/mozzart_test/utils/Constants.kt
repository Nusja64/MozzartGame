package com.example.mozzart_test.utils

object Constants {

    //api constants

    private const val GAME_ID = 1100
    private const val API_VERSION = "v3.0"
    private const val PAGE_SIZE = 20

    const val BASE_URL = "https://api.opap.gr/draws/$API_VERSION/"
    const val DRAWS_URL =
        "$BASE_URL$GAME_ID/upcoming/$PAGE_SIZE"

    const val GAME_DETAILS_URL = "https://api.opap.gr/draws/$API_VERSION/$GAME_ID/"
    const val RESULTS_URL =
        "$BASE_URL$GAME_ID/draw-date/{startDate}/{endDate}"

    //webview
    const val DRAW_ANIMATION_URL = "https://www.mozzartbet.com/sr/lotto-animation/26#/"

    const val DRAW_ID = "draw_id"
    //coupon constants
    val BALL_NUMBER = listOf("B.K.", "1", "2", "3", "4", "5", "6", "7")
    val QUOTE_VALUES = listOf("Kvota", "3.75", "14", "65", "275", "1350", "6500", "25000")

    //date and time
    const val PERIOD_TIME_IN_MILLIS = 1000L
    const val MILLIS_IN_SECOND = 1000
    const val SECONDS_IN_MINUTE = 60
    const val MINUTES_IN_HOUR = 60
    const val MILLIS_IN_HOUR = MILLIS_IN_SECOND * SECONDS_IN_MINUTE * MINUTES_IN_HOUR
    const val TIME_FORMAT_WITH_HOURS = "%02d:%02d:%02d"
    const val TIME_FORMAT_WITHOUT_HOURS = "%02d:%02d"
    const val TIME_FORMAT_ONLY_SECONDS = "%02d"
    const val SDF_HOUR_MINUTE = "HH:mm"
    const val SDF_HOUR_MINUTE_DAY = "yyyy-MM-dd"

    //views
    const val FRAGMENT_TAB_INVALID_POSITION = "Invalid position"
    const val FRAGMENT_TAB_COUPON_POSITION = 0
    const val FRAGMENT_TAB_DRAW_POSITION = 1
    const val FRAGMENT_TAB_RESULT_POSITION = 2
    const val FRAGMENT_TAB_COUNT = 3
    const val TAB_COUPON_NAME = "Talon"
    const val TAB_DRAW_NAME = "Izvlačenje uživo"
    const val TAB_RESULT_NAME = "Rezultati"
    const val RESULT_BALL_COLUMN = 7
}
