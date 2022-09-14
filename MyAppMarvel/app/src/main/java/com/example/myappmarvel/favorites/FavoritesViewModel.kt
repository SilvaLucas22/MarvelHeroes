package com.example.myappmarvel.favorites

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import com.example.myappmarvel.database.ListHeroRepository
import com.example.myappmarvel.models.Hero
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class FavoritesViewModel {

    private var disposabletest : Disposable? = null
    private val listHeroRepository: ListHeroRepository by lazy {
        ListHeroRepository()
    }
    val heroesListLiveData = MutableLiveData<List<Hero>>()

    @RequiresApi(Build.VERSION_CODES.N)
    fun getFavorites() {
        disposabletest = listHeroRepository.getFavorites()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                disposabletest?.dispose()
                heroesListLiveData.value = it

            },{ e ->
                disposabletest?.dispose()
                e.printStackTrace()
            })

    }

    fun setAsFavorite(hero: Hero){
        listHeroRepository.setAsFavorite(hero)
    }

}