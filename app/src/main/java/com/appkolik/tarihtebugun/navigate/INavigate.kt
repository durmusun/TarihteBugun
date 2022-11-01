package com.appkolik.tarihtebugun.navigate

import com.appkolik.tarihtebugun.domain.model.HistoryDetail

interface INavigate {
    fun showListScreen(listType : String, clearHistory: Boolean = true)
    fun showDetailScreen(historyDetail: HistoryDetail)
    fun goToBack()
}