package com.example.meuappmarvel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meuappmarvel.consumoAPI.ListarHerois
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListarHeroisActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_herois)

        GlobalScope.launch {
            val ListaDeHerois = ListarHerois().getAllHeroes()
            println(ListaDeHerois.toString())
            println("Temos " + ListaDeHerois.size + " heróis")
            //Funcionamento falha às vezes
        }


    }

}