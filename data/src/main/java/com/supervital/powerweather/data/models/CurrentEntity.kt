package com.supervital.powerweather.data.models

import com.google.gson.annotations.SerializedName

data class CurrentEntity(
    @SerializedName("last_updated_epoch")
    val lastUpdatedEpoch: Long,
    @SerializedName("temp_c")
    val tempC: Double? = null,
    val condition: ConditionEntity? = null,
)