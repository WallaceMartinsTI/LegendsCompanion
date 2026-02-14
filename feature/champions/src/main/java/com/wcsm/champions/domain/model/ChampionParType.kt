package com.wcsm.champions.domain.model

enum class ChampionParType {
    MANA, // Use Mana as default
    ENERGY, // Use Energy as Default (Eg.: 'Akali', 'Zed')
    RAGE, // Use Fury (Eg.: 'Renekton')
    HEAT, // Use Heat (Eg.: 'Rumble')
    NONE, // Don't use any resource (Eg.: 'Garen')
    BLOOD_WELL, // Unique 'Aatrox' resource
    FEROCITY, // 'Rengar' resource
    FLOW, // 'Yasuo' and 'Yone' resource
    COURAGE, // 'Kled' resource
    UNKNOWN // Safe Fallback
}

// TODO: Treat when there are other languages.
fun ChampionParType.toDisplayName(): String {
    return when (this) {
        ChampionParType.MANA -> "Mana"
        ChampionParType.ENERGY -> "Energy"
        ChampionParType.RAGE -> "Fury"
        ChampionParType.HEAT -> "Heat"
        ChampionParType.NONE -> "None"
        ChampionParType.BLOOD_WELL -> "Blood Well"
        ChampionParType.FEROCITY -> "Ferocity"
        ChampionParType.FLOW -> "Flow"
        ChampionParType.COURAGE -> "Courage"
        ChampionParType.UNKNOWN -> "Unknown"
    }
}