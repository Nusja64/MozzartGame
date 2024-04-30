package com.example.mozzart_test.utils

import android.content.res.ColorStateList
import android.graphics.Color

object ColorConstants {

    private val YELLOW = Color.parseColor("#FFFF00")
    private val ORANGE = Color.parseColor("#FFA500")
    private val RED = Color.parseColor("#FF0000")
    private val PINK = Color.parseColor("#FFC0CB")
    private val PURPLE = Color.parseColor("#A020F0")
    private val CYAN = Color.parseColor("#00FFFF")
    private val GREEN = Color.parseColor("#008000")
    private val BLUE = Color.parseColor("#0000FF")

    fun getColor(ball: Int): ColorStateList {
        return when (ball) {
            in 1..10 -> ColorStateList.valueOf(YELLOW)
            in 11..20 -> ColorStateList.valueOf(ORANGE)
            in 21..30 -> ColorStateList.valueOf(RED)
            in 31..40 -> ColorStateList.valueOf(PINK)
            in 41..50 -> ColorStateList.valueOf(PURPLE)
            in 51..60 -> ColorStateList.valueOf(CYAN)
            in 61..70 -> ColorStateList.valueOf(GREEN)
            else -> ColorStateList.valueOf(BLUE)
        }
    }

}
