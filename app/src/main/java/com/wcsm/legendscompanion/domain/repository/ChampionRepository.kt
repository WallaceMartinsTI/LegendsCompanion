package com.wcsm.legendscompanion.domain.repository

import com.wcsm.legendscompanion.data.remote.dto.AllChampionsResponseDto
import com.wcsm.legendscompanion.domain.model.BaseResponse

interface ChampionRepository {
    suspend fun getAllChampions(): BaseResponse<AllChampionsResponseDto>
}