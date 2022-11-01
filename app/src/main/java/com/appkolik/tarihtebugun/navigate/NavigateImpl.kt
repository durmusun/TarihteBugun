package com.appkolik.tarihtebugun.navigate

import androidx.navigation.NavHostController
import com.appkolik.tarihtebugun.domain.model.HistoryDetail
import com.google.gson.Gson

class NavigateImpl(
    private val navHostController: NavHostController,
    private val startDestination : String,
) : INavigate {

    override fun showListScreen(listType: String, clearHistory: Boolean) {
        Navigate(route = Screens.ListScreen.withType(listType), navHostController = navHostController, clearHistory = clearHistory)
    }

    override fun showDetailScreen(historyDetail: HistoryDetail) {
        val historyJson = Gson().toJson(historyDetail)
        Navigate(route = Screens.DetailScreen.withHistoryDetail(historyJson = historyJson), navHostController = navHostController)
    }

    override fun goToBack(){
        navHostController.apply {
            navigateUp()
            navigate(startDestination){
                launchSingleTop = true
                restoreState = true
            }
        }
    }

}