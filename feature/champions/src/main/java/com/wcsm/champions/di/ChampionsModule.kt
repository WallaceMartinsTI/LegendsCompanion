package com.wcsm.champions.di

import com.wcsm.champions.data.remote.service.RiotAPIService
import com.wcsm.champions.data.repository.ChampionRepositoryImpl
import com.wcsm.champions.domain.repository.ChampionRepository
import com.wcsm.champions.domain.usecase.GetAllChampionsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ChampionsModule {
    @Provides
    @Singleton
    fun provideChampionRepository(
        service: RiotAPIService
    ): ChampionRepository {
        return ChampionRepositoryImpl(service = service)
    }

    @Provides
    fun provideGetAllChampionsUseCase(
        championRepository: ChampionRepository
    ): GetAllChampionsUseCase {
        return GetAllChampionsUseCase(championRepository = championRepository)
    }
}