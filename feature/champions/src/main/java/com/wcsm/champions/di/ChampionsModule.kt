package com.wcsm.champions.di

import com.wcsm.champions.data.remote.service.RiotChampionsAPIService
import com.wcsm.champions.data.repository.ChampionRepositoryImpl
import com.wcsm.champions.domain.repository.ChampionRepository
import com.wcsm.champions.domain.usecase.GetAllChampionsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ChampionsModule {

    @Provides
    @Singleton
    fun provideRiotChampionsAPIService(retrofit: Retrofit): RiotChampionsAPIService {
        return retrofit.create(RiotChampionsAPIService::class.java)
    }

    @Provides
    @Singleton
    fun provideChampionRepository(
        riotChampionsAPIService: RiotChampionsAPIService
    ): ChampionRepository {
        return ChampionRepositoryImpl(riotChampionsAPIService = riotChampionsAPIService)
    }

    @Provides
    fun provideGetAllChampionsUseCase(
        championRepository: ChampionRepository
    ): GetAllChampionsUseCase {
        return GetAllChampionsUseCase(championRepository = championRepository)
    }
}