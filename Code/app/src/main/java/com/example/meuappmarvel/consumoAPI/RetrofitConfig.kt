package com.example.meuappmarvel.consumoAPI

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://gateway.marvel.com/")
        //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun MarvelAPIService() = retrofit.create(MarvelAPIService::class.java)

}