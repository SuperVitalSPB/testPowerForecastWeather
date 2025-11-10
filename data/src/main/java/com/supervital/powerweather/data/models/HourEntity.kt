package com.supervital.powerweather.data.models

import com.google.gson.annotations.SerializedName

data class HourEntity(
    @SerializedName("time_epoch")
    val timeEpoch: Long? = null,
    @SerializedName("temp_c")
    val tempC: Double? = null,
    @SerializedName("condition")
    val condition: ConditionEntity? = null,
)