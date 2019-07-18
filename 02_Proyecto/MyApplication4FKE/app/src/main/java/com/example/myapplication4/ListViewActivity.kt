package com.example.myapplication4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val listaNombres = arrayListOf<String>()


        listaNombres.add("Pilot")
        listaNombres.add("Juan")
        listaNombres.add("Michael")
        listaNombres.add("Morales")
        listaNombres.add("Michael")
        listaNombres.add("Morales")


        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listaNombres)

        
        lv_ejemplo.adapter = adapter


        lv_ejemplo.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->


            Snackbar
                .make(view, "Se selecciono Posicion $position", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

            Log.i("listView","Posicion $position")




        }



    }
}
