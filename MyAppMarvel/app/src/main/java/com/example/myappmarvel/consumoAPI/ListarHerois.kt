package com.example.myappmarvel.consumoAPI

import android.icu.util.Calendar
import android.icu.util.TimeZone
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationManagerCompat.from
import com.example.myappmarvel.database.ListHeroRepository
import com.example.myappmarvel.models.Data
import com.example.myappmarvel.models.Hero
import com.example.myappmarvel.models.RetornoAPI
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.*
import timber.log.Timber
import java.math.BigInteger
import java.security.MessageDigest

class ListarHerois (){

    @RequiresApi(Build.VERSION_CODES.N)
    var ts = (Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis / 1000L).toString()
    val API_Key = "2cdd07b6521311914ae6111bf96037d7"
    val PRIVATE_Key = "cf738073803abaa2062a785079b5ffaad66d13f0"
    @RequiresApi(Build.VERSION_CODES.N)
    val hash = md5(ts + PRIVATE_Key + API_Key)
    val limit = 100
    var offset = 0

    @RequiresApi(Build.VERSION_CODES.N)
    fun getAllHeroes(): Single<List<Hero>> {
        return Observable.range(0, Integer.MAX_VALUE)
            .concatMap { count ->
                RetrofitConfig().MarvelAPIService().listAllHeroes(ts, API_Key, hash, limit, count*limit)
            }
            .takeUntil{ it.data.count == 0 }
            .reduceWith(
                { listOf<Hero>() },
                { all, current ->
                    all.plus(current.data.results)
                }
            )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun getHeroByName(name: String) : Single<List<Hero>> {
        //Essa função retornará uma lista com todos os heróis da API que comecem com o nome recebido como parâmetro.
        //Por exemplo, se receber "Spider-Man", retornará uma lista com todos os N spider-man que existem na Marvel.
        //Segui deste jeito para ser mais fácil ao usuário encontrar o herói que deseja, pois se procurasse apenas por "Spider-Man", a API retornaria sem heróis

        return Observable.range(0, Integer.MAX_VALUE)
            .concatMap { count ->
                RetrofitConfig().MarvelAPIService().listHero(ts, API_Key, hash, limit, count*limit, name)
            }
            .takeUntil { it.data.offset > it.data.total }
            .reduceWith(
                { listOf<Hero>() },
                { all, current ->
                    Timber.e("Incrementando a lista de heróis")
                    all.plus(current.data.results)
                }
            )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    }

    fun md5(input:String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }

}