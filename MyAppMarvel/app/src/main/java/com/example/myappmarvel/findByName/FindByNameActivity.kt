package com.example.myappmarvel.findByName

import android.os.Build
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.view.MenuItem
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myappmarvel.R
import com.example.myappmarvel.database.ListHeroRepository
import com.example.myappmarvel.databinding.ActivityFindByNameBinding
import com.example.myappmarvel.databinding.ItemHeroBinding
import com.example.myappmarvel.models.Hero

class FindByNameActivity : AppCompatActivity(), FindByNameListener {

    private lateinit var binding: ActivityFindByNameBinding
    private lateinit var findByNameAdapter : FindByNameAdapter
    private var viewModel : FindByNameViewModel = FindByNameViewModel()

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFindByNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        registerObservers()

    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun setupView() {
        setupRecyclerView()

        with(binding){
            botaoBuscar.setOnClickListener{
                viewModel.getHeroByName(textinput.text.toString())
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun setupRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        )

        findByNameAdapter = FindByNameAdapter(this)

        binding.findByNameRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = findByNameAdapter
        }

    }

    fun updateRecyclerView(heroList : List<Hero>){
        findByNameAdapter.submitList(heroList)
        findByNameAdapter.notifyDataSetChanged()

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