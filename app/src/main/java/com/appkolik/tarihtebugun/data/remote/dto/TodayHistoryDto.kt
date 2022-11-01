package com.appkolik.tarihtebugun.data.remote.dto

import com.appkolik.tarihtebugun.domain.model.History
import com.google.gson.annotations.SerializedName

data class TodayHistoryDto(
    @SerializedName("pagecreatedate")
    val createDate: String,
    val status: String,
    val success: Boolean,
    @SerializedName("tarihtebugun")
    val todayHistory: List<TodayHistoryListDto>
)

fun TodayHistoryDto.toHistory() : History {
    return History(
        history = todayHistory
    )
}


