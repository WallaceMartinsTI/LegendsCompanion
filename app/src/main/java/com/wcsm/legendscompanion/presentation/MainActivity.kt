package com.wcsm.legendscompanion.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.wcsm.legendscompanion.presentation.navigation.AppNavigation
import com.wcsm.legendscompanion.presentation.ui.theme.LegendsCompanionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            LegendsCompanionTheme {
                AppNavigation()
            }
        }
    }
}