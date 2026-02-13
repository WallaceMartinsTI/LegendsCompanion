package com.wcsm.legendscompanion.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.wcsm.core.presentation.ui.components.SetSystemBarsStyle
import com.wcsm.core.presentation.ui.theme.BackgroundColor
import com.wcsm.core.presentation.ui.theme.LightBeigeColor
import com.wcsm.core.presentation.ui.theme.LightGrayColor
import com.wcsm.legendscompanion.R
import com.wcsm.legendscompanion.presentation.ui.views.ChampionsView
import com.wcsm.legendscompanion.presentation.ui.views.ItemsView
import kotlinx.coroutines.launch

@Composable
fun HomeContainer(
    currentRoute: AppRoutes,
    backStack: NavBackStack<NavKey>
) {
    SetSystemBarsStyle(darkIcons = false)

    val pagerState = rememberPagerState(
        initialPage = if (currentRoute is AppRoutes.Champions) 0 else 1,
        pageCount = { 2 }
    )

    val coroutineScope = rememberCoroutineScope()

    val isChampionRouteSelected = pagerState.currentPage == 0
    val isItemsRouteSelected = pagerState.currentPage == 1

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = BackgroundColor,
        bottomBar = {
            Column(modifier = Modifier.background(BackgroundColor)) {
                HorizontalDivider(thickness = 1.dp, color = LightBeigeColor)

                NavigationBar(
                    containerColor = BackgroundColor,
                    windowInsets = WindowInsets.navigationBars
                ) {
                    NavigationBarItem(
                        selected = isChampionRouteSelected,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(0)
                            }
                        },
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
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(1)
                            }
                        },
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
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) { page ->
            when (page) {
                0 -> ChampionsView(
                    onChampionClick = { championId ->
                        backStack.add(AppRoutes.ChampionResume(championId))
                    }
                )
                1 -> ItemsView()
            }
        }
    }
}