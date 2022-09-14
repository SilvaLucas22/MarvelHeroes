package com.example.myappmarvel.favorites

import com.example.myappmarvel.databinding.ItemHeroBinding
import com.example.myappmarvel.models.Hero

interface FavoritesListener {

    fun onNotificationPressed(heroi : Hero)
    fun clickOnStarIcon(heroi: Hero, itemHero: ItemHeroBinding)

}