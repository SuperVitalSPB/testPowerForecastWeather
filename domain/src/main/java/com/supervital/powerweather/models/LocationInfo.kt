package com.supervital.powerweather.models

data class LocationInfo(
    val name           : String? = null,
    val region         : String? = null,
    val country        : String? = null,
    val lat            : Double? = null,
    val lon            : Double? = null,
    val tzId           : String? = null,
    val localtimeEpoch : Long?    = null,
    val localtime      : String? = null
)
