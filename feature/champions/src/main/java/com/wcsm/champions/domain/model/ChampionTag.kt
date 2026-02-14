package com.wcsm.champions.domain.model

enum class ChampionTag {
    FIGHTER,
    TANK,
    MAGE,
    ASSASSIN,
    SUPPORT,
    MARKSMAN,
    UNKNOWN
}

// TODO: Treat when there are other languages.
fun ChampionTag.toDisplayName(): String {
    return when (this) {
        ChampionTag.FIGHTER -> "Fighter"
        ChampionTag.TANK -> "Tank"
        ChampionTag.MAGE -> "Mage"
        ChampionTag.ASSASSIN -> "Assassin"
        ChampionTag.SUPPORT -> "Support"
        ChampionTag.MARKSMAN -> "Marksman"
        ChampionTag.UNKNOWN -> "Unknown"
    }
}