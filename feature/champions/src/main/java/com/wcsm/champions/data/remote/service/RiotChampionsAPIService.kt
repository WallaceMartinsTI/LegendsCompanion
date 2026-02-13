package com.wcsm.champions.data.remote.service

import com.wcsm.champions.data.remote.dto.AllChampionsResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RiotChampionsAPIService {
    @GET("16.3.1/data/{language}/champion.json")
    suspend fun getAllChampions(
        @Path("language") language: String
    ): AllChampionsResponseDto
}