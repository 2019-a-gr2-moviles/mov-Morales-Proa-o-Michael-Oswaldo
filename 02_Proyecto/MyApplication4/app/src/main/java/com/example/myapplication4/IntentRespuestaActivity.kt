package com.example.myapplication4

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent_respuesta.*

class IntentRespuestaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_respuesta)


        btn_enviar_respuesta.setOnClickListener {
            enviarIntentConRespuesta()
        }
    }

    fun enviarIntentConRespuesta(){
        val intentConRespuesta = Intent(
            Intent.ACTION_PICK,
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI

        )
        this.startActivityForResult(intentConRespuesta,304)



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(resultCode){

            RESULT_OK ->{
                when(requestCode){

                    304 ->{


                        val uri = data?.data
                        var cursor = contentResolver.query(uri,null,null,null,null)
                        cursor?.moveToFirst()
                        val indiceTelefono = cursor?.getColumnIndex(

                           ContactsContract.CommonDataKinds.Phone.NUMBER
                        )

                        val telefono = cursor?.getString(indiceTelefono!!)
                        cursor?.close()

                        Log.i("respuesta","Lo logramos mijo!!!")
                    }
                    305 ->{

                        val nombre = data?.getStringExtra("nombreUsuario")
                        val edad = data?.getIntExtra("edadUsuario", 0)
                        Log.i("resp:","Nombre: $nombre Edad $edad")


                    }

                }

            }
            Activity.RESULT_CANCELED ->{

                Log.i("respuesta","No escojio nada el mijin!!!")

            }
        }
    }


}
