package com.supervital.powerweather.data.api

import com.supervital.powerweather.data.models.ForecastWeatherEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface ForecastWeatherService {

    @GET("forecast.json")
    suspend fun getForecastWeather(
        @Query(value = "key") key: String,
        @Query("q") place: String,
        @Query("days") days: Int
    ): ForecastWeatherEntity

}
