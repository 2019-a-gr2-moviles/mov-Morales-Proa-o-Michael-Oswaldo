package com.example.mjg70.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_actualizar_auto.*

class ActualizarAutoActivity : AppCompatActivity() {
    var id :Int = 0;
    var idPadre :Int = 0
    var usuario :String = "";
    var equipoRespaldo : Conductor? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_auto)
        usuario = intent.getStringExtra("usuario").toString()
        val jugadorRecibido = intent.getParcelableExtra<Auto>("Auto")
        equipoRespaldo = intent.getParcelableExtra<Conductor>("EquipoRespaldo")
        txtnumeroCamiseta.setText(jugadorRecibido.chasis.toString())
        txtNombreCamiseta.setText(jugadorRecibido.marca.toString())
        txtNombreJugador.setText(jugadorRecibido.colorUno.toString())
        txtpoderEspecialDos.setText(jugadorRecibido.colorDos.toString())
        txtfechaIngresoEquipo.setText(jugadorRecibido.modelo.toString())
        txtGoles.setText(jugadorRecibido.anio.toString())
        id = jugadorRecibido.id.toString().toInt()
        idPadre = jugadorRecibido.idConductor.toString().toInt()
        btnActualizarJugador.setOnClickListener { actualizarJugador() }
        btnEliminarJugador.setOnClickListener { eliminarJugador() }
    }

    fun actualizarJugador(){
        val jugador = Auto(id = id,
            chasis = txtnumeroCamiseta.text.toString().toInt(),
            marca = txtNombreCamiseta.text.toString(),
            colorUno = txtNombreJugador.text.toString(),
            colorDos = txtpoderEspecialDos.text.toString(),
            modelo = txtfechaIngresoEquipo.text.toString(),
            anio = txtGoles.text.toString().toInt(),
            idConductor = idPadre)
        BaseAutos.actualizarJugador(jugador)
        Toast.makeText(this, "Actualización jugador exitosa "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, ActualizarActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("Equipo", equipoRespaldo)
        startActivity(retorno)
    }

    fun eliminarJugador(){
        BaseAutos.eliminarJugador(id)
        Toast.makeText(this, "Eliminación jugador exitosa "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, ActualizarActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("Equipo", equipoRespaldo)
        startActivity(retorno)
    }
}
