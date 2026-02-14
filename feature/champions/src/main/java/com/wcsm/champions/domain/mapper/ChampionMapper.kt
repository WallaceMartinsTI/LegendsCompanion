package com.wcsm.champions.domain.mapper

import com.wcsm.champions.data.remote.dto.ChampionDto
import com.wcsm.champions.data.remote.dto.ChampionInfoDto
import com.wcsm.champions.domain.model.Champion
import com.wcsm.champions.domain.model.ChampionInfo
import com.wcsm.champions.extensions.toChampionTag
import com.wcsm.champions.extensions.toParType

fun ChampionInfoDto.toChampionInfo(): ChampionInfo {
    return ChampionInfo(
        attack = attack,
        defense = defense,
        magic = magic,
        difficulty = difficulty
    )
}

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
        parType = parType.toParType() // TODO: Treat when there are other languages.
    )
}