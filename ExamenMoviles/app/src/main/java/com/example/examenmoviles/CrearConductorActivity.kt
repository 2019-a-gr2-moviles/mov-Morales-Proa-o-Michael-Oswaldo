package com.example.examenmoviles

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.util.Log
import kotlinx.android.synthetic.main.activity_crear_conductor.*
import java.time.LocalDate

import java.util.*

class CrearConductorActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_conductor)




       btn_crear.setOnClickListener {
           CrearConductor()
       }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun CrearConductor(conductor:Conductor){

        var nombres: String
        var apellidos : String
        var fechaNacimiento :LocalDate

        nombres = edit_nombres.text.toString()
        apellidos = edit_apellidos.text.toString()
        fechaNacimiento = LocalDate.parse(date_fecha.text.toString())

         = Conductor(nombres,apellidos,fechaNacimiento,0,true)
        Log.i("conductor","el conductor es ${conductor.nombres} , ${conductor.apellidos} , ${conductor.fechaNacimiento}")
    }
    fun AñaddirCarro(auto: Auto){



    }




}
