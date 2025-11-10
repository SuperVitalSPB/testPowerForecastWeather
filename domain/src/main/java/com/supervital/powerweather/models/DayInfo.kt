package com.supervital.powerweather.models

data class DayInfo (
    val maxtempC          : Double?    = null,
    val mintempC          : Double?    = null,
    val condition         : ConditionInfo? = null,
)