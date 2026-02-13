package com.wcsm.legendscompanion.data.remote.service

import com.wcsm.legendscompanion.data.remote.dto.AllChampionsResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RiotAPIService {
    @GET("16.3.1/data/{language}/champion.json")
    suspend fun getAllChampions(
        @Path("language") language: String = "en_US"
    ): AllChampionsResponseDto
}