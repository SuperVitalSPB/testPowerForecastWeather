package com.supervital.powerweather.data.models

import com.google.gson.annotations.SerializedName

class ForecastdayEntity (
    @SerializedName("date_epoch")
    val dateEpoch : Long? = null,
    val day       : DayEntity? = null,
    val hour      : List<HourEntity> = arrayListOf()
)