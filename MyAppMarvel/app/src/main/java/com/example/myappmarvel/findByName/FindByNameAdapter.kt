package com.example.myappmarvel.findByName

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.myappmarvel.databinding.ItemHeroBinding
import com.example.myappmarvel.models.Hero

class FindByNameAdapter(
    private val listener : FindByNameListener
    ) : ListAdapter<Hero, FindByNameViewHolder>(FindByNameAdapter) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FindByNameViewHolder {
        val binding = ItemHeroBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return FindByNameViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FindByNameViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    private companion object : DiffUtil.ItemCallback<Hero>() {
        override fun areItemsTheSame(oldItem: Hero, newItem: Hero): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areContentsTheSame(oldItem: Hero, newItem: Hero): Boolean {
            return oldItem.equals(newItem)
        }
    }

}