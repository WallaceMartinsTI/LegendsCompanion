package com.wcsm.champions.presentation.ui.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.wcsm.core.presentation.ui.theme.LegendsCompanionTheme

@Composable
fun ChampionSummaryView() {
    ChampionSummaryTemplate()
}

@Composable
private fun ChampionSummaryTemplate() {

}

@Preview
@Composable
private fun ChampionSummaryTemplatePreview() {
    LegendsCompanionTheme {
        ChampionSummaryTemplate()
    }
}