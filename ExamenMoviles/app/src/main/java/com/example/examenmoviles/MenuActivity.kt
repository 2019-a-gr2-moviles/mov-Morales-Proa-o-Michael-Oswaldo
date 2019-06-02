package com.example.examenmoviles

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.content_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        setSupportActionBar(toolbar)

        btn_g_conductor.setOnClickListener {
            irAGestionarConductor()
        }
        btn_crear_conductor.setOnClickListener {
            irACrearConductor()
        }




    }





    fun irACrearConductor(){
        val intentExplicito = Intent(

            this, CrearConductorActivity::class.java
        )
        startActivity(intentExplicito)
    }

    fun irAGestionarConductor(){
        val intentExplicito = Intent(

            this, GestionarConductorActivity::class.java
        )
        startActivity(intentExplicito)
    }
}
