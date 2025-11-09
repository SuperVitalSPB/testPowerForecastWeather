package com.supervital.powerweather.repository

import com.supervital.powerweather.models.ForecastWeatherInfo

interface ForecastWeatherRepository {

    suspend fun getForecastWeather(
        key: String,
        place: String,
        days: Int
    ): ForecastWeatherInfo

}