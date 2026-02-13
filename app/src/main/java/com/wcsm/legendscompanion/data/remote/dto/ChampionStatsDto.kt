package com.wcsm.legendscompanion.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ChampionStatsDto(
    @SerializedName("hp")
    val hp: Double,

    @SerializedName("hpperlevel")
    val hpPerLevel: Double,

    @SerializedName("mp")
    val mp: Double,

    @SerializedName("mpperlevel")
    val mpPerLevel: Double,

    @SerializedName("movespeed")
    val moveSpeed: Double,

    @SerializedName("armor")
    val armor: Double,

    @SerializedName("armorperlevel")
    val armorPerLevel: Double,

    @SerializedName("spellblock")
    val spellBlock: Double,

    @SerializedName("spellblockperlevel")
    val spellBlockPerLevel: Double,

    @SerializedName("attackrange")
    val attackRange: Double,

    @SerializedName("hpregen")
    val hpRegen: Double,

    @SerializedName("hpregenperlevel")
    val hpRegenPerLevel: Double,

    @SerializedName("mpregen")
    val mpRegen: Double,

    @SerializedName("mpregenperlevel")
    val mpRegenPerLevel: Double,

    @SerializedName("crit")
    val crit: Double,

    @SerializedName("critperlevel")
    val critPerLevel: Double,

    @SerializedName("attackdamage")
    val attackDamage: Double,

    @SerializedName("attackdamageperlevel")
    val attackDamagePerLevel: Double,

    @SerializedName("attackspeedperlevel")
    val attackSpeedPerLevel: Double,

    @SerializedName("attackspeed")
    val attackSpeed: Double
)
