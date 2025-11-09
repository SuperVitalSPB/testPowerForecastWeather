package com.supervital.powerweather.feature.main

import androidx.lifecycle.ViewModel
import com.supervital.powerweather.usecase.ForecastWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val forecastWeatherUseCase: ForecastWeatherUseCase
) : ViewModel() {

    var place = ForecastWeatherUseCase.PLACE_MOS

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    suspend fun fetchData() {
        _uiState.value = UiState.Loading
        _uiState.value = forecastWeatherUseCase(place).fold(
            onSuccess = { value -> UiState.Success(value) },
            onFailure = { exception -> UiState.Error( "${exception.message}") }
        )
    }

    fun setPlaceSpb() {
        place = ForecastWeatherUseCase.PLACE_SPB
    }

}