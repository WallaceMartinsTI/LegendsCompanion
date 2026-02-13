package com.wcsm.champions.presentation.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.wcsm.champions.presentation.components.ChampionCard
import com.wcsm.champions.presentation.ui.viewmodels.ChampionUiState
import com.wcsm.champions.presentation.ui.viewmodels.ChampionViewModel
import com.wcsm.core.presentation.ui.components.PageHeader
import com.wcsm.core.presentation.ui.theme.BackgroundColor
import com.wcsm.core.presentation.ui.theme.LegendsCompanionTheme

@Composable
fun ChampionsView(
    championViewModel: ChampionViewModel = hiltViewModel(),
    onChampionClick: (String) -> Unit
) {
    val uiState by championViewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(championViewModel) {
        championViewModel.fetchChampions()
    }

    ChampionsTemplate(
        uiState = uiState,
        onChampionClick = onChampionClick
    )
}

@Composable
private fun ChampionsTemplate(
    uiState: ChampionUiState,
    onChampionClick: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PageHeader(title = "CHAMPIONS")
        Spacer(Modifier.height(15.dp))

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(top = 32.dp, bottom = 32.dp)
            ) {
                items(
                    items =uiState.champions,
                    key = { it.id}
                ) { champion ->
                    ChampionCard(
                        championName = champion.name,
                        championImageName = champion.image,
                        onChampionClick = onChampionClick
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .align(Alignment.TopCenter)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                BackgroundColor,
                                BackgroundColor.copy(alpha = 0.8f),
                                Color.Transparent
                            )
                        )
                    )
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .align(Alignment.BottomCenter)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                BackgroundColor.copy(alpha = 0.8f),
                                BackgroundColor
                            )
                        )
                    )
            )
        }
    }
}

@Preview
@Composable
private fun ChampionsTemplatePreview() {
    LegendsCompanionTheme {
        ChampionsTemplate(
            uiState = ChampionUiState(),
            onChampionClick = {}
        )
    }
}