package com.appkolik.tarihtebugun.presentation.components.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.appkolik.tarihtebugun.presentation.ui.theme.*

@Composable
fun Card(cardTitle : String, cardSubTitle : String? = null, modifier: Modifier? = null, backgroundColor : Color? = Yellow){
      Box(modifier ?: Modifier){
         Box(
            modifier = Modifier
               .fillMaxWidth()
               .background(color = Black, shape = RoundedCornerShape(18.dp))
               .height(110.dp),
         )
         Box(
            modifier = Modifier
               .fillMaxWidth()
               .height(105.dp)
               .background(color = backgroundColor!!, shape = RoundedCornerShape(18.dp))
               .border(border = BorderStroke(2.dp, Black), shape = RoundedCornerShape(16.dp)),
            content = {
               Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                  Text(text = cardTitle, style = MaterialTheme.typography.cardTitle)
                  cardSubTitle?.let {
                     Text(text = cardSubTitle, style = MaterialTheme.typography.cardSubTitle)
                  }
               }
            }
         )
      }
}
