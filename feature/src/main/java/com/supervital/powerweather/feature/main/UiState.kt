package com.supervital.powerweather.feature.main

import com.supervital.powerweather.models.ForecastWeatherInfo

sealed class UiState {
    object Loading : UiState()
    data class Success(val data: ForecastWeatherInfo) : UiState()
    data class Error(val message: String) : UiState()
}