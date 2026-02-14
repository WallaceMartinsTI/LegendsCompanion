package com.wcsm.champions.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.wcsm.champions.domain.model.ChampionInfo
import com.wcsm.core.presentation.ui.theme.ChampionInfoAttackColor
import com.wcsm.core.presentation.ui.theme.ChampionInfoDefenseColor
import com.wcsm.core.presentation.ui.theme.ChampionInfoDifficultyColor
import com.wcsm.core.presentation.ui.theme.ChampionInfoMagicColor
import com.wcsm.core.presentation.ui.theme.CinzelFontFamily
import com.wcsm.core.presentation.ui.theme.LegendsCompanionTheme

@Composable
fun ChampionInfoBox(
    championInfo: ChampionInfo,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "INFO",
            style = TextStyle(
                color = Color.White,
                fontFamily = CinzelFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        ChampionInfoRow("Attack", championInfo.attack)
        ChampionInfoRow("Defense", championInfo.defense)
        ChampionInfoRow("Magic", championInfo.magic)
        ChampionInfoRow("Difficulty", championInfo.difficulty)
    }
}

@Preview
@Composable
private fun ChampionInfoBoxPreview() {
    LegendsCompanionTheme {
        val championInfo = ChampionInfo(
            attack = 8,
            defense = 6,
            magic = 1,
            difficulty = 4
        )
        ChampionInfoBox(
            championInfo = championInfo
        )
    }
}

@Composable
private fun ChampionInfoRow(
    label: String,
    value: Int
) {
    val color = statColor(label)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = label,
            modifier = Modifier.width(80.dp),
            color = Color.White,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp
        )

        SegmentedStatBar(
            value = value,
            activeColor = color,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp)
        )

        Text(
            text = value.toString(),
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        )
    }
}

@Preview
@Composable
private fun ChampionInfoRowPreview() {
    LegendsCompanionTheme { 
        ChampionInfoRow(
            label = "Attack",
            value = 8
        )
    }
}

@Composable
private fun SegmentedStatBar(
    value: Int,
    modifier: Modifier = Modifier,
    max: Int = 10,
    activeColor: Color = Color(0xFFFFD54F),
    inactiveColor: Color = Color(0x33FFFFFF)
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        repeat(max) { index ->
            Box(
                modifier = Modifier
                    .height(10.dp)
                    .weight(1f)
                    .background(
                        color = if (index < value) activeColor else inactiveColor,
                        shape = RoundedCornerShape(2.dp)
                    )
            )
        }
    }
}

@Preview
@Composable
private fun SegmentedStatBarPreview() {
    LegendsCompanionTheme {
        SegmentedStatBar(
            value = 8,
            max = 10
        )
    }
}

//TODO:  Treat when there are other languages.
fun statColor(label: String): Color {
    return when (label.uppercase()) {
        "ATTACK" -> ChampionInfoAttackColor
        "DEFENSE" -> ChampionInfoDefenseColor
        "MAGIC" -> ChampionInfoMagicColor
        "DIFFICULTY" -> ChampionInfoDifficultyColor
        else -> Color(0xFFFFD54F)
    }
}