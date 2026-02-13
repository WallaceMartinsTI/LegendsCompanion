package com.wcsm.champions.data.repository

import android.util.Log
import com.wcsm.champions.data.remote.service.RiotChampionsAPIService
import com.wcsm.champions.domain.mapper.toChampion
import com.wcsm.champions.domain.model.Champion
import com.wcsm.champions.domain.repository.ChampionRepository
import com.wcsm.core.domain.model.BaseResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ChampionRepositoryImpl(
    private val riotChampionsAPIService: RiotChampionsAPIService
) : ChampionRepository {
    val logTag = "ChampionRepository"
    override fun getAllChampions(language: String): Flow<BaseResponse<List<Champion>>> = flow {
        emit(BaseResponse.Loading)

        try {
            val result = riotChampionsAPIService.getAllChampions(language)
            emit(BaseResponse.Success(result.data.values.toList().map { it.toChampion() }))
            Log.i(logTag, "Sucesso ao buscar todos os campeões.")
        } catch (e: Exception) {
            e.printStackTrace()
            emit(BaseResponse.Error("Erro ao buscar todos os campeões."))
            Log.i(logTag, "Erro ao buscar todos os campeões.")
        }
    }
}