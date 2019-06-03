package com.example.mjg70.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ingresar_auto.*

class IngresarAutoActivity : AppCompatActivity() {
    var padreId : Int = 0
    var usuario :String = "";
    var equipoRespaldo : Conductor? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_auto)
        usuario = intent.getStringExtra("usuario").toString()
        equipoRespaldo = intent.getParcelableExtra<Conductor>("EquipoRespaldo")
        padreId = intent.getIntExtra("padreId", -1)
        btnGuardar.setOnClickListener { guardarJugador() }
    }

    fun guardarJugador(){
        val jugador = Auto(id = null,
            chasis = txtnumeroCamiseta.text.toString().toInt(),
            marca = txtNombreCamiseta.text.toString(),
            colorUno = txtNombreJugador.text.toString(),
            colorDos = txtpoderEspecialDos.text.toString(),
            modelo = txtfechaIngresoEquipo.text.toString(),
            anio = txtGoles.text.toString().toInt(),
            idConductor = padreId)
        BaseAutos.agregarJugador(jugador)
        Toast.makeText(this, "Auto creado exitosamente "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, ActualizarActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("Equipo", equipoRespaldo)
        startActivity(retorno)
    }
}
