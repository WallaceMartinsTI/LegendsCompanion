package com.wcsm.legendscompanion.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.wcsm.legendscompanion.presentation.ui.components.SetSystemBarsStyle
import com.wcsm.legendscompanion.presentation.navigation.AppNavigation
import com.wcsm.legendscompanion.presentation.ui.theme.LegendsCompanionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LegendsCompanionTheme {
                SetSystemBarsStyle(darkIcons = false)

                Scaffold(modifier = Modifier.Companion.fillMaxSize()) { innerPadding ->
                    AppNavigation(modifier = Modifier.Companion.padding(innerPadding))
                }
            }
        }
    }
}