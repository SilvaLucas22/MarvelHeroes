package com.example.myappmarvel.listAll

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myappmarvel.R
import com.example.myappmarvel.databinding.ActivityListAllBinding
import com.example.myappmarvel.databinding.ItemHeroBinding
import com.example.myappmarvel.models.Hero

class ListAllActivity : AppCompatActivity(), ListAllListener {

    private lateinit var binding: ActivityListAllBinding
    private lateinit var listAllAdapter : ListAllAdapter
    private var viewModel : ListAllViewModel = ListAllViewModel()

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListAllBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        registerObservers()
        viewModel.getAllHeroes()

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

        listAllAdapter = ListAllAdapter(this)

        binding.listAllRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = listAllAdapter
        }

    }

    fun updateRecyclerView(heroList : List<Hero>){
        listAllAdapter.submitList(heroList)
        listAllAdapter.notifyDataSetChanged()

    }

    override fun clickOnStarIcon(heroi: Hero, itemHero: ItemHeroBinding){
        if(heroi.isFavorite){
            heroi.isFavorite = false
            itemHero.starIcon.setImageResource(R.drawable.ic_star)
            viewModel.setAsFavorite(heroi)

        } else{
            heroi.isFavorite = true
            itemHero.starIcon.setImageResource(R.drawable.ic_star_green)
            viewModel.setAsFavorite(heroi)
        }

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