package com.example.meuappmarvel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ListarHeroisActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_herois)

        val ListaDeHerois = ListarHerois().getAllHeroes(0)

        println(ListaDeHerois.toString())

    }

}