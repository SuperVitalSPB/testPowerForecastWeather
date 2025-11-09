package com.supervital.powerweather.di

import com.supervital.powerweather.repository.ForecastWeatherRepository
import com.supervital.powerweather.usecase.ForecastWeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class ModuleUseCase {

    @Provides
    @ViewModelScoped
    fun provideForecastWeatherUseCase(forecastWeatherRepository: ForecastWeatherRepository) =
        ForecastWeatherUseCase(forecastWeatherRepository)

}