package com.example.myapplication4

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_parcelable.*
import kotlinx.android.synthetic.main.content_main.*

class Parcelable : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable)

        val michael:Usuario?= this.intent.getParcelableExtra<Usuario>("usuario")
        val cachetes:Mascota?= this.intent.getParcelableExtra<Mascota>("mascota")
        Log.i("parcelable", "Nombre ${michael?.nombre}")
        Log.i("parcelable", "Mascota ${cachetes?.nombre}")
        Log.i("parcelable", "Mascota ${cachetes?.duenio?.nombre}")
        btn_regresar_menu.setOnClickListener {
            regresarAMenu()
        }
    }

    fun regresarAMenu(){

        val intentExplicito = Intent(

            this, MainActivity::class.java
        )
        startActivity(intentExplicito)

    }

}
