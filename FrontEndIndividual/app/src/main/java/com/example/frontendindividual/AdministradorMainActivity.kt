package com.example.frontendindividual

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.beust.klaxon.Klaxon
import com.example.frontendindividual.dto.LastModel
import com.example.frontendindividual.http.GlobalsVariables
import com.example.frontendindividual.http.HttpMascota
import kotlinx.android.synthetic.main.activity_administrador_main.*

class AdministradorMainActivity : AppCompatActivity() {
    var globals = GlobalsVariables
    var url = globals.url


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_administrador_main)


        btn_crear.setOnClickListener {
            crear()
        }
    }
    fun crear(){
        var instanceForComanionObject = MainActivity
        var currentUser = instanceForComanionObject.currentUser
        var fkUsuario = currentUser?.id
        var mascotaHttp: HttpMascota = HttpMascota(url,"Mascota")
        var response = mascotaHttp.getByQuery("populate=false&sort=id%20DESC")

        if(response == "[]"){
            Log.i("ERROR","No lasT Publications")
        }
        else{
            var lastModel: LastModel? = jsonParse(response)

            if (lastModel != null){
                Log.i("Pubs","Ultima Publicacion es ${lastModel.id}")


                var parametrosPublicacionAEnviar = listOf(
                    "id" to lastModel.id + 1,
                    "nombre" to edit_nombre.text.toString(),
                    "edad" to edit_edad.text.toString(),
                    "descripcion" to edit_descripcion.text.toString(),
                    "raza" to edit_raza.text.toString(),
                    "tamanio" to edit_tamanio.text.toString(),
                    "genero" to edit_genero.text.toString(),
                    "fkUsuario" to 1
                )

                try{
                    mascotaHttp.post(parametrosPublicacionAEnviar)
                    Toast.makeText(this, "Mascota Creada Exitosamente", Toast.LENGTH_SHORT).show()
                    Thread.sleep(1500)
                    vaciar()
                }
                catch(e:Exception){
                    Toast.makeText(this, "Error Al Publicar", Toast.LENGTH_SHORT).show()

                }
                Thread.sleep(1000)

            }
            else{
                Log.i("Error Parse","error Parse de la ultima Publicacion!!!")
            }
        }
    }


    fun jsonParse(data:String): LastModel?{
        try{
            val usuarioParseado = Klaxon()
                .parseArray<LastModel>(data)

            return usuarioParseado?.component1()

        }
        catch(err: Exception){
            Log.i("Exception","Exception")

        }

        return null
    }

    fun vaciar(){

        edit_nombre.setText("")
        edit_edad.setText("")
        edit_descripcion.setText("")
        edit_genero.setText("")
        edit_tamanio.setText("")
        edit_raza.setText("")
    }


}
