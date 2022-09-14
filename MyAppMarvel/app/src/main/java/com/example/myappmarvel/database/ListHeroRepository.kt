package com.example.myappmarvel.database

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import com.example.myappmarvel.consumoAPI.ListarHerois
import com.example.myappmarvel.consumoAPI.RetrofitConfig
import com.example.myappmarvel.models.Hero
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber

class ListHeroRepository {

    private val listHeroDao = AppDatabase.invoke().listHeroDAO()
    private var disposable : Disposable? = null
    private var listarHerois = ListarHerois()

    @RequiresApi(Build.VERSION_CODES.N)
    fun insertAllHeroes(){
        disposable = listarHerois.getAllHeroes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                listHeroDao.insertHeroes(it)
                println("TESTEEEEEEEEEEEEEEEEEEE: Tudo adicionado no banco.")
                disposable?.dispose()

            },{ e ->
                e.printStackTrace()
                disposable?.dispose()
            })

    }

    fun getAllHeroes() : Observable<List<Hero>> {
        return listHeroDao.getAllHeroes()
    }

    fun getHero(name: String) : Observable<List<Hero>> {
        return listHeroDao.getHero(name)
    }

    fun getFavorites() : Observable<List<Hero>> {
        return listHeroDao.getFavorites()
    }

    fun setAsFavorite(hero: Hero) {
        return listHeroDao.setAsFavorite(hero)
    }

}