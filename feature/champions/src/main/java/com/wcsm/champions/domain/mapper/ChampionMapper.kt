package com.wcsm.champions.domain.mapper

import com.wcsm.champions.data.remote.dto.ChampionDto
import com.wcsm.champions.data.remote.dto.ChampionInfoDto
import com.wcsm.champions.domain.model.Champion
import com.wcsm.champions.domain.model.ChampionInfo

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
        tags = tags,
        parType = parType
    )
}