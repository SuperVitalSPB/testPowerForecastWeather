package com.supervital.powerweather.data.models

import com.google.gson.annotations.SerializedName

data class DayEntity(
    @SerializedName("maxtemp_c")
    val maxtempC: Double? = null,
    @SerializedName("mintemp_c")
    val mintempC: Double? = null,
    @SerializedName("condition")
    val condition: ConditionEntity? = null,
)