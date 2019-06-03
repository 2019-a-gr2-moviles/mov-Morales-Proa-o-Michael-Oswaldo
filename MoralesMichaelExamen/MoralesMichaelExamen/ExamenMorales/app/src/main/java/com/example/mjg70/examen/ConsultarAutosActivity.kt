package com.example.mjg70.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_consultar_auto.*

class ConsultarAutosActivity : AppCompatActivity() {
    var padreId : Int = 0
    var usuario :String = "";
    var equipoRespaldo : Conductor? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        usuario = intent.getStringExtra("usuario").toString()
        equipoRespaldo = intent.getParcelableExtra<Conductor>("EquipoRespaldo")
        padreId = intent.getIntExtra("padreId", -1)
        setContentView(R.layout.activity_consultar_auto)
        val adapter = ArrayAdapter<Auto>(
            this,
            android.R.layout.simple_list_item_1,
            BaseAutos.mostrarJugador(padreId)
        )
        lstJugador.adapter = adapter;
        lstJugador.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            val jugadorSeleccionado = parent.getItemAtPosition(position) as Auto
            val intentJugadorSeleccionado = Intent(this, ActualizarAutoActivity::class.java)
            intentJugadorSeleccionado.putExtra("usuario", usuario)
            intentJugadorSeleccionado.putExtra("Auto", jugadorSeleccionado)
            intentJugadorSeleccionado.putExtra("EquipoRespaldo", equipoRespaldo)
            startActivity(intentJugadorSeleccionado)
        }
    }
}
