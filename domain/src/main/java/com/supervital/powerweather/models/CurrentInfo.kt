package com.supervital.powerweather.models

data class CurrentInfo (
    val lastUpdatedEpoch : Long,
    val tempC            : Double?    = null,
    val condition        : ConditionInfo? = null,
)