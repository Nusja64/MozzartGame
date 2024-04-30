package com.example.mozzart_test.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class DateTimeFormatter {

    //TODO WRITE UNIT TEST FOR THIS CLASS

    fun getDate(
        timeInMillis: Long?,
        format: SimpleDateFormat = SimpleDateFormat(
            Constants.SDF_HOUR_MINUTE_DAY,
            Locale.getDefault()
        ),
    ): String {
        val date = Date(timeInMillis ?: 0)
        return format.format(date)
    }

    /**
     * function that return start time od today in millis
     */
    fun getStartOfDayInMillis(): Long {
        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }
        return calendar.timeInMillis
    }

    /**
     * function that return end time od today in millis
     */
    fun getEndOfDayInMillis(): Long {
        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 23)
            set(Calendar.MINUTE, 59)
            set(Calendar.SECOND, 59)
            set(Calendar.MILLISECOND, 999)
        }
        return calendar.timeInMillis
    }

    /**
     * function that return start and end date in millis
     * @param numDays - define days interval between start end and date
     */
    fun getStartAndEndDates(numDays: Int): Pair<Long, Long> {
        val calendar = Calendar.getInstance()
        val startDate = calendar.timeInMillis
        calendar.add(Calendar.DAY_OF_MONTH, numDays)
        val endDate = calendar.timeInMillis

        return Pair(startDate, endDate)
    }
}