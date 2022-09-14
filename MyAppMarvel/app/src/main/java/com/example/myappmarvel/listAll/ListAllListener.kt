package com.example.myappmarvel.listAll

import com.example.myappmarvel.databinding.ItemHeroBinding
import com.example.myappmarvel.models.Hero

interface ListAllListener {

    fun onNotificationPressed(heroi : Hero)
    fun clickOnStarIcon(heroi: Hero, itemHero: ItemHeroBinding)

}