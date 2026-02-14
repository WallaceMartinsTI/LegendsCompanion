package com.wcsm.champions.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.wcsm.core.presentation.ui.theme.BackgroundColor
import com.wcsm.core.presentation.ui.theme.CinzelFontFamily
import com.wcsm.core.presentation.ui.theme.LegendsCompanionTheme
import com.wcsm.core.presentation.ui.theme.LightGrayColor

@Composable
fun ChampionSummaryHeader(
    championName: String,
    championTitle: String,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(BackgroundColor)
            .padding(vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = championName,
            style = TextStyle(
                color = Color.White,
                fontFamily = CinzelFontFamily,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
            )
        )

        Text(
            text = championTitle,
            style = TextStyle(
                color = LightGrayColor,
                fontFamily = CinzelFontFamily,
                fontSize = 14.sp,
            )
        )
    }
}

@Preview
@Composable
private fun ChampionSummaryHeaderPreview() {
    LegendsCompanionTheme {
        ChampionSummaryHeader(
            championName = "Aatrox",
            championTitle = "The Darkin Blade"
        )
    }
}