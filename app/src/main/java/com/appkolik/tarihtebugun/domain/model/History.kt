package com.appkolik.tarihtebugun.domain.model

import com.appkolik.tarihtebugun.data.remote.dto.TodayHistoryListDto

data class History(
    val history: List<TodayHistoryListDto>
)
