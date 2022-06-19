package com.example.meuappmarvel

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Usei "view: View" pois não consegui importar o kotlinx.android.synthetic...

    }

    fun listarHerois(view: View){
        val intent = Intent(this, ListarHeroisActivity::class.java)
        startActivity(intent)

    }

    fun listarUmHeroi(view: View){
        val intent = Intent(this, ListarUmHeroiActivity::class.java)
        startActivity(intent)

    }

    fun meusFavoritos(view: View){
        val intent = Intent(this, MeusFavoritosActivity::class.java)
        startActivity(intent)

    }

}