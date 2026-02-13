package com.wcsm.legendscompanion.presentation.ui.components

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
fun SetSystemBarsStyle(
    darkIcons: Boolean,
    statusBarColor: Color = Color.Transparent,
    navigationBarColor: Color = Color.Transparent
) {
    val view = LocalView.current

    // SideEffect garante que a mudança ocorra após a composição bem-sucedida
    SideEffect {
        val window = (view.context as Activity).window

        // No Android 15, as cores devem ser transparentes para o Edge-to-Edge,
        // mas em versões anteriores do Android, você pode querer definir uma cor.
        window.statusBarColor = statusBarColor.toArgb()
        window.navigationBarColor = navigationBarColor.toArgb()

        // Obtém o controlador para gerenciar as luzes/sombras dos ícones
        val windowInsetsController = WindowCompat.getInsetsController(window, view)

        // Controla se os ícones da barra de status devem ser escuros ou claros
        // darkIcons = true -> ícones pretos (bom para fundos brancos)
        // darkIcons = false -> ícones brancos (bom para fundos escuros/imagens)
        windowInsetsController.isAppearanceLightStatusBars = darkIcons
        windowInsetsController.isAppearanceLightNavigationBars = darkIcons
    }
}