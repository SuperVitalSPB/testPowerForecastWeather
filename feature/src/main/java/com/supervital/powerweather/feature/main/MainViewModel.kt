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

    private var indexPlace = 0

    private var places = listOf<String>(
        ForecastWeatherUseCase.PLACE_MOS,
        ForecastWeatherUseCase.PLACE_SPB,
        ForecastWeatherUseCase.PLACE_NOR
    )

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    suspend fun fetchData() {
        _uiState.value = UiState.Loading
        _uiState.value = forecastWeatherUseCase(places[indexPlace]).fold(
            onSuccess = { value -> UiState.Success(value) },
            onFailure = { exception -> UiState.Error("${exception.message}") }
        )
    }

    fun incIndexPlace() {
        indexPlace = (indexPlace + 1) % 3
    }

}