package com.wcsm.legendscompanion.presentation.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wcsm.legendscompanion.R
import com.wcsm.legendscompanion.presentation.ui.components.PageHeader
import com.wcsm.legendscompanion.presentation.ui.theme.BackgroundColor
import com.wcsm.legendscompanion.presentation.ui.theme.CinzelFontFamily
import com.wcsm.legendscompanion.presentation.ui.theme.LegendsCompanionTheme

@Composable
fun ChampionsView() {
    ChampionsTemplate()
}

@Composable
private fun ChampionsTemplate() {
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PageHeader(title = "CHAMPIONS")
        Spacer(Modifier.height(15.dp))

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(top = 32.dp, bottom = 32.dp)
            ) {
                items(80) { index ->
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(R.drawable.square_aatrox_test),
                            contentDescription = null,
                            modifier = Modifier.size(80.dp)
                        )
                        Text(
                            text = "Heimerdinger $index",
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
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .align(Alignment.TopCenter)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                BackgroundColor,
                                BackgroundColor.copy(alpha = 0.8f),
                                Color.Transparent
                            )
                        )
                    )
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .align(Alignment.BottomCenter)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                BackgroundColor.copy(alpha = 0.8f),
                                BackgroundColor
                            )
                        )
                    )
            )
        }
    }
}

@Preview
@Composable
private fun ChampionsTemplatePreview() {
    LegendsCompanionTheme {
        ChampionsTemplate()
    }
}