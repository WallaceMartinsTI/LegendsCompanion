package com.wcsm.core.presentation.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage
import com.wcsm.core.extensions.shimmer

@Composable
fun NetworkImageBox(
    imageUrl: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    asyncImageModifier: Modifier = Modifier,
) {
    var isSplashImageLoading by remember { mutableStateOf(true) }

    Box(
        modifier = modifier
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = contentDescription,
            modifier = asyncImageModifier,
            onSuccess = {
                isSplashImageLoading = false
            },
            onError = {},
        )

        if(isSplashImageLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .shimmer()
            )
        }
    }
}