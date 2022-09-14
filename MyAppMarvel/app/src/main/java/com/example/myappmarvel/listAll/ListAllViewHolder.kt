package com.example.myappmarvel.listAll

import androidx.recyclerview.widget.RecyclerView
import com.example.myappmarvel.R
import com.example.myappmarvel.databinding.ItemHeroBinding
import com.example.myappmarvel.models.Hero

class ListAllViewHolder (
    private val binding : ItemHeroBinding
        ) : RecyclerView.ViewHolder(binding.root) {

    fun bind(hero: Hero, listener: ListAllListener) {

        with(binding) {
            val textoID = "ID: " + hero.id.toString()

            nameHero.text = hero.name
            idHero.text = textoID
            if(hero.isFavorite){
                starIcon.setImageResource(R.drawable.ic_star_green)
            } else{
                starIcon.setImageResource(R.drawable.ic_star)
            }

            nameHero.setOnClickListener { listener.onNotificationPressed(hero) }
            idHero.setOnClickListener { listener.onNotificationPressed(hero) }
            starIcon.setOnClickListener { listener.clickOnStarIcon(hero, this) }
        }

    }

}