package com.example.myapplication4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication4.AdaptadorPersona
import kotlinx.android.synthetic.main.activity_recycle_view.*
import kotlinx.android.synthetic.main.activity_recycle_view.view.*

class ReciclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)

        var lista = arrayListOf<Persona>()
     //   val recycler_view = rv_personas
       // val actividad = this

        lista.add(Persona("Michael","1724196983"))
        lista.add(Persona("Morales","17241963483"))
        lista.add(Persona("Jose","17344196983"))


     iniciarRecylerView(lista, this, rv_personas)

    }
    fun iniciarRecylerView(
        lista: List<Persona>,
        actividad: ReciclerViewActivity,
        recycler_view: androidx.recyclerview.widget.RecyclerView
    ) {
        val adaptadorPersona = AdaptadorPersona(
            lista,
            actividad,
            recycler_view
        )
        recycler_view.adapter = adaptadorPersona
        recycler_view.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        recycler_view.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(actividad)

        adaptadorPersona.notifyDataSetChanged()
    }




    fun cambiarNombreTextView(texto: String){

        txt_titulo_rv.text = texto

    }



}
