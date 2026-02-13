package com.wcsm.legendscompanion.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.wcsm.legendscompanion.presentation.ui.views.WelcomeView

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier
) {
    val isFirstLaunch = true // TODO: Implementar depois

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
                    onNavigate = { route ->
                        if (backStack.lastOrNull() != route) {
                            backStack.add(route)
                        }
                    }
                )
            }
            entry<AppRoutes.Items> {
                HomeContainer(
                    currentRoute = AppRoutes.Items,
                    onNavigate = { route ->
                        if (backStack.lastOrNull() != route) {
                            backStack.add(route)
                        }
                    }
                )
            }
        },
    )
}