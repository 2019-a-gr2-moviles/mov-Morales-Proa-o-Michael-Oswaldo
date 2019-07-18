package com.example.myapplication4

import android.util.Log

class HttpEmpresa(url:String, modelo:String):HttpEntity<Empresa>(url,modelo) {

   init {
       Log.i("Saludo","hola soy una Empresa con url ${url}${modelo}")
   }




}