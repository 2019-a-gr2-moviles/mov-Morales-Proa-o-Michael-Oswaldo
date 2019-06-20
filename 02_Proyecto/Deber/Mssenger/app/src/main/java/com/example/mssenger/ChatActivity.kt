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



        listachat.add(Chat("I've added some instructions. ","Here's a link to the post, which is on Edmodo, but I've made it public so you should be able to see it:"))
        listachat.add(Chat("I've got a copy of the original CD, and would like to see the British Council put the whole thing on the internet. ","There were 32 tracks originally and I think it would be a useful pronunciation resource."))
        listachat.add(Chat("On http://www.speakenglish.co.uk/phrases/travelling_by_air you have to click on the sentences to hear them, but at ","http://www.languageguide.org/english/vocabulary/travel/ you only have to move your mouse over the pictures "))
        listachat.add(Chat("and here http://www.fonetiks.org/engsou6.html moving your mouse over the phrases plays the audio. I'd like the last style, but would still be happy with the first!","Great resources! Thanks a lot. "))
        listachat.add(Chat("Would like to share an idea on using the dialogues ","in the classroom but the link doesn't seem to appear on the page. "))
        listachat.add(Chat("Thank you so much you saved my life.","Now I have resources for Teaching Listening. "))
        listachat.add(Chat("These audio files are copyright British Council.","You may download the files for your own personal or classroom use only. They may not be copied, "))
        listachat.add(Chat("distributed or made available ","to other websites. "))
        listachat.add(Chat("For any questions relating to the use of these programmes please email: teachingenglish@britishcouncil.org","file sizes for audio may be very large and can take a time to download depending on your connection speed. "))
        listachat.add(Chat("I've added some instructions. ","Here's a link to the post, which is on Edmodo, but I've made it public so you should be able to see it:"))
        listachat.add(Chat("I've got a copy of the original CD, and would like to see the British Council put the whole thing on the internet. ","There were 32 tracks originally and I think it would be a useful pronunciation resource."))
        listachat.add(Chat("On http://www.speakenglish.co.uk/phrases/travelling_by_air you have to click on the sentences to hear them, but at ","http://www.languageguide.org/english/vocabulary/travel/ you only have to move your mouse over the pictures "))
        listachat.add(Chat("and here http://www.fonetiks.org/engsou6.html moving your mouse over the phrases plays the audio. I'd like the last style, but would still be happy with the first!","Great resources! Thanks a lot. "))
        listachat.add(Chat("Would like to share an idea on using the dialogues ","in the classroom but the link doesn't seem to appear on the page. "))
        listachat.add(Chat("Thank you so much you saved my life.","Now I have resources for Teaching Listening. "))
        listachat.add(Chat("These audio files are copyright British Council.","You may download the files for your own personal or classroom use only. They may not be copied, "))
        listachat.add(Chat("distributed or made available ","to other websites. "))
        listachat.add(Chat("For any questions relating to the use of these programmes please email: teachingenglish@britishcouncil.org","file sizes for audio may be very large and can take a time to download depending on your connection speed. "))


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



