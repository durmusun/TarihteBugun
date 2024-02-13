package com.appkolik.tarihtebugun.presentation.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.appkolik.tarihtebugun.presentation.ui.theme.BackgroundDark
import com.appkolik.tarihtebugun.presentation.ui.theme.Black
import com.appkolik.tarihtebugun.presentation.ui.theme.Red800
import com.appkolik.tarihtebugun.presentation.ui.theme.White
import com.appkolik.tarihtebugun.presentation.ui.theme.tabLabel

@Composable
fun TabsItem(label: String, clickable : () -> Unit) {
    Button(
        modifier = Modifier.height(40.dp),
        onClick = clickable,
        colors = ButtonDefaults.buttonColors(
            contentColor = Black,
            containerColor = White,
            disabledContentColor = White,
            disabledContainerColor = Red800
        ),
        content = {
            Text(
                modifier = Modifier.padding(0.dp) ,text = label, style = MaterialTheme.typography.tabLabel
            )
        }
    )
}
