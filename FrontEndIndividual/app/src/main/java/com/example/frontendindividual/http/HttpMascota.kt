package com.example.frontendindividual.http

import android.util.Log
import com.example.frontendindividual.dto.Mascota

class HttpMascota (url:String, modelo:String):HttpEntity<Mascota>(url,modelo) {

    init {
        Log.i("Saludo","hola soy una Empresa con url ${url}${modelo}")
    }




}