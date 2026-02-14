package com.wcsm.champions.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.wcsm.core.extensions.shimmer
import com.wcsm.core.presentation.ui.theme.BackgroundColor
import com.wcsm.core.presentation.ui.theme.CinzelFontFamily
import com.wcsm.core.presentation.ui.theme.LegendsCompanionTheme
import com.wcsm.core.presentation.ui.theme.LightGrayColor

@Composable
fun ChampionSummaryHeader(
    championName: String,
    championTitle: String
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

// TODO: Check if it will be used
// Shimmer for this component
/*
Column(
modifier = Modifier
.fillMaxWidth()
.background(BackgroundColor)
.padding(vertical = 12.dp),
horizontalAlignment = Alignment.CenterHorizontally
) {
    Box(
        modifier = Modifier
            .width(140.dp)
            .height(24.dp)
            .clip(RoundedCornerShape(4.dp))
            .shimmer()
    )

    Spacer(Modifier.height(6.dp))

    Box(
        modifier = Modifier
            .width(100.dp)
            .height(14.dp)
            .clip(RoundedCornerShape(4.dp))
            .shimmer()
    )
}*/
