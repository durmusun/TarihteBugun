package com.appkolik.tarihtebugun.data.remote.dto

import com.appkolik.tarihtebugun.domain.model.HistoryDetail
import com.google.gson.annotations.SerializedName

data class TodayHistoryListDto(
    @SerializedName("Ay")
    val month: String,
    @SerializedName("Durum")
    val type: String,
    @SerializedName("Gun")
    val day: String,
    @SerializedName("Olay")
    val description: String,
    @SerializedName("Yil")
    val year: String
)

fun TodayHistoryListDto.toHistoryDetail() : HistoryDetail {
    return HistoryDetail(
        date = "${day}.${month}",
        type = type,
        description = description,
        year = year
    )
}

