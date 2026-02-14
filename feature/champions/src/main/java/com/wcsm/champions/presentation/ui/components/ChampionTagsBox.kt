package com.wcsm.champions.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wcsm.champions.domain.model.ChampionTag
import com.wcsm.core.presentation.ui.theme.LegendsCompanionTheme

@Composable
fun ChampionTagsBox(
    championTags: List<ChampionTag>
) {
    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            space = 8.dp,
            alignment = Alignment.CenterHorizontally
        ),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        championTags.forEach { tag ->
            ChampionTagBox(championTag = tag)
        }
    }
}

@Preview
@Composable
private fun ChampionTagsBoxPreview() {
    LegendsCompanionTheme {
        val tags = ChampionTag.entries

        ChampionTagsBox(
            championTags = tags
        )
    }
}