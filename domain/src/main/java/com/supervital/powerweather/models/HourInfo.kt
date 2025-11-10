package com.supervital.powerweather.models

data class HourInfo(
    val timeEpoch    : Long?       = null,
    val tempC        : Double?    = null,
    val condition    : ConditionInfo? = null,
)