package com.supervital.powerweather.models

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

data class ForecastWeatherInfo(
    val location: LocationInfo? = null,
    val current: CurrentInfo? = null,
    val forecast: ForecastInfo? = null
) {

    fun getDateMain(): String {
        return current?.let {
            val instant = Instant.ofEpochSecond(it.lastUpdatedEpoch)
            val localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime()
            val formatter = DateTimeFormatter.ofPattern(FORMAT_DATE)
            localDateTime.format(formatter)
        } ?: EMPTY_STRING
    }

    fun getCity(): String {
        return location?.region ?: EMPTY_STRING
    }

    fun getCurrentTemperature(): String {
        return current?.let {
            "${it.tempC}$TYPE_SYM_TEMP_C"
        } ?: EMPTY_STRING
    }

    fun getConditionText(): String {
        return current?.condition?.text ?: EMPTY_STRING
    }

    fun getTemperatureMaxMin(): String {
        return forecast?.forecastday[0]?.day?.let {
            "${it.maxtempC}$TYPE_SYM_TEMP_C/${it.mintempC}$TYPE_SYM_TEMP_C"
        } ?: EMPTY_STRING
    }

    fun getIconUrl(): String {
        return "$PREFIX_IMAGE${current?.condition?.icon}"
    }

    fun getForecastByHour(): List<ForecastItem> {
        return forecast?.forecastday[0]?.hour?.map { ForecastItem(it) } ?: emptyList()
    }

    fun getForecastByDay(): List<ForecastItem> {
        return forecast?.forecastday?.filterIndexed { index, item ->
            index > 0 && item.day != null && item.dateEpoch != null
        }?.map { item ->
            ForecastItem(item.dateEpoch!!, item.day!!)
        } ?: emptyList()
    }

    companion object {
        const val EMPTY_STRING = ""
        const val TYPE_SYM_TEMP_C = "ºC"
        const val FORMAT_DATE = "dd.MM.yyyy"
        const val FORMAT_TIME = "HH:mm"
        const val PREFIX_IMAGE = "https:"
    }
}
