package com.example.mozzart_test.utils

import com.example.mozzart_test.utils.Constants.SDF_HOUR_MINUTE
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale


fun Long.toHourMinuteFormat(): String {
    val calendar = Calendar.getInstance().apply {
        timeInMillis = this@toHourMinuteFormat
    }
    val hourFormat = SimpleDateFormat(SDF_HOUR_MINUTE, Locale.getDefault())
    return hourFormat.format(calendar.time)
}

fun Long.getRemainingTime(): String {
    val currentTime = Calendar.getInstance().timeInMillis
    val remainingTime = this@getRemainingTime - currentTime

    val hours = remainingTime / Constants.MILLIS_IN_HOUR
    val minutes =
        (remainingTime % Constants.MILLIS_IN_HOUR) / (Constants.MILLIS_IN_SECOND * Constants.SECONDS_IN_MINUTE)
    val seconds =
        ((remainingTime % Constants.MILLIS_IN_HOUR) % (Constants.MILLIS_IN_SECOND * Constants.SECONDS_IN_MINUTE)) / Constants.MILLIS_IN_SECOND
    Timber.d("Hours : $hours , minutes $minutes , seconds $seconds")

    return when {
        hours > 0 -> String.format(Constants.TIME_FORMAT_WITH_HOURS, hours, minutes, seconds)
        minutes > 0 -> String.format(Constants.TIME_FORMAT_WITHOUT_HOURS, minutes, seconds)
        else -> String.format(Constants.TIME_FORMAT_ONLY_SECONDS, seconds)
    }
}

