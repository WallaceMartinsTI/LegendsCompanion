package com.wcsm.champions.presentation.ui.views

import android.util.Log
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.wcsm.champions.presentation.ui.viewmodels.ChampionUiState
import com.wcsm.champions.presentation.ui.viewmodels.ChampionViewModel
import com.wcsm.core.presentation.ui.components.PageHeader
import com.wcsm.core.presentation.ui.theme.BackgroundColor
import com.wcsm.core.presentation.ui.theme.CinzelFontFamily
import com.wcsm.core.presentation.ui.theme.LegendsCompanionTheme
import com.wcsm.core.utils.UnitCallback
import com.wcsm.resources.R as ResourcesR

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
        onFetchChampions = {}
    )
}

@Composable
private fun ChampionsTemplate(
    uiState: ChampionUiState,
    onFetchChampions: UnitCallback
) {
    /*Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(onClick = onFetchChampions) {
            Text("FAZER REQUEST")
        }

        Spacer(Modifier.height(32.dp))

        when {
            uiState.isLoading -> Text(text = "Carregando...", color = Color.White)

            uiState.error != null -> Text(text = "Erro: ${uiState.error}", color = Color.White)

            uiState.result.isNotEmpty() -> Text(text = uiState.result, color = Color.White)
        }
    }*/
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
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        AsyncImage(
                            // Aatrox.png
                            model = "https://ddragon.leagueoflegends.com/cdn/16.3.1/img/champion/${champion.image}",
                            contentDescription = null,
                            modifier = Modifier.size(80.dp)
                        )
                        Text(
                            text = champion.name,
                            style = TextStyle(
                                color = Color.White,
                                fontFamily = CinzelFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                letterSpacing = 2.sp
                            ),
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
                /*items(80) { index ->
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(ResourcesR.drawable.square_aatrox_test),
                            contentDescription = null,
                            modifier = Modifier.size(80.dp)
                        )
                        Text(
                            text = "Heimerdinger $index",
                            style = TextStyle(
                                color = Color.White,
                                fontFamily = CinzelFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                letterSpacing = 2.sp
                            ),
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }*/
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
            onFetchChampions = {}
        )
    }
}