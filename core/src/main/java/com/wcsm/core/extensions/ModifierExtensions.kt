package com.wcsm.core.extensions

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun Modifier.shimmer(): Modifier = composed {

    val transition = rememberInfiniteTransition(label = "shimmer")

    val translateAnim = transition.animateFloat(
        initialValue = -300f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = LinearEasing)
        ),
        label = "shimmerAnim"
    )

    val brush = Brush.linearGradient(
        colors = listOf(
            Color(0xFF2A2A2A),
            Color(0xFF3A3A3A),
            Color(0xFF2A2A2A)
        ),
        start = Offset(translateAnim.value, 0f),
        end = Offset(translateAnim.value + 300f, 300f)
    )

    background(brush)
}