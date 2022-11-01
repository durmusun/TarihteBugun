package com.appkolik.tarihtebugun.presentation.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private lateinit var systemUiController : SystemUiController

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryLight,
    tertiary = PrimaryTertiaryLight,
    secondary = SecondaryLight,
    background = BackgroundDark
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryLight,
    tertiary = PrimaryTertiaryLight,
    secondary = SecondaryLight,
    background = BackgroundLight,

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

fun setStatusBarColor(color : Color = BackgroundLight){
    systemUiController.setStatusBarColor(
        color = color,
        darkIcons = true
    )
}

fun setNavigationBarColor(color: Color = BackgroundLight){
    systemUiController.setNavigationBarColor(
        color = color,
        darkIcons = true
    )
}

@Composable
fun TarihteBugunTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {

    systemUiController = rememberSystemUiController()

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current


            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val view = LocalView.current

    if (!view.isInEditMode) {
        SideEffect {
            setStatusBarColor()
            setNavigationBarColor()
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}