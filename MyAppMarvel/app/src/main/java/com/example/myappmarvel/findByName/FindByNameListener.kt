package com.example.myappmarvel.findByName

import com.example.myappmarvel.databinding.ItemHeroBinding
import com.example.myappmarvel.models.Hero

interface FindByNameListener {

    fun onNotificationPressed(heroi : Hero)
    fun clickOnStarIcon(heroi: Hero, itemHero: ItemHeroBinding)

}