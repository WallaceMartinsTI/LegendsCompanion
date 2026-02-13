package com.wcsm.legendscompanion.presentation.ui.components

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
fun SetSystemBarsStyle(
    darkIcons: Boolean
) {
    val view = LocalView.current
    val window = (view.context as Activity).window

    SideEffect {
        val controller = WindowCompat.getInsetsController(window, view)

        controller.isAppearanceLightStatusBars = darkIcons
        controller.isAppearanceLightNavigationBars = darkIcons
    }
}