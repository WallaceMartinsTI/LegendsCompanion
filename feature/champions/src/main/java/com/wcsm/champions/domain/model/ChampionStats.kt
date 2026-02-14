package com.wcsm.champions.domain.model

data class ChampionStats(
    val hp: Double,
    val hpPerLevel: Double,
    val mp: Double,
    val mpPerLevel: Double,
    val attackDamage: Double,
    val attackDamagePerLevel: Double,
    val attackSpeedPerLevel: Double,
    val attackSpeed: Double,
    val moveSpeed: Double,
    val hpRegen: Double,
    val hpRegenPerLevel: Double,
    val mpRegen: Double,
    val mpRegenPerLevel: Double,
    val armor: Double,
    val armorPerLevel: Double,
    val spellBlock: Double,
    val spellBlockPerLevel: Double,
    val attackRange: Double,
    val crit: Double,
    val critPerLevel: Double
)
