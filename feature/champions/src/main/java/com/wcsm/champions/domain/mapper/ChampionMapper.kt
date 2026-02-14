package com.wcsm.champions.domain.mapper

import com.wcsm.champions.data.remote.dto.ChampionDto
import com.wcsm.champions.data.remote.dto.ChampionInfoDto
import com.wcsm.champions.data.remote.dto.ChampionStatsDto
import com.wcsm.champions.domain.model.Champion
import com.wcsm.champions.domain.model.ChampionInfo
import com.wcsm.champions.domain.model.ChampionStats
import com.wcsm.champions.extensions.toChampionTag
import com.wcsm.champions.extensions.toParType

fun ChampionDto.toChampion(): Champion {
    return Champion(
        id = id,
        key = key,
        name = name,
        title = title,
        blurb = blurb,
        info = info.toChampionInfo(),
        image = image.full,
        tags = tags.map { it.toChampionTag() }, // TODO: Treat when there are other languages.
        parType = parType.toParType(), // TODO: Treat when there are other languages.
        stats = stats.toChampionStats()
    )
}

fun ChampionInfoDto.toChampionInfo(): ChampionInfo {
    return ChampionInfo(
        attack = attack,
        defense = defense,
        magic = magic,
        difficulty = difficulty
    )
}

fun ChampionStatsDto.toChampionStats(): ChampionStats {
    return ChampionStats(
        hp = hp,
        hpPerLevel = hpPerLevel,
        mp = mp,
        mpPerLevel = mpPerLevel,
        attackDamage = attackDamage,
        attackDamagePerLevel = attackDamagePerLevel,
        attackSpeedPerLevel = attackSpeedPerLevel,
        attackSpeed = attackSpeed,
        moveSpeed = moveSpeed,
        armor = armor,
        armorPerLevel = armorPerLevel,
        spellBlock = spellBlock,
        spellBlockPerLevel = spellBlockPerLevel,
        attackRange = attackRange,
        hpRegen = hpRegen,
        hpRegenPerLevel = hpRegenPerLevel,
        mpRegen = mpRegen,
        mpRegenPerLevel = mpRegenPerLevel,
        crit = crit,
        critPerLevel = critPerLevel
    )
}