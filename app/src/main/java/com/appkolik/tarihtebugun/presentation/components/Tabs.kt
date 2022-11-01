package com.appkolik.tarihtebugun.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.appkolik.tarihtebugun.navigate.INavigate
import com.appkolik.tarihtebugun.presentation.ui.theme.Black
import com.appkolik.tarihtebugun.presentation.ui.theme.White
import com.appkolik.tarihtebugun.util.ListTypes

@Composable
fun Tabs(modifier: Modifier? = Modifier, navigator : INavigate){
    Box(modifier = modifier ?: Modifier){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Black, shape = RoundedCornerShape(35.dp))
                .height(55.dp),
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .background(color = White, shape = RoundedCornerShape(35.dp))
                .border(border = BorderStroke(2.dp, Black), shape = RoundedCornerShape(26.dp)),
            content = {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TabsItem(label = ListTypes.ALL.value.uppercase(), clickable = {
                        navigator.showListScreen(ListTypes.ALL.value, clearHistory = false)
                    })
                    TabsItem(label = ListTypes.EVENT.value.uppercase(), clickable = {
                        navigator.showListScreen(ListTypes.EVENT.value)
                    })
                    TabsItem(label = ListTypes.RIP.value.uppercase(), clickable = {
                        navigator.showListScreen(ListTypes.RIP.value)
                    })
                    TabsItem(label = ListTypes.BORN.value.uppercase(), clickable = {
                        navigator.showListScreen(ListTypes.BORN.value)
                    })
                }
            }
        )
    }
}


