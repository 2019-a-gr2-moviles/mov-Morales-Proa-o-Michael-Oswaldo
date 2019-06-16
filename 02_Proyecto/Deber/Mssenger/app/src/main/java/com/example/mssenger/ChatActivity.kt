package com.example.mssenger

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val mensaje:Mensaje?= this.intent.getParcelableExtra<Mensaje>("mensaje")
        Log.i("mensaje", "Mensajee ${mensaje?.autor}")
    }







}
