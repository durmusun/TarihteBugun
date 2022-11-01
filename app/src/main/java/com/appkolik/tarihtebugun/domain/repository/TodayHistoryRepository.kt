package com.appkolik.tarihtebugun.domain.repository

import com.appkolik.tarihtebugun.data.remote.dto.TodayHistoryDto

interface TodayHistoryRepository {
    suspend fun getHistory()  : TodayHistoryDto
}