package com.wcsm.champions.domain.usecase

import com.wcsm.champions.domain.model.Champion
import com.wcsm.champions.domain.repository.ChampionRepository
import com.wcsm.core.domain.model.BaseResponse
import kotlinx.coroutines.flow.Flow

class GetAllChampionsUseCase(
    private val championRepository: ChampionRepository
) {
    operator fun invoke(): Flow<BaseResponse<List<Champion>>> {
        return championRepository.getAllChampions()
    }
}