package com.example.myapplication4

import android.util.Log
import com.beust.klaxon.Klaxon

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import kotlinx.coroutines.runBlocking
import java.util.*

open class HttpEntity<Entity>(var url:String,var modelo:String ) {
    fun get(id:Int):String{
        var url = "${this.url}${this.modelo}/${id}";
        var returned = ""
            url.httpGet().responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        returned = "${ex}"
                    }
                    is Result.Success -> {
                        val data = result.get()
                        Log.i("LA DATA DE LA ","LA DATA DE LA SOLI ES ${data}")
                        returned = data
                        Log.i("retiunr","RETURN INSIDE IS ${returned}")
                    }
                }

            }
        Thread.sleep(1500)
        Log.i("RETORNADOOOOOO","EEEEES RETORNADOOO despues de 2 segundo ses :${returned}")
        return returned
    }
}