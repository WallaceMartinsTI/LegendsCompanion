package com.wcsm.champions.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wcsm.champions.domain.model.ChampionTag
import com.wcsm.champions.domain.model.toDisplayName
import com.wcsm.core.presentation.ui.theme.BackgroundColor
import com.wcsm.core.presentation.ui.theme.ChampionTagAssassinColor
import com.wcsm.core.presentation.ui.theme.ChampionTagFighterColor
import com.wcsm.core.presentation.ui.theme.ChampionTagMageColor
import com.wcsm.core.presentation.ui.theme.ChampionTagMarksmanColor
import com.wcsm.core.presentation.ui.theme.ChampionTagSupportColor
import com.wcsm.core.presentation.ui.theme.ChampionTagTankColor
import com.wcsm.core.presentation.ui.theme.ChampionTagUnknownColor
import com.wcsm.core.presentation.ui.theme.InterFontFamily
import com.wcsm.core.presentation.ui.theme.LegendsCompanionTheme

@Composable
fun ChampionTagBox(
    championTag: ChampionTag,
    modifier: Modifier = Modifier
) {
    val tagColor = when(championTag) {
        ChampionTag.FIGHTER -> ChampionTagFighterColor
        ChampionTag.TANK -> ChampionTagTankColor
        ChampionTag.MAGE -> ChampionTagMageColor
        ChampionTag.ASSASSIN -> ChampionTagAssassinColor
        ChampionTag.SUPPORT -> ChampionTagSupportColor
        ChampionTag.MARKSMAN -> ChampionTagMarksmanColor
        ChampionTag.UNKNOWN -> ChampionTagUnknownColor
    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(50))
            .background(tagColor)
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            text = championTag.toDisplayName(),
            style = TextStyle(
                color = Color.Black,
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 2.sp
            )
        )
    }
}

@Preview
@Composable
private fun ChampionTagBoxPreview() {
    LegendsCompanionTheme {
        Column(
            modifier = Modifier.fillMaxSize().background(BackgroundColor),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ChampionTag.entries.forEach { championTag ->
                ChampionTagBox(
                    championTag = championTag
                )
                Spacer(Modifier.height(8.dp))
            }
        }
    }
}