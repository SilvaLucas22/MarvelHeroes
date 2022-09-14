package com.example.myappmarvel.favorites

import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myappmarvel.R
import com.example.myappmarvel.databinding.ActivityFavoritesBinding
import com.example.myappmarvel.databinding.ItemHeroBinding
import com.example.myappmarvel.models.Hero

class FavoritesActivity : AppCompatActivity(), FavoritesListener {

    private lateinit var binding: ActivityFavoritesBinding
    private lateinit var favoritesAdapter : FavoritesAdapter
    private var viewModel : FavoritesViewModel = FavoritesViewModel()

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        registerObservers()
        viewModel.getFavorites()

    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun setupView() {
        setupRecyclerView()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun setupRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        )

        favoritesAdapter = FavoritesAdapter(this)

        binding.favoritesRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = favoritesAdapter
        }

    }

    fun updateRecyclerView(heroList : List<Hero>){
        favoritesAdapter.submitList(heroList)
        favoritesAdapter.notifyDataSetChanged()

    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun clickOnStarIcon(heroi: Hero, itemHero: ItemHeroBinding){
        if(heroi.isFavorite){
            heroi.isFavorite = false
            itemHero.starIcon.setImageResource(R.drawable.ic_star)
        } else{
            heroi.isFavorite = true
            itemHero.starIcon.setImageResource(R.drawable.ic_star_green)
        }
        viewModel.setAsFavorite(heroi)
        viewModel.getFavorites()

    }

    override fun onNotificationPressed(heroi: Hero) {
        with(heroi){

        }
    }

    private fun registerObservers() {
        viewModel.heroesListLiveData.observe(this) {
            updateRecyclerView(it)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

}