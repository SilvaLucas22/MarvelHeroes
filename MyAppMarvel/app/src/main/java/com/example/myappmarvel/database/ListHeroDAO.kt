package com.example.myappmarvel.database

import androidx.room.*
import com.example.myappmarvel.models.Hero
import io.reactivex.rxjava3.core.Observable

@Dao
interface ListHeroDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertHeroes(heroes : List<Hero>)

    @Query("SELECT * FROM Hero")
    fun getAllHeroes(): Observable<List<Hero>>

    @Query("SELECT * FROM Hero WHERE name LIKE '%' || :name || '%'")
    fun getHero(name: String): Observable<List<Hero>>

    @Query("SELECT * FROM Hero WHERE isFavorite = 1")
    fun getFavorites(): Observable<List<Hero>>

    @Update
    fun setAsFavorite(hero: Hero)

}