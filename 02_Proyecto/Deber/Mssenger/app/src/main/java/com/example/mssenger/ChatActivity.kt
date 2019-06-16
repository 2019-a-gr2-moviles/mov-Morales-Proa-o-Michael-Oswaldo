package com.example.mssenger

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val mensaje:Mensaje?= this.intent.getParcelableExtra<Mensaje>("mensaje")
        Log.i("mensaje", "Mensajee ${mensaje?.autor}")
        llenarDatos(mensaje!!)


        var listachat = arrayListOf<Chat>()



        listachat.add(Chat("Este easdasdasdasdasd jhg hjg jhg hjg jhg ","este easdasdasdasdasdasdasdasd"))
        listachat.add(Chat("Este easdasdasdasdasd","este easdasdasdasdasdasdasdasd"))
        listachat.add(Chat("Este easdasdasdasdasd","este easdasdasdasdasdasdasdasd"))
        listachat.add(Chat("Este easdasdasdasdasd","este easdasdasdasdasdasdasdasd"))
        listachat.add(Chat("Este easdasdasdasdasd","este easdasdasdasdasdasdasdasd"))
        listachat.add(Chat("Este easdasdasdasdasd","este easdasdasdasdasdasdasdasd"))
        listachat.add(Chat("Este easdasdasdasdasd","este easdasdasdasdasdasdasdasd"))
        listachat.add(Chat("Este easdasdasdasdasd","este easdasdasdasdasdasdasdasd"))
        listachat.add(Chat("Este easdasdasdasdasd","este easdasdasdasdasdasdasdasd"))


        iniciarRecylerView(listachat,this,rv_chats)



    }
    fun iniciarRecylerView(
        lista: List<Chat>,
        actividad: ChatActivity,
        recycler_view: RecyclerView
    ) {
        val adaptadorchat = AdaptadorChat(
            lista,
            actividad,
            recycler_view
        )
        recycler_view.adapter = adaptadorchat
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.layoutManager = LinearLayoutManager(actividad)

        adaptadorchat.notifyDataSetChanged()
    }


    fun llenarDatos(mensaje:Mensaje){


        when(mensaje.id_usuario){
                1 -> { img_profile_image.setImageResource(R.drawable.a1) }
            2 -> { img_profile_image.setImageResource(R.drawable.a2) }
            3 -> { img_profile_image.setImageResource(R.drawable.a3) }
            4 -> { img_profile_image.setImageResource(R.drawable.a4) }
            5 -> { img_profile_image.setImageResource(R.drawable.a5) }
            6 -> { img_profile_image.setImageResource(R.drawable.a6) }
            7 -> { img_profile_image.setImageResource(R.drawable.a7) }
            8 -> { img_profile_image.setImageResource(R.drawable.a8) }
            9 -> { img_profile_image.setImageResource(R.drawable.a9) }
            10 -> { img_profile_image.setImageResource(R.drawable.a10) }
            else ->{img_profile_image.setImageResource(R.drawable.a1)}
            }
        txt_mensaje.text = "Active 1h ago"
        txt_nombre_usuario_chat.text = mensaje.autor




        }

    }



