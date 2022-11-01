package com.appkolik.tarihtebugun.data.repository

import com.appkolik.tarihtebugun.data.remote.Api
import com.appkolik.tarihtebugun.data.remote.dto.TodayHistoryDto
import com.appkolik.tarihtebugun.domain.repository.TodayHistoryRepository
import javax.inject.Inject

class TodayHistoryRepositoryImpl @Inject constructor(
    private val api : Api
) : TodayHistoryRepository {
    override suspend fun getHistory(): TodayHistoryDto {
        return api.getTodayHistory()
    }
}