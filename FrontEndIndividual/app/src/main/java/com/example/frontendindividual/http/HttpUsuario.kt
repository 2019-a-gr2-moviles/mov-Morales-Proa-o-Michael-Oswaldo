package com.example.frontendindividual.http

import android.util.Log
import com.example.frontendindividual.dto.Usuario

class HttpUsuario(url:String, modelo:String):HttpEntity<Usuario>(url,modelo) {

    init {
        Log.i("Saludo","hola soy una Usuario con url ${url}${modelo}")
    }




}