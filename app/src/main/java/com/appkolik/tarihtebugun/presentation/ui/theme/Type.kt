package com.appkolik.tarihtebugun.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.appkolik.tarihtebugun.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val Typography.cardTitle : TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = Montserrat,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 44.sp,
            lineHeight = 54.sp
        )
    }

val Typography.cardSubTitle : TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = Montserrat,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            lineHeight = 25.sp
        )
    }

val Typography.tabLabel : TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = Montserrat,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            lineHeight = 19.sp
        )
    }

val Typography.listYearLabel : TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = Montserrat,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 21.sp,
            lineHeight = 28.sp
        )
    }

val Typography.listDescription : TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = Montserrat,
            fontWeight = FontWeight.Medium,
            fontSize = 15.sp,
            lineHeight = 15.sp
        )
    }


val Typography.listTypeIconLabel : TextStyle
    @Composable
    get() {
        return  TextStyle(
            fontFamily = Montserrat,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 32.sp,
            lineHeight = 35.sp
        )
    }


val Montserrat = FontFamily(
    Font(R.font.montserrat_extra_bold, FontWeight.ExtraBold),
    Font(R.font.montserrat_medium, FontWeight.Medium),
    Font(R.font.montserrat_bold, FontWeight.Bold)
)

