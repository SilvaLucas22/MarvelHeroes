package com.example.myappmarvel.consumoAPI

import com.example.myappmarvel.models.Data
import com.example.myappmarvel.models.Hero
import com.example.myappmarvel.models.RetornoAPI
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelAPIService {

    @GET("/v1/public/characters")
    fun listAllHeroes(
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ) : Observable<RetornoAPI>

    @GET("/v1/public/characters")
    fun listHero(
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("nameStartsWith") nameStartsWith: String
    ) : Observable<RetornoAPI>

}