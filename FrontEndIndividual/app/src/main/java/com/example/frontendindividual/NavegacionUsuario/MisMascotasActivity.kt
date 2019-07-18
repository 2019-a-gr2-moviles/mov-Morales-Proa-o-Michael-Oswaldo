package com.example.frontendindividual.NavegacionUsuario

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.beust.klaxon.Klaxon
import com.example.frontendindividual.Adapters.AdaptadorMisMascotas
import com.example.frontendindividual.Adapters.AdaptadorTodasMascotas
import com.example.frontendindividual.MainActivity
import com.example.frontendindividual.R
import com.example.frontendindividual.dto.Mascota
import com.example.frontendindividual.http.GlobalsVariables
import com.example.frontendindividual.http.HttpMascota
import kotlinx.android.synthetic.main.activity_mis_mascotas.*
import kotlinx.android.synthetic.main.activity_todas_mascotas.*

class MisMascotasActivity : AppCompatActivity() {
    var globals = GlobalsVariables
    var url = globals.url
    var mascotasPublicas:List<Mascota>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mis_mascotas)
        crear()
    }
    fun crear(){
        var main = MainActivity

        var mascotaHttp: HttpMascota = HttpMascota(url,"Mascota")
        var response = mascotaHttp.getByQuery("populate=false&fkUsuario=${main.currentUser!!.id}")
        Log.i("login","las mascotas son  ${response}")
        if(response == "[]"){
            Log.i("ERROR","ERRORRRR")
            Toast.makeText(this, "No existen Mascotas", Toast.LENGTH_SHORT).show()
        }
        else{
            var publicaiones:List<Mascota>? = jsonParse(response)

            if (publicaiones != null){
                mascotasPublicas = publicaiones
                Log.i("Pubs","PUBLICACIONES SON ${mascotasPublicas}")
                iniciarRecylerView(mascotasPublicas!!,this,recycler_mis_mascotas)

            }
            else{
                Log.i("Error Parse","errorP Parseee Mascotas!!!")
            }
        }

    }


    fun jsonParse(data:String): List<Mascota>?{
        try{
            val publicacionesParseado = Klaxon()
                .parseArray<Mascota>(data)

            return publicacionesParseado

        }
        catch(err: Exception){
            Log.i("Exception","Exception")

        }

        return null
    }

    fun iniciarRecylerView(
        lista: List<Mascota>,
        actividad: MisMascotasActivity,
        recycler_view: RecyclerView
    ) {
        val adaptadorPublicacion = AdaptadorMisMascotas(
            lista,
            actividad,
            recycler_view
        )
        recycler_view.adapter = adaptadorPublicacion
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.layoutManager = LinearLayoutManager(actividad)

        adaptadorPublicacion.notifyDataSetChanged()
    }

    fun cancelar(id:Int){
        Log.i("ad","SE VA A cancelar A LA MASCOTA ${id}")
        var mascotaHttp: HttpMascota = HttpMascota(url,"Mascota")
        var parametrosInmuebleAEnviar = listOf(
            "fkUsuario" to "1" )
        try{
            mascotaHttp.patch(parametrosInmuebleAEnviar,id)


            Thread.sleep(1000)
            Toast.makeText(this, "Adopcion Cancelada Exitosamente", Toast.LENGTH_SHORT).show()
            crear()
        }
        catch(e:Exception){
            Toast.makeText(this, "Error Al Publicar", Toast.LENGTH_SHORT).show()

        }
    }



}