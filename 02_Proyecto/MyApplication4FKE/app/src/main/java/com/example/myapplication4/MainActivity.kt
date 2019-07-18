package com.example.myapplication4

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    btn_http.setOnClickListener {
    irAIntentHttp() }

        btn_parcelable.setOnClickListener {
            irAParcelable() }
        btn_adapter.setOnClickListener {
            irAListaView() }

        btn_recyclerView.setOnClickListener {
            irARecycleView()
        }
        btn_intent_respuesta.setOnClickListener {
            irAIntentRespuesta()
        }


    }
    fun irAListaView(){

        val intentExplicito = Intent(

            this, ListViewActivity::class.java
        )

        startActivity(intentExplicito)


    }
    fun irAIntentRespuesta(){

        val intentExplicito = Intent(

            this, IntentRespuestaActivity::class.java
        )

        startActivity(intentExplicito)


    }
    fun irAIntentHttp(){
        val intentExplicito = Intent(

            this, ConexionHttpActivity::class.java
        )
        startActivity(intentExplicito)



    }
    fun irAMapsActivity(){
        val intentExplicito = Intent(

            this, MapsActivity::class.java
        )
        startActivity(intentExplicito)


    }







    fun irAParcelable(){


val intentExplicito = Intent(

    this, Parcelable::class.java
)
        val michael = Usuario("Michael",29, Date(),12.2)
        intentExplicito.putExtra("usuario",michael)
        val cachetes = Mascota("cachetes",michael)
        intentExplicito.putExtra("mascota",cachetes)
        startActivity(intentExplicito)
    }



fun irARecycleView(){
    val intentExplicito = Intent(

        this, ReciclerViewActivity::class.java
    )

    startActivity(intentExplicito)



}


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}