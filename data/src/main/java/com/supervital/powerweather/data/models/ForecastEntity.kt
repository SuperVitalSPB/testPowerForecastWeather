package com.supervital.powerweather.data.models

data class ForecastEntity(
    val forecastday: List<ForecastdayEntity> = arrayListOf()
)