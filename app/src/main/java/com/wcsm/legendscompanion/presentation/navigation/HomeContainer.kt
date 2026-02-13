package com.wcsm.legendscompanion.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavKey
import com.wcsm.legendscompanion.R
import com.wcsm.legendscompanion.presentation.ui.theme.BackgroundColor
import com.wcsm.legendscompanion.presentation.ui.theme.LightBeigeColor
import com.wcsm.legendscompanion.presentation.ui.theme.LightGrayColor
import com.wcsm.legendscompanion.presentation.ui.views.ChampionsView
import com.wcsm.legendscompanion.presentation.ui.views.ItemsView

@Composable
fun HomeContainer(
    currentRoute: AppRoutes,
    onNavigate: (NavKey) -> Unit
) {
    val isChampionRouteSelected = currentRoute is AppRoutes.Champions
    val isItemsRouteSelected = currentRoute is AppRoutes.Items

    Scaffold(
        containerColor = BackgroundColor,
        bottomBar = {
            Column {
                HorizontalDivider(
                    thickness = 1.dp,
                    color = LightBeigeColor
                )

                NavigationBar(
                    containerColor = Color.Transparent,
                    windowInsets = WindowInsets(0)
                ) {
                    NavigationBarItem(
                        selected = isChampionRouteSelected,
                        onClick = { onNavigate(AppRoutes.Champions) },
                        icon = {
                            Icon(
                                painterResource(R.drawable.champion_nav_item),
                                contentDescription = null,
                                tint = if(isChampionRouteSelected) LightBeigeColor else LightGrayColor
                            )
                        },
                        label = {
                            Text(
                                text = "Champions",
                                color = if(isChampionRouteSelected) LightBeigeColor else LightGrayColor
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(indicatorColor = Color.Transparent)
                    )
                    NavigationBarItem(
                        selected = isItemsRouteSelected,
                        onClick = { onNavigate(AppRoutes.Items) },
                        icon = {
                            Icon(
                                painterResource(R.drawable.items_nav_item),
                                contentDescription = null,
                                tint = if(isItemsRouteSelected) LightBeigeColor else LightGrayColor
                            )
                        },
                        label = {
                            Text(
                                text = "Items",
                                color = if(isItemsRouteSelected) LightBeigeColor else LightGrayColor
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(indicatorColor = Color.Transparent)
                    )
                }
            }
        }
    ) { padding ->
        when (currentRoute) {
            AppRoutes.Champions -> ChampionsView(Modifier.padding(padding))
            AppRoutes.Items -> ItemsView(Modifier.padding(padding))
            else -> {}
        }
    }
}