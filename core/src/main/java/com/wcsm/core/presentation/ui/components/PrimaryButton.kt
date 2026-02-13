package com.wcsm.core.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wcsm.core.presentation.ui.theme.CinzelFontFamily
import com.wcsm.core.utils.UnitCallback

@Composable
fun PrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: UnitCallback,
) {
    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFC8AA6F),
            Color(0xFFB3955A),
            Color(0xFF785A28)
        )
    )

    Box(
        modifier = modifier
            .size(width = 320.dp, height = 60.dp)
            .shadow(
                elevation = 20.dp,
                shape = RoundedCornerShape(5.dp),
                ambientColor = Color(0x66C8AA6F), // 40% alpha
                spotColor = Color(0x66C8AA6F)
            )
            .background(
                brush = gradient,
                shape = RoundedCornerShape(5.dp)
            )
            .clip(RoundedCornerShape(5.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color(0xFF1E1A14),
            style = TextStyle(
                fontFamily = CinzelFontFamily,
                fontSize = 20.sp,
                fontWeight = FontWeight.Black,
                lineHeight = 28.sp,
                letterSpacing = 6.sp
            )
        )
    }
}

@Preview
@Composable
fun PrimaryButtonPreview() {
    PrimaryButton(
        text = "ENTER",
        onClick = {}
    )
}