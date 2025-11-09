package com.supervital.powerweather.models

data class ForecastInfo(
    val forecastday : List<ForecastdayInfo> = arrayListOf()
)