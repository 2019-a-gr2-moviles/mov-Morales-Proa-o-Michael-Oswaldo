package com.example.frontendindividual.NavegacionUsuario

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.frontendindividual.BuscarMascotaActivity
import com.example.frontendindividual.R
import kotlinx.android.synthetic.main.activity_usuario_main.*

class UsuarioMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario_main)

        btn_todas_mascotas.setOnClickListener {
            irATodasMascotasActivity()
        }
        btn_mis_mascotas.setOnClickListener {
            irAMisMascotasActivity()
        }
        btn_buscar.setOnClickListener {
            irABuscarMascotasActivity()
        }
    }

    fun irATodasMascotasActivity(){

        val intentExplicito = Intent(
            this,
            TodasMascotasActivity::class.java
        )

        startActivity(intentExplicito)


    }
    fun irAMisMascotasActivity(){

        val intentExplicito = Intent(
            this,
            MisMascotasActivity::class.java
        )

        startActivity(intentExplicito)


    }
    fun irABuscarMascotasActivity(){

        val intentExplicito = Intent(
            this,
            BuscarMascotaActivity::class.java
        )

        startActivity(intentExplicito)


    }
}
