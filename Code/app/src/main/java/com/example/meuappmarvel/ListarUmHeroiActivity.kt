package com.example.meuappmarvel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.meuappmarvel.consumoAPI.ListarHerois
import com.example.meuappmarvel.models.Hero
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListarUmHeroiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_um_heroi)

    }

    fun getHeroList(view: View) {
        val caixaTexto:EditText = findViewById(R.id.nameHero)
        val name = caixaTexto.text.toString()

        var saidaTexto: TextView = findViewById(R.id.exibirTexto)

        var ListaDeHerois : MutableList<Hero> = ArrayList()
        GlobalScope.launch {
            ListaDeHerois = ListarHerois().getHeroByName(name)
            //println(ListaDeHerois.toString())
            //println("Temos " + ListaDeHerois.size + " heróis")

            if(ListaDeHerois.isEmpty()){
                saidaTexto.setText("Herói não encontrado")
            } else{
                saidaTexto.setText(ListaDeHerois.toString())
            }

        }

    }

    fun addFavorito(view: View){

    }

}