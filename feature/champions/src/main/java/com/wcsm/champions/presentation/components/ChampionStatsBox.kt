package com.wcsm.champions.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.wcsm.champions.domain.model.ChampionStats
import com.wcsm.core.presentation.ui.theme.CinzelFontFamily
import com.wcsm.core.presentation.ui.theme.LegendsCompanionTheme
import com.wcsm.core.presentation.ui.theme.LightGrayColor

@Composable
fun ChampionStatsBox(
    championStats: ChampionStats
) {
    // TODO: Treat when there are other languages.
    val stats = listOf(
        "HP" to championStats.hp,
        "HP / LVL" to championStats.hpPerLevel,

        "MP" to championStats.mp,
        "MP / LVL" to championStats.mpPerLevel,

        "ATTACK" to championStats.attackDamage,
        "ATTACK / LVL" to championStats.attackDamagePerLevel,

        "ATK SPEED" to championStats.attackSpeed,
        "ATK SPEED / LVL" to championStats.attackSpeedPerLevel,

        "MOVE SPEED" to championStats.moveSpeed,
        "RANGE" to championStats.attackRange,

        "HP REGEN" to championStats.hpRegen,
        "HP REGEN / LVL" to championStats.hpRegenPerLevel,

        "MP REGEN" to championStats.mpRegen,
        "MP REGEN / LVL" to championStats.mpRegenPerLevel,

        "ARMOR" to championStats.armor,
        "ARMOR / LVL" to championStats.armorPerLevel,

        "MR" to championStats.spellBlock,
        "MR / LVL" to championStats.spellBlockPerLevel,

        "CRIT" to championStats.crit,
        "CRIT / LVL" to championStats.critPerLevel
    )

    val rows = (stats.size + 1) / 2 // 2 colunas
    val itemHeight = 56.dp
    val totalHeight = rows * itemHeight

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "STATS",
            style = TextStyle(
                color = Color.White,
                fontFamily = CinzelFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            userScrollEnabled = false,
            modifier = Modifier.height(totalHeight),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(
                space = 24.dp,
                alignment = Alignment.CenterHorizontally
            )
        ) {
            items(stats.size) { index ->
                val (label, value) = stats[index]
                ChampionStatItem(label, value.toString())
            }
        }
    }
}

@Preview
@Composable
private fun ChampionStatsBoxPreview() {
    LegendsCompanionTheme {
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

        ChampionStatsBox(
            championStats = fakeStats
        )
    }
}

@Composable
private fun ChampionStatItem(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = label,
            color = LightGrayColor,
            fontSize = 12.sp
        )

        Text(
            text = value,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}

@Preview
@Composable
private fun ChampionStatItemPreview() {
    LegendsCompanionTheme {
        ChampionStatItem(
            label = "HP",
            value = "650"
        )
    }
}