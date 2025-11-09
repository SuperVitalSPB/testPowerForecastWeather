package com.supervital.powerweather.usecase

import com.supervital.powerweather.models.ForecastWeatherInfo
import com.supervital.powerweather.repository.ForecastWeatherRepository
import javax.inject.Inject

class ForecastWeatherUseCase @Inject constructor(
    private val forecastWeatherRepository: ForecastWeatherRepository
) {

    suspend operator fun invoke(place: String = PLACE_MOS): Result<ForecastWeatherInfo> {
        try {
            return  Result.success(forecastWeatherRepository.getForecastWeather(KEY, place, DAYS))
        } catch (err: Exception) {
            return  Result.failure(err)
        }
    }


    companion object {
        const val KEY = "fa8b3df74d4042b9aa7135114252304" // Ключ
        const val PLACE_MOS = "55.7569,37.6151" // Москва, красная Площадь
        const val PLACE_SPB = "59.939,30.316"   // СПб, Дворцовая
        const val DAYS = 3                    // кол-во дней прогноз
    }
}