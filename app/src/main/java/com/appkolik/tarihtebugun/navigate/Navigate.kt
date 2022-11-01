package com.appkolik.tarihtebugun.navigate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.appkolik.tarihtebugun.domain.model.HistoryDetail
import com.appkolik.tarihtebugun.presentation.components.Header
import com.appkolik.tarihtebugun.presentation.screens.DetailScreen
import com.appkolik.tarihtebugun.presentation.screens.ListScreen
import com.appkolik.tarihtebugun.presentation.ui.theme.Pink200
import com.appkolik.tarihtebugun.presentation.ui.theme.setNavigationBarColor
import com.appkolik.tarihtebugun.util.ListTypes
import com.google.accompanist.navigation.material.BottomSheetNavigator
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.bottomSheet
import com.google.gson.Gson

fun Navigate(
    navHostController: NavHostController,
    route: String,
    clearHistory: Boolean = false,
    singleTop: Boolean = false
) {
    navHostController.apply {
        navigate(route = route) {
            if (clearHistory) {
                if (singleTop) {
                    popUpTo(Screens.ListScreen.withType(ListTypes.ALL.value)) {
                        inclusive = true
                    }
                } else {
                    popUpTo(0) {
                        saveState = true
                    }
                }
            } else {
                restoreState = true
            }
            launchSingleTop = singleTop
        }
    }
}

@OptIn(ExperimentalMaterialNavigationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun NavigateGraph(
    navHostController: NavHostController,
    bottomSheetNavigator : BottomSheetNavigator,
    startDestination: String = Screens.ListScreen.route,
    navGraphBuilder: NavGraphBuilder.() -> Unit = {},
    navigator : INavigate,
) {
    if (!bottomSheetNavigator.navigatorSheetState.isVisible){
        setNavigationBarColor()
    }

    ModalBottomSheetLayout(
        bottomSheetNavigator = bottomSheetNavigator,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetBackgroundColor = Pink200
    ) {
        Scaffold(
            bottomBar = {
                BottomNavigate(navigator = navigator)
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(
                        top = 15.dp,
                        start = 15.dp,
                        end = 15.dp,
                        bottom = innerPadding.calculateBottomPadding()
                    )
            ) {
                Header()
                NavHost(navController = navHostController, startDestination = startDestination) {
                    navGraphBuilder.invoke(this)
                    SetupNavigation(navigator)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialNavigationApi::class)
private fun NavGraphBuilder.SetupNavigation(
    navigator: INavigate
) {
    composable(
        route = Screens.ListScreen.route,
        arguments = listOf(
            navArgument("listType") {
                type = NavType.StringType
            }
        )
    ) { navBackStackEntry ->

        val listType = navBackStackEntry.arguments?.getString("listType") ?: ListTypes.ALL.value

        ListScreen(
            listType = listType,
            navigator = navigator
        )

    }
    bottomSheet(
        route = Screens.DetailScreen.route,
        arguments = listOf(
            navArgument("history"){
                type = NavType.StringType
            }
        )
    ){navBackStackEntry ->

        val historyJson = navBackStackEntry.arguments?.getString("history")
        val historyDetail: HistoryDetail = Gson().fromJson(historyJson,HistoryDetail::class.java)

        DetailScreen(historyDetail = historyDetail)

    }
}