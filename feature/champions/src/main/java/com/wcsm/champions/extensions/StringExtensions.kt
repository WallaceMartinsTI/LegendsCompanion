package com.wcsm.champions.extensions

import com.wcsm.champions.domain.model.ChampionParType
import com.wcsm.champions.domain.model.ChampionTag

fun String.toParType(): ChampionParType {
    return when (this) {
        "Mana" -> ChampionParType.MANA
        "Energy" -> ChampionParType.ENERGY
        "Fury" -> ChampionParType.RAGE
        "Heat" -> ChampionParType.HEAT
        "Blood Well" -> ChampionParType.BLOOD_WELL
        "Ferocity" -> ChampionParType.FEROCITY
        "Flow" -> ChampionParType.FLOW
        "Courage" -> ChampionParType.COURAGE
        else -> ChampionParType.UNKNOWN
    }
}

fun String.toChampionTag(): ChampionTag {
    return when (this.lowercase()) {
        "fighter" -> ChampionTag.FIGHTER
        "tank" -> ChampionTag.TANK
        "mage" -> ChampionTag.MAGE
        "assassin" -> ChampionTag.ASSASSIN
        "support" -> ChampionTag.SUPPORT
        "marksman" -> ChampionTag.MARKSMAN
        else -> ChampionTag.UNKNOWN
    }
}