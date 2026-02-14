package com.wcsm.champions.presentation.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wcsm.champions.domain.model.ChampionParType
import com.wcsm.champions.domain.model.ChampionTag
import com.wcsm.champions.presentation.components.ChampionParTypeBox
import com.wcsm.champions.presentation.components.ChampionTagBox
import com.wcsm.core.presentation.ui.components.PageHeader
import com.wcsm.core.presentation.ui.components.SetSystemBarsStyle
import com.wcsm.core.presentation.ui.theme.BackgroundColor
import com.wcsm.core.presentation.ui.theme.CinzelFontFamily
import com.wcsm.core.presentation.ui.theme.LegendsCompanionTheme
import com.wcsm.core.presentation.ui.theme.LightBeigeColor
import com.wcsm.resources.R as ResourcesR

@Composable
fun ChampionSummaryView() {
    ChampionSummaryTemplate()
}

@Composable
private fun ChampionSummaryTemplate() {
    SetSystemBarsStyle(darkIcons = false)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = BackgroundColor
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Champion Splash com o "Carousel" para trocar entre as skins
            item {
                Image(
                    painter = painterResource(ResourcesR.drawable.splash_aatrox_test),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            // Nome e Título (ao realizar o scroll, deve ficar fixado no topo da tela
            stickyHeader {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Aatrox",
                        style = TextStyle(
                            color = Color.White,
                            fontFamily = CinzelFontFamily,
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    )

                    Text(
                        text = "the Darkin Blade",
                        style = TextStyle(
                            color = Color.LightGray,
                            fontFamily = CinzelFontFamily,
                            fontSize = 14.sp,
                        )
                    )
                }
            }

            // Blurb
            item {
                Text(
                    text = "Once honored defenders of Shurima against the Void, Aatrox and his brethren would eventually become an even greater threat to Runeterra, and were defeated only by cunning mortal sorcery. But after centuries of imprisonment, Aatrox was the first to find...",
                    modifier = Modifier.padding(16.dp),
                    color = Color.White
                )
            }

            // ParType + Tags
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .border(1.dp, LightBeigeColor, RoundedCornerShape(16.dp))
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ChampionParTypeBox(
                        championParType = ChampionParType.BLOOD_WELL,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(
                            space = 8.dp,
                            alignment = Alignment.CenterHorizontally
                        ),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        val tags = ChampionTag.entries
                        tags.forEach { tag ->
                            ChampionTagBox(championTag = tag)
                        }
                    }
                }
            }

            // Info Bars
            // Progress bar com linhas entre os valores 0 a 10

            // Stats Grid
            // Estilo Grid
            // HP            650
            // HP/Level      114
            // Armor         38
            // Armor/Level   4.8
            // Attack        60
            // Attack/Level  5
            // Speed         345

            // Adicionar um FloatActionButton (Ver Detalhes)
            // ----------------------------------------------------------
            // Daqui para baixo, testes de scroll

            item {
                Box(modifier = Modifier.height(450.dp))
            }

            item {
                Text(
                    text = "Fim da Página 1"
                )
            }

            item {
                Box(modifier = Modifier.height(950.dp))
            }

            item {
                Text(
                    text = "Fim da Página 1"
                )
            }

            item {
                Box(modifier = Modifier.height(780.dp))
            }

            item {
                Text(
                    text = "Fim da Página 1"
                )
            }
        }
    }
}

@Preview
@Composable
private fun ChampionSummaryTemplatePreview() {
    LegendsCompanionTheme {
        ChampionSummaryTemplate()
    }
}