package com.supervital.powerweather.data.models

import com.google.gson.annotations.SerializedName

data class CurrentEntity(
    @SerializedName("last_updated_epoch")
    val lastUpdatedEpoch: Long,
    @SerializedName("last_updated")
    val lastUpdated: String? = null,
    @SerializedName("temp_c")
    val tempC: Double? = null,
    @SerializedName("temp_f")
    val tempF: Double? = null,
    @SerializedName("is_day")
    val isDay: Int? = null,
    val condition: ConditionEntity? = null,
    @SerializedName("wind_kph")
    val windKph: Double? = null,
    @SerializedName("wind_degree")
    val windDegree: Int? = null,
    @SerializedName("wind_dir")
    val windDir: String? = null,
    @SerializedName("precip_mm")
    val precipMm: Double? = null,
    @SerializedName("precip_in")
    val precipIn: Int? = null,
    val humidity: Int? = null,
    val cloud: Int? = null,
    @SerializedName("feelslike_c")
    val feelslikeC: Double? = null,
    @SerializedName("feelslike_f")
    val feelslikeF: Double? = null,
    @SerializedName("gust_kph")
    val gustKph: Double? = null

)