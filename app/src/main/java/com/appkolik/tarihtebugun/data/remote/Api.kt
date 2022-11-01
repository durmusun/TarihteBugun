package com.appkolik.tarihtebugun.data.remote

import com.appkolik.tarihtebugun.data.remote.dto.TodayHistoryDto
import retrofit2.http.GET

interface Api {
    @GET("/tarihtebugun")
    suspend fun getTodayHistory() : TodayHistoryDto
}