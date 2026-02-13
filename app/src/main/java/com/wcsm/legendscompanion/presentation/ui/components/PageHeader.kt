package com.wcsm.legendscompanion.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wcsm.legendscompanion.presentation.ui.theme.CinzelFontFamily
import com.wcsm.legendscompanion.presentation.ui.theme.LegendsCompanionTheme
import com.wcsm.legendscompanion.presentation.ui.theme.LightBeigeColor

@Composable
fun PageHeader(
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = TextStyle(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFF0E6D2),
                        Color(0xFFC8AA6F),
                        Color(0xFF785A28)
                    )
                ),
                fontFamily = CinzelFontFamily,
                fontSize = 36.sp,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center,
                lineHeight = 40.sp,
                letterSpacing = 7.sp
            ),
            modifier = Modifier.padding(bottom = 30.dp)
        )
        HorizontalDivider(thickness = 1.dp, color = LightBeigeColor)
    }
}

@Preview
@Composable
private fun PageHeaderPreview() {
    LegendsCompanionTheme {
        PageHeader(
            title = "CHAMPIONS"
        )
    }
}