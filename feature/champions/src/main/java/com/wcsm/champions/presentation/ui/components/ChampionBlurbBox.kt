package com.wcsm.champions.presentation.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wcsm.core.presentation.ui.theme.CinzelFontFamily
import com.wcsm.core.presentation.ui.theme.LegendsCompanionTheme

@Composable
fun ChampionBlurbBox(
    championBlurb: String
) {
    Text(
        text = championBlurb,
        style = TextStyle(
            color = Color.White,
            fontFamily = CinzelFontFamily
        ),
        modifier = Modifier.padding(16.dp)
    )
}

@Preview
@Composable
private fun ChampionBlurbBoxPreview() {
    LegendsCompanionTheme {
        ChampionBlurbBox(
            championBlurb = "Once honored defenders of Shurima against the Void, Aatrox and his brethren would eventually become an even greater threat to Runeterra, and were defeated only by cunning mortal sorcery. But after centuries of imprisonment, Aatrox was the first to find..."
        )
    }
}