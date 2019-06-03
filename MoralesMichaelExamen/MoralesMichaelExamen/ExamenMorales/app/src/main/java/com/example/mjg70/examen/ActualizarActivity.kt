package com.example.mjg70.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_actualizar.*

class ActualizarActivity : AppCompatActivity() {
    var padreId : Int = 0
    var usuario :String = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar)
        usuario = intent.getStringExtra("usuario").toString()
        val equipoRecibida = intent.getParcelableExtra<Conductor>("Equipo")
        txtNombre.setText(equipoRecibida.nombres.toString())
        txtLiga.setText(equipoRecibida.apellidos.toString())
        txtFechaCreacion.setText(equipoRecibida.fechaNacimiento.toString())
        txtNumCopInter.setText(equipoRecibida.cantidadAutos.toString())
        txtCampeonAct.setText(equipoRecibida.licencia.toString())
        padreId = equipoRecibida.id!!;
        btnActualizar.setOnClickListener { actualizarEquipo() }
        btnEliminar.setOnClickListener { eliminarEquipo() }
        btnCrearJugador.setOnClickListener { crearJugador() }
        btnGestionarJugador.setOnClickListener { gestionarJugador() }
        btnMenuRetorno.setOnClickListener { retorno() }
    }

    fun actualizarEquipo(){
        val actualizarEquipo = Conductor(id = padreId,
            nombres = txtNombre.text.toString(),
            apellidos = txtLiga.text.toString(),
            fechaNacimiento = txtFechaCreacion.text.toString(),
            cantidadAutos = txtNumCopInter.text.toString().toInt(),
            licencia = txtCampeonAct.text.toString()
        )
        BaseConductores.actualizarEquipo(actualizarEquipo)
        Toast.makeText(this, "Actualización exitosa "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, MenuActivity::class.java)
        retorno.putExtra("usuario", usuario)
        startActivity(retorno)
    }

    fun eliminarEquipo(){
        BaseConductores.eliminarEquipo(padreId);
        Toast.makeText(this, "Eliminación exitosa "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, MenuActivity::class.java)
        retorno.putExtra("usuario", usuario)
        startActivity(retorno)
    }

    fun crearJugador(){
        val equipoRespaldo = Conductor(id = padreId,
            nombres = txtNombre.text.toString(),
            apellidos = txtLiga.text.toString(),
            fechaNacimiento = txtFechaCreacion.text.toString(),
            cantidadAutos = txtNumCopInter.text.toString().toInt(),
            licencia = txtCampeonAct.text.toString()
        )
        val retorno = Intent(this, IngresarAutoActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("padreId", padreId)
        retorno.putExtra("EquipoRespaldo", equipoRespaldo)
        startActivity(retorno)
    }

    fun gestionarJugador(){
        val equipoRespaldo = Conductor(id = padreId,
            nombres = txtNombre.text.toString(),
            apellidos = txtLiga.text.toString(),
            fechaNacimiento = txtFechaCreacion.text.toString(),
            cantidadAutos = txtNumCopInter.text.toString().toInt(),
            licencia = txtCampeonAct.text.toString()
        )
        val retorno = Intent(this, ConsultarAutosActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("padreId", padreId)
        retorno.putExtra("EquipoRespaldo", equipoRespaldo)
        startActivity(retorno)
    }

    fun retorno(){
        val retorno = Intent(this, MenuActivity::class.java)
        retorno.putExtra("usuario", usuario)
        startActivity(retorno)
    }
}
