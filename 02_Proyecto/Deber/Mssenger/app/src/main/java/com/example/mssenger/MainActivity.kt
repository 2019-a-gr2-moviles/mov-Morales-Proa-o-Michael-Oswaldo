package com.example.mssenger

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

        listaMensajes.add(Mensaje("Michael","You: no papu","8:30 am",1))
        listaMensajes.add(Mensaje("Joselyn","You: Eres la unica amor","8:30 am",2))
        listaMensajes.add(Mensaje("Amanda","You: solo te quiero a ti bebe","8:30 am",9))
        listaMensajes.add(Mensaje("Juanita","You: hola bonita","8:30 am",4))
        listaMensajes.add(Mensaje("Maria","You: Eres la unica","8:31 am",5))
        listaMensajes.add(Mensaje("Lima","You: que mas linda","9:30 am",6))
        listaMensajes.add(Mensaje("Anita","You: hola","8:30 am",7))
        listaMensajes.add(Mensaje("Jhoana","You: Eres la unica","10:30 am",8))
        listaMensajes.add(Mensaje("Ery","You: Eres la unica","8:30 am",3))
        listaMensajes.add(Mensaje("Steffi","You: Eres la unica","10:30 am",10))
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
