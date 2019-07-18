package com.example.frontendindividual.http

import android.util.Log
import com.github.kittinunf.fuel.core.Parameters
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result

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
                    returned = data
                }
            }

        }
        Thread.sleep(1500)
        Log.i("RETORNADOOOOOO","EEEEES RETORNADOOO despues de 2 segundo ses :${returned}")
        return returned
    }
    fun getPopulated(id:Int,toPopulate:String):String{
        var url = "${this.url}${this.modelo}/${id}?populate=${toPopulate}";
        var returned = ""
        url.httpGet().responseString { request, response, result ->
            when (result) {
                is Result.Failure -> {
                    val ex = result.getException()
                    returned = "${ex}"
                }
                is Result.Success -> {
                    val data = result.get()
                    returned = data
                }
            }

        }
        Thread.sleep(1500)
        Log.i("RETORNADOOOOOO","EEEEES RETORNADOOO despues de 2 segundo ses :${returned}")
        return returned
    }

    fun getByQuery(query:String):String{
        var url = "${this.url}${this.modelo}?${query}";
        var returned = ""
        url.httpGet().responseString { request, response, result ->
            when (result) {
                is Result.Failure -> {
                    val ex = result.getException()
                    returned = "${ex}"
                }
                is Result.Success -> {
                    val data = result.get()
                    returned = data
                }
            }

        }
        Thread.sleep(1500)
        Log.i("RETORNADOOOOOO","EEEEES RETORNADOOO despues de 2 segundo ses :${returned}")
        return returned
    }

    fun post(parametros: Parameters){
        var url = "${this.url}${this.modelo}";
        url.httpPost(parametros).responseString { request,response,result->
            when (result) {
                is Result.Failure -> {
                    val ex = result.getException()
                }
                is Result.Success -> {
                    val data = result.get()
                    Log.i("LA DATA DE LA ","Respuesta de pOSt es ${data}")

                }
            }

        }

    }
    fun patch(parametros: Parameters,id:Int){
        var url = "${this.url}${this.modelo}/${id}";
        Log.i("se va","SE VA A PATCHEAR ${url}")
        url.httpPut(parametros).responseString { request,response,result->
            when (result) {
                is Result.Failure -> {
                    val ex = result.getException()
                }
                is Result.Success -> {
                    val data = result.get()
                    Log.i("LA DATA DE LA ","Respuesta de patch es ${data}")


                }
            }

        }
    }

    fun delete(id:Int){
        var url = "${this.url}${this.modelo}/${id}";
        url.httpDelete().responseString { request,response,result->
            when (result) {
                is Result.Failure -> {
                    val ex = result.getException()
                }
                is Result.Success -> {
                    val data = result.get()
                    Log.i("LA DATA DE LA ","Respuesta de Delete es ${data}")

                }
            }

        }

    }
}