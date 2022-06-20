package com.example.meuappmarvel

import com.example.meuappmarvel.models.RetornoAPI
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelAPIService {

    @GET("/v1/public/characters")
    suspend fun listAllHeroes(
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ) : Response<RetornoAPI>

    @GET("/v1/public/characters")
    suspend fun listHero(
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("nameStartsWith") nameStartsWith: String
    ) : Response<RetornoAPI>

}