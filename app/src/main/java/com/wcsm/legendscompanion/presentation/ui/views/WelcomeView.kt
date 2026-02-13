package com.wcsm.legendscompanion.presentation.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wcsm.legendscompanion.R
import com.wcsm.legendscompanion.presentation.ui.components.PrimaryButton
import com.wcsm.legendscompanion.presentation.ui.theme.CinzelFontFamily
import com.wcsm.legendscompanion.presentation.ui.theme.InterFontFamily
import com.wcsm.legendscompanion.presentation.ui.theme.LegendsCompanionTheme
import com.wcsm.legendscompanion.utils.UnitCallback

@Composable
fun WelcomeView(
    onEnterClick: UnitCallback
) {
    WelcomeTemplate(
        onEnterClick = onEnterClick
    )
}

@Composable
private fun WelcomeTemplate(
    onEnterClick: UnitCallback
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(R.drawable.background_image),
                contentScale = ContentScale.Crop
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(80.dp))

        Text(
            text = "LEGENDS\nCOMPANION",
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
            )
        )

        Text(
            text = "EXPLORE CHAMPIONS AND ITEMS",
            color = Color.White,
            style = TextStyle(
                fontFamily = InterFontFamily,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center,
                lineHeight = 20.sp,
                letterSpacing = 2.sp
            ),
            modifier = Modifier.padding(top = 12.dp)
        )

        Spacer(Modifier.weight(1f))

        PrimaryButton(
            text = "ENTER",
            onClick = onEnterClick
        )

        Text(
            text = "APP VERSION 1.0",
            style = TextStyle(
                fontFamily = InterFontFamily,
                fontSize = 10.sp,
                lineHeight = 15.sp,
                letterSpacing = 2.sp
            ),
            color = Color(0x80C8AA6F),
            modifier = Modifier.padding(top = 32.dp, bottom = 80.dp)
        )
    }
}

@Preview
@Composable
private fun WelcomeTemplatePreview() {
    LegendsCompanionTheme {
        WelcomeTemplate(
            onEnterClick = {}
        )
    }
}