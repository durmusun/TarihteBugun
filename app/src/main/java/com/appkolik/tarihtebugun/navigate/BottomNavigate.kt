package com.appkolik.tarihtebugun.navigate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.appkolik.tarihtebugun.presentation.components.Tabs

@Composable
fun BottomNavigate(navigator : INavigate) {
    NavigationBar(
        containerColor = Color.Transparent,
        content = {
            Column(
                modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Tabs(modifier = Modifier.padding(horizontal = 10.dp), navigator = navigator)
            }
        }
    )
}