package com.example.meuappmarvel

import android.icu.util.Calendar
import android.icu.util.TimeZone
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meuappmarvel.models.Data
import com.example.meuappmarvel.models.Hero
import com.example.meuappmarvel.models.RetornoAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.math.BigInteger
import java.security.MessageDigest

class ListarHeroisActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_herois)


        val ts = (Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis / 1000L).toString()
        val API_Key = "2cdd07b6521311914ae6111bf96037d7"
        val PRIVATE_Key = "cf738073803abaa2062a785079b5ffaad66d13f0"
        val hash = md5(ts + PRIVATE_Key + API_Key)
        val limit = 100
        val offset = 0

        val call = RetrofitConfig().MarvelAPIService().listHero(ts, API_Key, hash, limit, offset, "Spider-Man")

        call.enqueue(object : Callback<RetornoAPI> {
            override fun onResponse(call: Call<RetornoAPI>, response: Response<RetornoAPI>) {
                if(response.isSuccessful){
                    response.body()?.let {
                        println("Cheguei aqui")

                        val results: List<Hero> = response.body()!!.data.results

                        println(results.toString())

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