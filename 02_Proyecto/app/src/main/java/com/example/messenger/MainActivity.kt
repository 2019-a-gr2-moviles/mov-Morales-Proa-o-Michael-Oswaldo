package com.example.messenger

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var listaMensajes = arrayListOf<Mensaje>()

        listaMensajes.add(Mensaje("Michael","You: hola","8:30 am",1))
        listaMensajes.add(Mensaje("Jose","You: hola mijo","8:30 am",2))
        listaMensajes.add(Mensaje("Pedro","You: hola mijo","8:30 am",3))
        listaMensajes.add(Mensaje("Juanito","You: hola mijo","8:30 am",4))
        listaMensajes.add(Mensaje("Pepe","You: hola mijo","8:30 am",5))
        listaMensajes.add(Mensaje("Limon","You: hola mijo","8:30 am",6))
        listaMensajes.add(Mensaje("Anita","You: hola mijo","8:30 am",7))
        listaMensajes.add(Mensaje("Jhon","You: hola mijo","8:30 am",8))
        listaMensajes.add(Mensaje("Ernesto","You: hola mijo","8:30 am",9))
        listaMensajes.add(Mensaje("Jeff","You: hola mijo","8:30 am",10))
0

        iniciarRecylerView(listaMensajes,this,recycler_view_mensajes)


    }



    fun iniciarRecylerView(
        lista: List<Mensaje>,
        actividad: MainActivity,
        recycler_view: RecyclerView
    ) {
        val adaptadorMensaje = AdaptadorMensaje(
            lista,
            actividad,
            recycler_view
        )
        recycler_view.adapter = adaptadorMensaje
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.layoutManager = LinearLayoutManager(actividad)

        adaptadorMensaje.notifyDataSetChanged()
    }









}
