package com.supervital.powerweather.models

data class CurrentInfo (
    val lastUpdatedEpoch : Long,
    val lastUpdated      : String?    = null,
    val tempC            : Double?    = null,
    val tempF            : Double?    = null,
    val isDay            : Int?       = null,
    val condition        : ConditionInfo? = null,
    val windKph          : Double?    = null,
    val windDegree       : Int?       = null,
    val windDir          : String?    = null,
    val precipMm         : Double?    = null,
    val precipIn         : Int?       = null,
    val humidity         : Int?       = null,
    val cloud            : Int?       = null,
    val feelslikeC       : Double?    = null,
    val feelslikeF       : Double?    = null,
    val gustKph          : Double?    = null
)