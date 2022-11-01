package com.appkolik.tarihtebugun.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.appkolik.tarihtebugun.navigate.INavigate
import com.appkolik.tarihtebugun.navigate.NavigateGraph
import com.appkolik.tarihtebugun.navigate.NavigateImpl
import com.appkolik.tarihtebugun.navigate.Screens
import com.appkolik.tarihtebugun.presentation.vm.MainViewModel
import com.appkolik.tarihtebugun.util.HistoryState
import com.appkolik.tarihtebugun.util.ListTypes
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator

val LocalHistoryState = staticCompositionLocalOf<State<HistoryState>> { error("History state not set") }

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialNavigationApi::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(),
) {

    val bottomSheetNavigator = rememberBottomSheetNavigator()
    val navController = rememberNavController(bottomSheetNavigator)

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val startDestination = navBackStackEntry?.destination?.route ?: Screens.ListScreen.withType(
        ListTypes.ALL.value
    )

    val navigator: INavigate = remember {
        NavigateImpl(
            navHostController = navController,
            startDestination = startDestination
        )
    }

    CompositionLocalProvider(LocalHistoryState provides viewModel.historyState) {
        NavigateGraph(navHostController = navController, bottomSheetNavigator = bottomSheetNavigator, navigator = navigator)
    }

}
