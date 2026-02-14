package com.wcsm.champions.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.wcsm.champions.domain.model.ChampionParType
import com.wcsm.champions.domain.model.toDisplayName
import com.wcsm.core.presentation.ui.theme.BackgroundColor
import com.wcsm.core.presentation.ui.theme.ChampionParTypeBloodWellColor
import com.wcsm.core.presentation.ui.theme.ChampionParTypeCourageColor
import com.wcsm.core.presentation.ui.theme.ChampionParTypeEnergyColor
import com.wcsm.core.presentation.ui.theme.ChampionParTypeFerocityColor
import com.wcsm.core.presentation.ui.theme.ChampionParTypeFlowColor
import com.wcsm.core.presentation.ui.theme.ChampionParTypeHeatColor
import com.wcsm.core.presentation.ui.theme.ChampionParTypeManaColor
import com.wcsm.core.presentation.ui.theme.ChampionParTypeNoneColor
import com.wcsm.core.presentation.ui.theme.ChampionParTypeRageColor
import com.wcsm.core.presentation.ui.theme.ChampionParTypeUnknownColor
import com.wcsm.core.presentation.ui.theme.InterFontFamily
import com.wcsm.core.presentation.ui.theme.LegendsCompanionTheme

@Composable
fun ChampionParTypeBox(
    championParType: ChampionParType,
    modifier: Modifier = Modifier
) {
    val parTypeColor = when(championParType) {
        ChampionParType.MANA -> ChampionParTypeManaColor
        ChampionParType.ENERGY -> ChampionParTypeEnergyColor
        ChampionParType.RAGE -> ChampionParTypeRageColor
        ChampionParType.HEAT -> ChampionParTypeHeatColor
        ChampionParType.NONE -> ChampionParTypeNoneColor
        ChampionParType.BLOOD_WELL -> ChampionParTypeBloodWellColor
        ChampionParType.FEROCITY -> ChampionParTypeFerocityColor
        ChampionParType.FLOW -> ChampionParTypeFlowColor
        ChampionParType.COURAGE -> ChampionParTypeCourageColor
        ChampionParType.UNKNOWN -> ChampionParTypeUnknownColor
    }

    Box(
        modifier = modifier
            .background(parTypeColor)
            .padding(4.dp)
    ) {
        Text(
            text = championParType.toDisplayName().uppercase(),
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
private fun ChampionParTypeBoxPreview() {
    LegendsCompanionTheme {
        Column(
            modifier = Modifier.fillMaxSize().background(BackgroundColor),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ChampionParType.entries.forEach { parType ->
                ChampionParTypeBox(
                    championParType = parType
                )
                Spacer(Modifier.height(8.dp))
            }
        }
    }
}