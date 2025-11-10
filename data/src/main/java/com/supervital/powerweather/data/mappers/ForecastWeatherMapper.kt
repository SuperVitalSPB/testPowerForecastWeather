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
        tempC = this.tempC,
        condition = this.condition?.map(),
    )

fun DayEntity.map() =
    DayInfo(
        maxtempC = this.maxtempC,
        mintempC = this.mintempC,
        condition = this.condition?.map(),
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
        tempC = this.tempC,
        condition = condition?.map(),
    )

fun LocationEntity.map() =
    LocationInfo(
        name = this.name,
        region = this.region,
    )
    
    