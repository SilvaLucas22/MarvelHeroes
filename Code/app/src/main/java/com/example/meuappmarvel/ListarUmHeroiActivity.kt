package com.example.meuappmarvel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListarUmHeroiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_um_heroi)

        GlobalScope.launch {
            val ListaDeHerois = ListarHerois().getHeroByName("Spider-Man")
            println(ListaDeHerois.toString())
            println("Temos " + ListaDeHerois.size + " heróis")
        }
    }
}