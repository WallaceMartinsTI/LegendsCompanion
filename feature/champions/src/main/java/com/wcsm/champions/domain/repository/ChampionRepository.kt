package com.wcsm.champions.domain.repository

import com.wcsm.champions.domain.model.Champion
import com.wcsm.core.domain.model.BaseResponse
import kotlinx.coroutines.flow.Flow

interface ChampionRepository {
    fun getAllChampions(
        language: String = "en_US"
    ): Flow<BaseResponse<List<Champion>>>
}