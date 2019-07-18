package com.example.frontendindividual.dto

import java.util.*
import kotlin.collections.ArrayList

class Usuario(
    var id: Int,
    var createdAt: Long,
    var updatedAt: Long,
    var nombre: String,
    var apellido:String,
    var cedula:String,
    var fechaDeNacimiento:String,
    var perfil:String,
    var contrasenia:String,
    var mascotasDeUsuario:ArrayList<Mascota>,
    var rolesDeUsuario:ArrayList<RolUsuario>
) {
    var fechaCreacion: Date
    var fechaActualizacion: Date

    init {
        fechaCreacion = Date(createdAt)
        fechaActualizacion = Date(updatedAt)
    }


}