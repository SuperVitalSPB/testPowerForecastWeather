package com.supervital.powerweather.data.di

import com.supervital.powerweather.repository.ForecastWeatherRepository
import com.supervital.powerweather.data.api.ForecastWeatherService
import com.supervital.powerweather.data.repository.ForecastWeatherRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ModuleRepositories {

    @Provides
    @Singleton
    fun provideForecastWeatherRepository(forecastWeatherService: ForecastWeatherService): ForecastWeatherRepository =
        ForecastWeatherRepositoryImpl(forecastWeatherService)

}