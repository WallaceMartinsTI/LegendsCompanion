package com.wcsm.champions.domain.model

data class Champion(
    val id: String,
    val key: String,
    val name: String,
    val title: String,
    val blurb: String,
    val info: ChampionInfo,
    val image: String,
    val tags: List<ChampionTag>,
    val parType: ChampionParType,
    val stats: ChampionStats
)
