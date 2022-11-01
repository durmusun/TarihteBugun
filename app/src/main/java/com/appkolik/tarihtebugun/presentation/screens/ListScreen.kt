package com.appkolik.tarihtebugun.presentation.screens

import androidx.compose.runtime.Composable
import com.appkolik.tarihtebugun.navigate.INavigate
import com.appkolik.tarihtebugun.presentation.components.List
import com.appkolik.tarihtebugun.presentation.ui.theme.Black
import com.appkolik.tarihtebugun.presentation.ui.theme.setNavigationBarColor

@Composable
fun ListScreen(
    navigator: INavigate,
    listType: String
) {
    List(listType = listType, clickable = {
        navigator.showDetailScreen(historyDetail = it)
    })
}

