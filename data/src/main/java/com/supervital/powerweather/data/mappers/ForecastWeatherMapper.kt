package com.supervital.powerweather.data.mappers

import com.supervital.powerweather.data.models.ConditionEntity
import com.supervital.powerweather.data.models.CurrentEntity
import com.supervital.powerweather.data.models.DayEntity
import com.supervital.powerweather.data.models.ForecastEntity
import com.supervital.powerweather.data.models.ForecastWeatherEntity
import com.supervital.powerweather.data.models.ForecastdayEntity
import com.supervital.powerweather.data.models.HourEntity
import com.supervital.powerweather.data.models.LocationEntity
import com.supervital.powerweather.models.ConditionInfo
import com.supervital.powerweather.models.CurrentInfo
import com.supervital.powerweather.models.DayInfo
import com.supervital.powerweather.models.ForecastInfo
import com.supervital.powerweather.models.ForecastWeatherInfo
import com.supervital.powerweather.models.ForecastdayInfo
import com.supervital.powerweather.models.HourInfo
import com.supervital.powerweather.models.LocationInfo

fun ConditionEntity.map() =
    ConditionInfo(
        text = this.text,
        icon = this.icon,
        code = this.code
    )

fun CurrentEntity.map() =
    CurrentInfo(
        lastUpdatedEpoch = this.lastUpdatedEpoch,
        lastUpdated = this.lastUpdated,
        tempC = this.tempC,
        tempF = this.tempF,
        isDay = this.isDay,
        condition = this.condition?.map(),
        windKph = this.windKph,
        windDegree = this.windDegree,
        windDir = this.windDir,
        precipMm = this.precipMm,
        precipIn = this.precipIn,
        humidity = this.humidity,
        cloud = this.cloud,
        feelslikeC = this.feelslikeC,
        feelslikeF = this.feelslikeF,
        gustKph = this.gustKph
    )

fun DayEntity.map() =
    DayInfo(
        maxtempC = this.maxtempC,
        maxtempF = this.maxtempF,
        mintempC = this.mintempC,
        mintempF = this.mintempF,
        avgtempC = this.avgtempC,
        avgtempF = this.avgtempF,
        maxwindMph = this.maxwindMph,
        maxwindKph = this.maxwindKph,
        totalprecipMm = this.totalprecipMm,
        totalprecipIn = this.totalprecipIn,
        totalsnowCm = this.totalsnowCm,
        avgvisKm = this.avgvisKm,
        avgvisMiles = this.avgvisMiles,
        avghumidity = this.avghumidity,
        dailyWillItRain = this.dailyWillItRain,
        dailyChanceOfRain = this.dailyChanceOfRain,
        dailyWillItSnow = this.dailyWillItSnow,
        dailyChanceOfSnow = this.dailyChanceOfSnow,
        condition = this.condition?.map(),
        uv = this.uv
    )

fun ForecastdayEntity.map() =
    ForecastdayInfo(
        dateEpoch = this.dateEpoch,
        day = this.day?.map(),
        hour = this.hour.map {
            it.map()
        }
    )


fun ForecastEntity.map() =
    ForecastInfo(
        forecastday = this.forecastday.map {
            it.map()
        }
    )


fun ForecastWeatherEntity.map() =
    ForecastWeatherInfo(
        location = this.location?.map(),
        current = this.current?.map(),
        forecast = this.forecast?.map()
    )

fun HourEntity.map() =
    HourInfo(
        timeEpoch = this.timeEpoch,
        time = this.time,
        tempC = this.tempC,
        tempF = this.tempF,
        isDay = this.isDay,
        condition = condition?.map(),
        windMph = this.windMph,
        windKph = this.windKph,
        windDegree = this.windDegree,
        windDir = this.windDir,
        pressureMb = this.pressureMb,
        pressureIn = this.pressureIn,
        precipMm = this.precipMm,
        precipIn = this.precipIn,
        snowCm = this.snowCm,
        humidity = this.humidity,
        cloud = this.cloud,
        feelslikeC = this.feelslikeC,
        feelslikeF = this.feelslikeF,
        windchillC = this.windchillC,
        windchillF = this.windchillF,
        heatindexC = this.heatindexC,
        heatindexF = this.heatindexF,
        dewpointC = this.dewpointC,
        dewpointF = this.dewpointF,
        willItRain = this.willItRain,
        chanceOfRain = this.chanceOfRain,
        willItSnow = this.willItSnow,
        chanceOfSnow = this.chanceOfSnow,
        visKm = this.visKm,
        visMiles = this.visMiles,
        gustMph = this.gustMph,
        gustKph = this.gustKph
    )

fun LocationEntity.map() =
    LocationInfo(
        name = this.name,
        region = this.region,
        country = this.country,
        lat = this.lat,
        lon = this.lon,
        tzId = this.tzId,
        localtimeEpoch = this.localtimeEpoch,
        localtime = this.localtime
    )
    
    