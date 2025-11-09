package com.supervital.powerweather.data.di

// import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.supervital.powerweather.data.api.ForecastWeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val BASE_URL: String = "https://api.weatherapi.com/v1/"

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton // @ApplicationContext context: Context
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
//             .addInterceptor(ChuckerInterceptor(context))
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ForecastWeatherService {
        return retrofit.create(ForecastWeatherService::class.java)
    }
}