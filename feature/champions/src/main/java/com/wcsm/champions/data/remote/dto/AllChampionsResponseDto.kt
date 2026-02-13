package com.wcsm.champions.data.remote.dto

data class AllChampionsResponseDto(
    val type: String,
    val format: String,
    val version: String,
    val data: Map<String, ChampionDto>
)
