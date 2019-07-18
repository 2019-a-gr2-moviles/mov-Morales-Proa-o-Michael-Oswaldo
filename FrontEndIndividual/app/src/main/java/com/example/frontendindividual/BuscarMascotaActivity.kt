package com.example.frontendindividual

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.beust.klaxon.Klaxon
import com.example.frontendindividual.Adapters.AdaptadorTodasMascotas
import com.example.frontendindividual.Adapters.AdaptadorVozPublicacion
import com.example.frontendindividual.NavegacionUsuario.TodasMascotasActivity
import com.example.frontendindividual.dto.Mascota
import com.example.frontendindividual.http.GlobalsVariables
import com.example.frontendindividual.http.HttpMascota
import kotlinx.android.synthetic.main.activity_buscar_mascota.*
import java.util.*

class BuscarMascotaActivity : AppCompatActivity() {
    var globals = GlobalsVariables
    var url = globals.url
    var mascotasPublicas:List<Mascota>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar_mascota)
        voiceBtn.setOnClickListener {
            speak()


        }
    }

    private fun speak(){
        val mIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        mIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        mIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        mIntent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Hola, diga algo")
        try{
            startActivityForResult(mIntent,100)
        }
        catch(e: Exception){
            Toast.makeText(this,"\n" +
                    "Su dispositivo no es compatible con la entrada de voz", Toast.LENGTH_SHORT ).show()

        }


    }
    override fun onActivityResult(requestCode:Int, resultCode:Int, data: Intent?){
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode){
            100 -> if (resultCode == Activity.RESULT_OK && data !=null){
                val result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                textTv.text = result[0]
                consultar()


            }
        }
    }

    fun consultar(){
        if(textTv.text.toString()!=""){
            var mascotaHttp: HttpMascota = HttpMascota(url,"Mascota")
            var response = mascotaHttp.getByQuery("populate=false&where={\"descripcion\":{\"contains\":\"${textTv.text.toString().toLowerCase()}\"},\"fkUsuario\":\"1\"}")
            Log.i("login","las publicaciones son  ${response}")
            if(response == "[]"){
                Log.i("ERROR","ERRORRRR")
                Toast.makeText(this, "No existen Publicaciones", Toast.LENGTH_SHORT).show()

            }
            else{
                var publicaiones:List<Mascota>? = jsonParse(response)

                if (publicaiones != null){
                    mascotasPublicas = publicaiones
                    Log.i("Pubs","PUBLICACIONES SON ${mascotasPublicas}")
                    iniciarRecylerView(mascotasPublicas!!,this,reciclerView_busqueda)

                }
                else{
                    Log.i("Error Parse","errorP Parseee Publicaciones!!!")
                }
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
        actividad: BuscarMascotaActivity,
        recycler_view: RecyclerView
    ) {
        val adaptadorPublicacion = AdaptadorVozPublicacion(
            lista,
            actividad,
            recycler_view
        )
        recycler_view.adapter = adaptadorPublicacion
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.layoutManager = LinearLayoutManager(actividad)

        adaptadorPublicacion.notifyDataSetChanged()
    }

    fun adoptar(id:Int){
        var main = MainActivity

        Log.i("ad","SE VA A ADOPTAR A LA MASCOTA ${id}")
        var mascotaHttp: HttpMascota = HttpMascota(url,"Mascota")
        var parametrosInmuebleAEnviar = listOf(
            "fkUsuario" to main.currentUser!!.id )
        try{
            mascotaHttp.patch(parametrosInmuebleAEnviar,id)

            Toast.makeText(this, "Adopcion Registrada Exitosamente", Toast.LENGTH_SHORT).show()
            Thread.sleep(1000)
            consultar()
        }
        catch(e:Exception){
            Toast.makeText(this, "Error Al Publicar", Toast.LENGTH_SHORT).show()

        }
    }

}