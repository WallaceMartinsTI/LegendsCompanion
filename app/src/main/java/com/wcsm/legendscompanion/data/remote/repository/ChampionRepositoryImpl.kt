package com.wcsm.legendscompanion.data.remote.repository

import com.wcsm.legendscompanion.data.remote.dto.AllChampionsResponseDto
import com.wcsm.legendscompanion.data.remote.service.RiotAPIService
import com.wcsm.legendscompanion.domain.model.BaseResponse
import com.wcsm.legendscompanion.domain.repository.ChampionRepository

class ChampionRepositoryImpl(
    private val service: RiotAPIService
) : ChampionRepository {
    override suspend fun getAllChampions(): BaseResponse<AllChampionsResponseDto> {
        return try {
            val result = service.getAllChampions()
            BaseResponse.Success(result)
        } catch (e: Exception) {
            BaseResponse.Error(e.message ?: "Erro ao buscar champions")
        }
    }
}