package com.wcsm.legendscompanion.presentation.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface AppRoutes {
    @Serializable
    data object Welcome : AppRoutes, NavKey

    @Serializable
    data object Champions : AppRoutes, NavKey

    @Serializable
    data object Items : AppRoutes, NavKey
}