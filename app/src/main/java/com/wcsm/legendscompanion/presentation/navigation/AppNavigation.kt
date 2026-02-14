package com.wcsm.legendscompanion.presentation.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.wcsm.champions.presentation.ui.views.ChampionSummaryView
import com.wcsm.legendscompanion.presentation.ui.views.WelcomeView

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier
) {
    val isFirstLaunch = true // TODO: Implement later

    val startRoute = if (isFirstLaunch) {
        AppRoutes.Welcome
    } else {
        AppRoutes.Champions
    }

    val backStack = rememberNavBackStack(AppRoutes.Welcome)

    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<AppRoutes.Welcome> {
                WelcomeView(
                    onEnterClick = {
                        backStack.clear()
                        backStack.add(AppRoutes.Champions)
                    }
                )
            }
            entry<AppRoutes.Champions> {
                HomeContainer(
                    currentRoute = AppRoutes.Champions,
                    backStack = backStack
                )
            }
            entry<AppRoutes.Items> {
                HomeContainer(
                    currentRoute = AppRoutes.Items,
                    backStack = backStack
                )
            }
            entry<AppRoutes.ChampionResume> { route ->
                ChampionSummaryView(
                    championId = route.championId
                )
                /*ChampionResumeScreen(
                    championId = route.championId,
                    onBack = { backStack.removeLastOrNull() },
                    onSeeDetails = { id ->
                        backStack.add(AppRoutes.ChampionDetail(id))
                    }
                )*/
            }

            entry<AppRoutes.ChampionDetail> { route ->
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Tela de Champion Details",
                        color = Color.White,
                        fontSize = 42.sp
                    )
                }
                /*ChampionDetailScreen(
                    championId = route.championId,
                    onBack = { backStack.removeLastOrNull() }
                )*/
            }
        }
    )
}