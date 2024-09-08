package com.api.scientificcalculator.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.api.scientificcalculator.ui.screens.WindowInfo

@Composable
fun rememberWindowInfo(): WindowInfo {
    val configuration = LocalConfiguration.current
    return WindowInfo(
        screenWidthInfo = when {
            configuration.screenWidthDp < 600 -> WindowInfo.WindowType.Compact
            configuration.screenWidthDp < 840 -> WindowInfo.WindowType.Medium
            else -> WindowInfo.WindowType.Expanded
        },
        screenHeightInfo = when {
            configuration.screenHeightDp < 480 -> WindowInfo.WindowType.Compact
            configuration.screenHeightDp < 900 -> WindowInfo.WindowType.Medium
            else -> WindowInfo.WindowType.Expanded
        },
        screenWidth = configuration.screenWidthDp.dp,
        screenHeight = configuration.screenHeightDp.dp
    )
}

