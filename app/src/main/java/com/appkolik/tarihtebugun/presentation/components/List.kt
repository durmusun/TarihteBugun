package com.appkolik.tarihtebugun.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.appkolik.tarihtebugun.data.remote.dto.toHistoryDetail
import com.appkolik.tarihtebugun.domain.model.HistoryDetail
import com.appkolik.tarihtebugun.presentation.screens.LocalHistoryState
import com.appkolik.tarihtebugun.presentation.ui.theme.*
import com.appkolik.tarihtebugun.util.HistoryState
import com.appkolik.tarihtebugun.util.ListTypes

@Composable
fun List(listType: String, clickable: (history : HistoryDetail) -> Unit) {

    val historyState: HistoryState = LocalHistoryState.current.value

    if (historyState.loading) {
        Progress()
    } else {
        LazyColumn {
            itemsIndexed(items = historyState.data.filter {
                it.type.contains(listType, ignoreCase = true) || listType == ListTypes.ALL.value
            }) { index, item ->
                val backgroundColor: Color = if (index % 2 == 0) Green800 else Red800

                val history = item.toHistoryDetail()

                ListItem(
                    history = history,
                    backgroundColor = backgroundColor,
                    clickable = {
                        clickable(history)
                    }
                )
            }
        }
    }
}

@Composable
private fun ListItem(history: HistoryDetail, backgroundColor: Color, clickable: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 11.dp)
            .clip(shape = RoundedCornerShape(38.dp))
            .clickable {
                clickable()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        ListIcon(
            Modifier.background(backgroundColor, shape = RoundedCornerShape(100f)),
            history.type.substring(0, 1)
        )
        Spacer(modifier = Modifier.width(5.dp))
        ListCard(history.year, history.description, history.type)
    }
}

@Composable
private fun ListIcon(modifier: Modifier? = null, iconCharacter: String) {

    val modifier = modifier ?: Modifier;

    Box(
        modifier = modifier.getDefaultModifierSettings(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = iconCharacter,
            color = White,
            style = MaterialTheme.typography.listTypeIconLabel
        )
    }
}

private fun Modifier.getDefaultModifierSettings(): Modifier {
    return this
        .size(64.dp)
        .border(
            border = BorderStroke(
                width = 2.dp,
                color = Black
            ), shape = RoundedCornerShape(100f)
        )
}

@Composable
private fun ListCard(year: String, description: String, type: String) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = year,
                style = MaterialTheme.typography.listYearLabel
            )
            Text(
                modifier = Modifier.padding(top = 2.3.dp),
                text = type,
                style = MaterialTheme.typography.bodySmall,
                color = Red800
            )
        }
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.padding(end = 20.dp),
                text = description,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.listDescription,
            )
        }
    }
}