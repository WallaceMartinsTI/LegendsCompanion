package com.wcsm.champions.presentation.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.wcsm.champions.domain.model.Champion
import com.wcsm.champions.domain.model.ChampionInfo
import com.wcsm.champions.domain.model.ChampionParType
import com.wcsm.champions.domain.model.ChampionStats
import com.wcsm.champions.domain.model.ChampionTag
import com.wcsm.champions.presentation.ui.components.ChampionBlurbBox
import com.wcsm.champions.presentation.ui.components.ChampionInfoBox
import com.wcsm.champions.presentation.ui.components.ChampionParTypeBox
import com.wcsm.champions.presentation.ui.components.ChampionStatsBox
import com.wcsm.champions.presentation.ui.components.ChampionSummaryHeader
import com.wcsm.champions.presentation.ui.components.ChampionTagsBox
import com.wcsm.champions.presentation.ui.viewmodels.ChampionViewModel
import com.wcsm.core.presentation.ui.components.NetworkImageBox
import com.wcsm.core.presentation.ui.components.SetSystemBarsStyle
import com.wcsm.core.presentation.ui.theme.BackgroundColor
import com.wcsm.core.presentation.ui.theme.LegendsCompanionTheme
import com.wcsm.core.presentation.ui.theme.LightBeigeColor

@Composable
fun ChampionSummaryView(
    championId: String,
    viewModel: ChampionViewModel = hiltViewModel()
) {
    val uiState by viewModel.summaryUiState.collectAsStateWithLifecycle()

    LaunchedEffect(championId) {
        viewModel.getChampionSummary(championId)
    }

    when {
        uiState.isLoading -> {
            //ChampionSummarySkeleton() // TODO: Implement
            Text(text = "Carregando...")
        }

        uiState.champion != null -> ChampionSummaryTemplate(champion = uiState.champion!!)

        uiState.error != null -> Text(
            text = uiState.error ?: "Erro",
            color = Color.White
        )
    }
}

@Composable
private fun ChampionSummaryTemplate(
    champion: Champion
) {
    SetSystemBarsStyle(darkIcons = false)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = BackgroundColor
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                NetworkImageBox(
                    imageUrl = "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/${champion.id}_0.jpg",
                    contentDescription = "${champion.name} splash image.",
                    modifier = Modifier.fillMaxWidth().height(250.dp),
                    asyncImageModifier = Modifier.fillMaxWidth()
                )
            }

            stickyHeader {
                ChampionSummaryHeader(
                    championName = champion.name,
                    championTitle = champion.title
                )
            }

            item {
                ChampionBlurbBox(
                    championBlurb = champion.blurb
                )
            }

            item {
                HorizontalDivider(
                    thickness = 1.dp,
                    color = LightBeigeColor,
                    modifier = Modifier.padding(16.dp)
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ChampionParTypeBox(
                        championParType = champion.parType,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    val tempFakeTags = ChampionTag.entries
                    ChampionTagsBox(
                        championTags = champion.tags
                    )
                }
            }

            item {
                HorizontalDivider(
                    thickness = 1.dp,
                    color = LightBeigeColor,
                    modifier = Modifier.padding(16.dp)
                )
                val tempChampionInfo = ChampionInfo(
                    attack = 8,
                    defense = 6,
                    magic = 1,
                    difficulty = 4
                )
                ChampionInfoBox(
                    championInfo = champion.info
                )
            }

            item {
                HorizontalDivider(
                    thickness = 1.dp,
                    color = LightBeigeColor,
                    modifier = Modifier.padding(16.dp)
                )

                val fakeStats = ChampionStats(
                    hp = 650.0,
                    hpPerLevel = 114.0,
                    mp = 0.0,
                    mpPerLevel = 0.0,
                    moveSpeed = 345.0,
                    armor = 38.0,
                    armorPerLevel = 4.8,
                    spellBlock = 32.0,
                    spellBlockPerLevel = 2.05,
                    attackRange = 175.0,
                    hpRegen = 3.0,
                    hpRegenPerLevel = 0.5,
                    mpRegen = 0.0,
                    mpRegenPerLevel = 0.0,
                    crit = 0.0,
                    critPerLevel = 0.0,
                    attackDamage = 60.0,
                    attackDamagePerLevel = 5.0,
                    attackSpeedPerLevel = 2.5,
                    attackSpeed = 0.651
                )

                ChampionStatsBox(championStats = champion.stats)
            }
        }
    }
}

@Preview
@Composable
private fun ChampionSummaryTemplatePreview() {
    LegendsCompanionTheme {
        val fakeChampion = Champion(
            id = "aatrox",
            key = "266",
            name = "Aatrox",
            title = "The Darkin Blade",
            blurb = "Once honored defenders of Shurima against the Void, Aatrox and his brethren would eventually become an even greater threat to Runeterra, and were defeated only by cunning mortal sorcery. But after centuries of imprisonment, Aatrox was the first to find...",
            info = ChampionInfo(
                attack = 8,
                defense = 4,
                magic = 3,
                difficulty = 4
            ),
            image = "Aatrox.png",
            tags = listOf(ChampionTag.FIGHTER),
            parType = ChampionParType.BLOOD_WELL,
            stats = ChampionStats(
                hp = 650.0,
                hpPerLevel = 114.0,
                mp = 0.0,
                mpPerLevel = 0.0,
                attackDamage = 60.0,
                attackDamagePerLevel = 5.0,
                attackSpeedPerLevel = 2.5,
                attackSpeed = 0.651,
                moveSpeed = 345.0,
                hpRegen = 3.0,
                hpRegenPerLevel = 0.5,
                mpRegen = 0.0,
                mpRegenPerLevel = 0.0,
                armor = 38.0,
                armorPerLevel = 4.8,
                spellBlock = 32.0,
                spellBlockPerLevel = 2.05,
                attackRange = 175.0,
                crit = 0.0,
                critPerLevel = 0.0
            )
        )

        ChampionSummaryTemplate(champion = fakeChampion)
    }
}