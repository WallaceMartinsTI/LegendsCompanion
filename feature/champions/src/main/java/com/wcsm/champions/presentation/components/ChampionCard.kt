package com.wcsm.champions.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import coil3.compose.AsyncImage
import com.wcsm.core.presentation.ui.theme.CinzelFontFamily
import com.wcsm.core.presentation.ui.theme.LegendsCompanionTheme

@Composable
fun ChampionCard(
    championName: String,
    championImageName: String,
    onChampionClick: (championId: String) -> Unit
) {
    Column(
        modifier = Modifier.clickable { onChampionClick(championName) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // TODO: Passar essa URL para algum Helper futuramente
        AsyncImage(
            model = "https://ddragon.leagueoflegends.com/cdn/16.3.1/img/champion/$championImageName",
            contentDescription = "$championName square image.",
            modifier = Modifier.size(80.dp)
        )
        Text(
            text = championName,
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

@Preview
@Composable
private fun ChampionCardPreview() {
    LegendsCompanionTheme {
        ChampionCard(
            championName = "Aatrox",
            championImageName = "Aatrox.png",
            onChampionClick = {}
        )
    }
}