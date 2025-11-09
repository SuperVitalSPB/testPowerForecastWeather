package com.supervital.powerweather.data.repository

import com.supervital.powerweather.repository.ForecastWeatherRepository
import com.supervital.powerweather.data.api.ForecastWeatherService
import com.supervital.powerweather.data.mappers.map
import com.supervital.powerweather.models.ForecastWeatherInfo
import javax.inject.Inject

class ForecastWeatherRepositoryImpl @Inject constructor(
    val forecastWeatherService: ForecastWeatherService
) : ForecastWeatherRepository {

    override suspend fun getForecastWeather(
        key: String,
        place: String,
        days: Int
    ): ForecastWeatherInfo =
        forecastWeatherService.getForecastWeather(
            key,
            place,
            days
        ).map()

}