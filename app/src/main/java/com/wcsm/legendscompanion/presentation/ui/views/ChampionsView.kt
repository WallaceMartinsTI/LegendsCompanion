package com.wcsm.legendscompanion.presentation.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.wcsm.legendscompanion.presentation.ui.components.SetSystemBarsStyle

@Composable
fun ChampionsView(modifier: Modifier = Modifier) {
    SetSystemBarsStyle(darkIcons = false)

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Champions View",
            color = Color.White
        )
    }
}