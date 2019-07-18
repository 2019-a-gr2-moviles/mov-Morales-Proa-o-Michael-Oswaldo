package com.example.frontendindividual.dto

import java.lang.reflect.Array
import java.util.*
import kotlin.collections.ArrayList

class Mascota(
    var id: Int = 0,
    var createdAt: Long = 0,
    var updatedAt: Long = 0,
    var nombre: String = "",
    var descripcion:String="",
    var edad:String = "",
    var raza:String = "",
    var tamanio:String = "",
    var genero:String = "",
    var fkUsuario:Int = 0
) {
    var fechaCreacion: Date
    var fechaActualizacion: Date

    init {
        fechaCreacion = Date(createdAt)
        fechaActualizacion = Date(updatedAt)

    }






}