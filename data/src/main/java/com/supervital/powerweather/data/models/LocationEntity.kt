package com.supervital.powerweather.data.models

import com.google.gson.annotations.SerializedName

data class LocationEntity(
    val name: String? = null,
    val region: String? = null,
    val country: String? = null,
    val lat: Double? = null,
    val lon: Double? = null,
    @SerializedName("tz_id")
    val tzId: String? = null,
    @SerializedName("localtime_epoch")
    val localtimeEpoch: Long? = null,
    val localtime: String? = null
)
