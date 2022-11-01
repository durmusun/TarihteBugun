package com.appkolik.tarihtebugun.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.appkolik.tarihtebugun.R
import com.appkolik.tarihtebugun.data.remote.dto.toHistoryDetail
import com.appkolik.tarihtebugun.presentation.components.home.Card
import com.appkolik.tarihtebugun.presentation.screens.LocalHistoryState
import com.appkolik.tarihtebugun.presentation.ui.theme.Yellow
import com.appkolik.tarihtebugun.util.HistoryState

@Composable
fun Header() {

    val historyState : HistoryState = LocalHistoryState.current.value;
    val date = if (!historyState.loading) historyState.data.get(0).toHistoryDetail().date else historyState.message

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.width(270.dp),
            imageVector = ImageVector.vectorResource(
                id = R.drawable.ic_people_1
            ),
            contentDescription = "man_01",
        )
        Card(
            modifier = Modifier.offset(y = -5.dp),
            cardTitle = date.toString(),
            cardSubTitle = "Tarihte bugün ne oldu?",
            backgroundColor = Yellow
        )
    }

}