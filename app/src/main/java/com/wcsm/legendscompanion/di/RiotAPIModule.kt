package com.wcsm.legendscompanion.di

import com.wcsm.legendscompanion.data.remote.repository.ChampionRepositoryImpl
import com.wcsm.legendscompanion.data.remote.service.RiotAPIService
import com.wcsm.legendscompanion.domain.repository.ChampionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RiotAPIModule {

    @Provides
    @Singleton
    fun provideRiotAPIService(retrofit: Retrofit): RiotAPIService {
        return retrofit.create(RiotAPIService::class.java)
    }

    @Provides
    @Singleton
    fun provideChampionRepository(
        service: RiotAPIService
    ): ChampionRepository {
        return ChampionRepositoryImpl(service = service)
    }
}