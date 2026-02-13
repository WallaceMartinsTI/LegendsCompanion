package com.wcsm.champions.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ChampionDto(
    val version: String,
    val id: String,
    val key: String,
    val name: String,
    val title: String,
    val blurb: String,
    val info: ChampionInfoDto,
    val image: ChampionImageDto,
    val tags: List<String>,
    @SerializedName("partype")
    val parType: String
)
