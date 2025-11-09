package com.supervital.powerweather.models

data class DayInfo (
    val maxtempC          : Double?    = null,
    val maxtempF          : Double?    = null,
    val mintempC          : Double?    = null,
    val mintempF          : Double?    = null,
    val avgtempC          : Double?    = null,
    val avgtempF          : Double?    = null,
    val maxwindMph        : Double?    = null,
    val maxwindKph        : Double?    = null,
    val totalprecipMm     : Double?    = null,
    val totalprecipIn     : Double?    = null,
    val totalsnowCm       : Int?       = null,
    val avgvisKm          : Double?    = null,
    val avgvisMiles       : Int?       = null,
    val avghumidity       : Int?       = null,
    val dailyWillItRain   : Int?       = null,
    val dailyChanceOfRain : Int?       = null,
    val dailyWillItSnow   : Int?       = null,
    val dailyChanceOfSnow : Int?       = null,
    val condition         : ConditionInfo? = null,
    val uv                : Double?    = null
)