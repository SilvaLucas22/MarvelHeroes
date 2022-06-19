package com.example.meuappmarvel

import android.icu.util.Calendar
import android.icu.util.TimeZone
import com.example.meuappmarvel.models.Hero
import com.example.meuappmarvel.models.RetornoAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.math.BigInteger
import java.security.MessageDigest

class ListarHerois {

    var ts = (Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis / 1000L).toString()
    val API_Key = "2cdd07b6521311914ae6111bf96037d7"
    val PRIVATE_Key = "cf738073803abaa2062a785079b5ffaad66d13f0"
    val hash = md5(ts + PRIVATE_Key + API_Key)
    val limit = 100
    var offset = 0
    var listHeroes : MutableList<Hero> = ArrayList()

    fun getAllHeroes(offset: Int) {
        //Essa função retornará uma lista com todos os heróis da API
        val call = RetrofitConfig().MarvelAPIService().listAllHeroes(ts, API_Key, hash, limit, offset)

        call.enqueue(object : Callback<RetornoAPI> {
            override fun onResponse(call: Call<RetornoAPI>, response: Response<RetornoAPI>) {
                if(response.isSuccessful){
                    response.body()?.let {
                        listHeroes.addAll(response.body()!!.data.results)
                        //total = response.body()!!.data.getTotal()
                        //println("Total = " + total)
                        //println(listHeroes.toString())

                    }
                } else{
                    println("Sucesso no get, mas body vazio: " + response.errorBody().toString())
                }
            }
            override fun onFailure(call: Call<RetornoAPI>, t: Throwable) {
                t.message?.let {
                    println("Mensagem de erro do Lucas: $it")
                }
            }
        })
    }

    fun getHeroByName(name: String) {
        //Essa função retornará uma lista com todos os heróis da API que comecem com o nome recebido como parâmetro.
        //Por exemplo, se receber "Spider-Man", retornará uma lista com todos os N spider-man que existem na Marvel.
        //Segui deste jeito para ser mais fácil ao usuário encontrar o herói que deseja, pois se procurasse apenas por "Spider-Man", a API retornaria sem heróis
        val call = RetrofitConfig().MarvelAPIService().listHero(ts, API_Key, hash, limit, offset, name)

        call.enqueue(object : Callback<RetornoAPI> {
            override fun onResponse(call: Call<RetornoAPI>, response: Response<RetornoAPI>) {
                if(response.isSuccessful){
                    response.body()?.let {
                        listHeroes.addAll(response.body()!!.data.results)
                        //total = response.body()!!.data.getTotal()
                        //println("Total = " + total)
                        //println(listHeroes.toString())

                    }
                } else{
                    println("Sucesso no get, mas body vazio: " + response.errorBody().toString())
                }
            }
            override fun onFailure(call: Call<RetornoAPI>, t: Throwable) {
                t.message?.let {
                    println("Mensagem de erro do Lucas: $it")
                }
            }
        })
    }

    fun md5(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }

}