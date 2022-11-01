package com.appkolik.tarihtebugun.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.appkolik.tarihtebugun.presentation.ui.theme.Yellow

@Composable
fun Progress() {
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            CircularProgressIndicator(
                modifier = Modifier.size(100.dp),
                color = Yellow,
                strokeWidth = 12.dp
            )
        }
    )
}