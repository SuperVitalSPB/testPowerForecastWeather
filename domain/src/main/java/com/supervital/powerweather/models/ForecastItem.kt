package com.supervital.powerweather.models

import com.supervital.powerweather.models.ForecastWeatherInfo.Companion.EMPTY_STRING
import com.supervital.powerweather.models.ForecastWeatherInfo.Companion.FORMAT_DATE
import com.supervital.powerweather.models.ForecastWeatherInfo.Companion.FORMAT_TIME
import com.supervital.powerweather.models.ForecastWeatherInfo.Companion.PREFIX_IMAGE
import com.supervital.powerweather.models.ForecastWeatherInfo.Companion.TYPE_SYM_TEMP_C
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

data class ForecastItem(
    val timeEpoch: Long?,
    val condition: ConditionInfo?,
    val temperature: String? = null,
    val maxTempC: String? = null,
    val minTempC: String? = null

) {
    constructor(hourInfo: HourInfo) : this(
        timeEpoch = hourInfo.timeEpoch,
        condition = hourInfo.condition,
        temperature = hourInfo.tempC.toString(),
    )

    constructor(
        timeEpoch: Long,
        dayInfo: DayInfo
    ) : this(
        timeEpoch = timeEpoch,
        condition = dayInfo.condition,
        maxTempC = dayInfo.maxtempC.toString(),
        minTempC = dayInfo.mintempC.toString()
    )

    val isHourItem = maxTempC == null && minTempC == null

    fun getConditionText(): String {
        return condition?.text ?: EMPTY_STRING
    }

    private fun getTemperatureHour(): String {
        return temperature?.let {
            "$it$TYPE_SYM_TEMP_C"
        } ?: EMPTY_STRING
    }

    private fun getTemperatureMaxMin(): String {
        return maxTempC?.let {
            "${it}$TYPE_SYM_TEMP_C/${minTempC}$TYPE_SYM_TEMP_C"
        } ?: EMPTY_STRING
    }

    fun getTemperatureCommon() =
        if (isHourItem) {
            getTemperatureHour()
        } else {
            getTemperatureMaxMin()
        }


    fun getConditionIconUrl(): String {
        return "$PREFIX_IMAGE${condition?.icon}"
    }

    fun getDateHour() =
        if (isHourItem) {
            getHour()
        } else {
            getDate()
        }

    private fun getDate(): String {
        return timeEpoch?.let {
            val instant = Instant.ofEpochSecond(it)
            val localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime()
            val formatter = DateTimeFormatter.ofPattern(FORMAT_DATE)
            localDateTime.format(formatter)
        } ?: EMPTY_STRING
    }

    private fun getHour(): String {
        return timeEpoch?.let {
            val instant = Instant.ofEpochSecond(it)
            val localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime()
            val formatter = DateTimeFormatter.ofPattern(FORMAT_TIME)
            localDateTime.format(formatter)
        } ?: EMPTY_STRING
    }

}