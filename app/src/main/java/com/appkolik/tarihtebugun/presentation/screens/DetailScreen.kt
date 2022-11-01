package com.appkolik.tarihtebugun.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.appkolik.tarihtebugun.domain.model.HistoryDetail
import com.appkolik.tarihtebugun.presentation.ui.theme.*

@Composable
fun DetailScreen(historyDetail: HistoryDetail) {

    setNavigationBarColor(color = Pink200)

    Column(
        modifier = Modifier
            .padding(14.dp)
            .heightIn(min = 100.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(
                modifier = Modifier
                    .width(20.dp)
                    .height(9.dp)
                    .clip(RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp)),
            )
            Text(
                modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                text = historyDetail.type.uppercase(),
                style = MaterialTheme.typography.bodySmall
            )
            Divider(
                modifier = Modifier
                    .width(20.dp)
                    .height(9.dp)
                    .clip(RoundedCornerShape(bottomEnd = 10.dp, topEnd = 10.dp)),
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, bottom = 50.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = historyDetail.year, style = MaterialTheme.typography.cardTitle)
            Spacer(Modifier.size(30.dp))
            Text(
                text = historyDetail.description,
                style = MaterialTheme.typography.cardSubTitle,
                textAlign = TextAlign.Center
            )
        }
    }
}


