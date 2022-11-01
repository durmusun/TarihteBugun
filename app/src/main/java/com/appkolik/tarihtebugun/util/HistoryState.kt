package com.appkolik.tarihtebugun.util

import com.appkolik.tarihtebugun.data.remote.dto.TodayHistoryListDto

data class HistoryState(
    val loading: Boolean = false,
    val message: String = "",
    val data: List<TodayHistoryListDto> = emptyList()
)
