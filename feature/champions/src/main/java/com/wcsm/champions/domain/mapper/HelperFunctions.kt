package com.wcsm.champions.domain.mapper

fun buildSquareImage(version: String, image: String) =
    "https://ddragon.leagueoflegends.com/cdn/$version/img/champion/$image"

fun buildSplashImage(id: String) =
    "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/${id}_0.jpg"

fun buildLoadingImage(id: String) =
    "https://ddragon.leagueoflegends.com/cdn/img/champion/loading/${id}_0.jpg"

fun buildSpellImage(version: String, image: String) =
    "https://ddragon.leagueoflegends.com/cdn/$version/img/spell/$image"

fun buildPassiveImage(version: String, image: String) =
    "https://ddragon.leagueoflegends.com/cdn/$version/img/passive/$image"


private const val BASE_SPLASH =
    "https://ddragon.leagueoflegends.com/cdn/img/champion/splash"

private const val BASE_LOADING =
    "https://ddragon.leagueoflegends.com/cdn/img/champion/loading"

private const val BASE_SPELL =
    "https://ddragon.leagueoflegends.com/cdn/16.3.1/img/spell"

private const val BASE_PASSIVE =
    "https://ddragon.leagueoflegends.com/cdn/16.3.1/img/passive"

fun getSplashUrl(championId: String) =
    "$BASE_SPLASH/${championId}_0.jpg"

fun getLoadingImageUrl(championId: String) =
    "$BASE_LOADING/${championId}_0.jpg"

fun getSpellIconUrl(fileName: String) =
    "$BASE_SPELL/$fileName"

fun getPassiveIconUrl(fileName: String) =
    "$BASE_PASSIVE/$fileName"