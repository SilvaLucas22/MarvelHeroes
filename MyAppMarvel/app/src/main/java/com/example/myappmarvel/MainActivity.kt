package com.example.myappmarvel

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TimingLogger
import androidx.annotation.RequiresApi
import androidx.room.Room
import com.example.myappmarvel.database.AppDatabase
import com.example.myappmarvel.database.ListHeroRepository
import com.example.myappmarvel.databinding.ActivityMainBinding
import com.example.myappmarvel.favorites.FavoritesActivity
import com.example.myappmarvel.findByName.FindByNameActivity
import com.example.myappmarvel.listAll.ListAllActivity
import com.example.myappmarvel.models.Hero

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    init {
        instance = this
    }

    companion object {
        private lateinit var instance: MainActivity

        fun applicationContext() : Context {
            return instance.applicationContext
        }
    }


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()

        val listHeroRepository = ListHeroRepository()
        listHeroRepository.insertAllHeroes()

    }

    fun setupView(){

        binding.ListAllButton.setOnClickListener{
            val intent = Intent(this, ListAllActivity::class.java)
            startActivity(intent)
        }

        binding.FindByNameButton.setOnClickListener{
            val intent = Intent(this, FindByNameActivity::class.java)
            startActivity(intent)
        }

        binding.FavoritesButton.setOnClickListener{
            val intent = Intent(this, FavoritesActivity::class.java)
            startActivity(intent)
        }

    }

}