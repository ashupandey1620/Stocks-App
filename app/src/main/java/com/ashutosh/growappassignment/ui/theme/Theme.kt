package com.ashutosh.growappassignment.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.ashutosh.growappassignment.ui.theme.Theme.AppTheme


private val DarkColorScheme = darkColorScheme(
    primary = Blue200,
    secondary = Blue200,
    background = Blue500,
    onPrimary = White500,
    onSecondary = Color.LightGray,
)

private val LightColorScheme = lightColorScheme(
    primary = Color.White,
    secondary = White200,
    background = White500,
    onPrimary = Black500,
    onSecondary = DarkGray,
)


@Composable
fun GrowAppAssignmentTheme(
    theme: AppTheme = AppTheme.Dark ,
    dynamicColor: Boolean = false ,
    content: @Composable () -> Unit
) {
    val colorScheme = when (theme) {

        AppTheme.Light -> LightColorScheme
        AppTheme.Dark -> DarkColorScheme

    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(
                window,
                view
            ).isAppearanceLightStatusBars = true
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography ,
        content = content
    )
}