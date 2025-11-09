package com.supervital.powerweather.models

class ForecastdayInfo (
    val dateEpoch : Long? = null,
    val day       : DayInfo? = null,
    val hour      : List<HourInfo> = arrayListOf()
)