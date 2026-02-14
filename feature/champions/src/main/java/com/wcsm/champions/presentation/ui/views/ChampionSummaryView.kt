package com.wcsm.champions.presentation.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wcsm.champions.domain.model.ChampionInfo
import com.wcsm.champions.domain.model.ChampionParType
import com.wcsm.champions.domain.model.ChampionStats
import com.wcsm.champions.domain.model.ChampionTag
import com.wcsm.champions.presentation.components.ChampionBlurbBox
import com.wcsm.champions.presentation.components.ChampionInfoBox
import com.wcsm.champions.presentation.components.ChampionParTypeBox
import com.wcsm.champions.presentation.components.ChampionStatsBox
import com.wcsm.champions.presentation.components.ChampionSummaryHeader
import com.wcsm.champions.presentation.components.ChampionTagBox
import com.wcsm.champions.presentation.components.ChampionTagsBox
import com.wcsm.core.presentation.ui.components.SetSystemBarsStyle
import com.wcsm.core.presentation.ui.theme.BackgroundColor
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
            item {
                Image(
                    painter = painterResource(ResourcesR.drawable.splash_aatrox_test),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            stickyHeader {
                ChampionSummaryHeader(
                    championName = "Aatrox",
                    championTitle = "The Darkin Blade"
                )
            }

            item {
                ChampionBlurbBox(
                    championBlurb = "Once honored defenders of Shurima against the Void, Aatrox and his brethren would eventually become an even greater threat to Runeterra, and were defeated only by cunning mortal sorcery. But after centuries of imprisonment, Aatrox was the first to find..."
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
                        championParType = ChampionParType.BLOOD_WELL,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    val tempFakeTags = ChampionTag.entries
                    ChampionTagsBox(
                        championTags = tempFakeTags
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
                    championInfo = tempChampionInfo
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

                ChampionStatsBox(championStats = fakeStats)
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