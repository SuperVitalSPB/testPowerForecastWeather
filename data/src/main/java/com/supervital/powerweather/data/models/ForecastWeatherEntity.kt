package com.supervital.powerweather.data.models

data class ForecastWeatherEntity(
    val location: LocationEntity? = null,
    val current: CurrentEntity? = null,
    val forecast: ForecastEntity? = null
)
