package com.example.frontendindividual.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.frontendindividual.NavegacionUsuario.TodasMascotasActivity
import com.example.frontendindividual.R
import com.example.frontendindividual.dto.Mascota


class AdaptadorTodasMascotas  (private val listaPublicaciones:List<Mascota>,
                               private val contexto: TodasMascotasActivity,
                               private val recyclerview:RecyclerView
): RecyclerView.Adapter<AdaptadorTodasMascotas.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var imagen_mascota: ImageView
        var txt_nombre: TextView
        var txt_raza: TextView
        var txt_descripcion: TextView
        var txt_genero: TextView
        var idMascota: Int = 1
        var btn_adoptar: Button


        init {
            imagen_mascota = view.findViewById(R.id.img_mascota) as ImageView
            txt_nombre = view.findViewById(R.id.txt_nombre) as TextView
            txt_raza = view.findViewById(R.id.txt_raza) as TextView
            txt_descripcion = view.findViewById(R.id.txt_descripcion) as TextView
            txt_genero = view.findViewById(R.id.txt_genero) as TextView
            btn_adoptar = view.findViewById(R.id.btn_adoptar) as Button


            val layout = view.findViewById(R.id.mascota_layout) as RelativeLayout

            btn_adoptar.setOnClickListener {
                adoptar(idMascota)
            }


        }



    }
    fun adoptar(id:Int){
        contexto.adoptar(id)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.mascota_layout,
                p0,
                false
            )

        return MyViewHolder(itemView)

    }

    override fun getItemCount(): Int {

        return listaPublicaciones.size

    }

    override fun onBindViewHolder(myViewHolder: AdaptadorTodasMascotas.MyViewHolder, position: Int) {
        val mascotas = listaPublicaciones[position]
        myViewHolder.txt_nombre.text = mascotas.nombre
        myViewHolder.txt_descripcion.text = mascotas.descripcion
        myViewHolder.txt_genero.text = mascotas.genero.toString()
        myViewHolder.txt_raza.text = mascotas.fechaCreacion.toString()
        myViewHolder.idMascota = mascotas.id

        val idWhen = mascotas.id
        when(idWhen){
            1->{ myViewHolder.imagen_mascota.setImageResource(R.drawable.perrito1)}
            2->{ myViewHolder.imagen_mascota.setImageResource(R.drawable.perrito3)}
            3->{ myViewHolder.imagen_mascota.setImageResource(R.drawable.perrito2)}
            4->{ myViewHolder.imagen_mascota.setImageResource(R.drawable.perrito4)}
            5->{ myViewHolder.imagen_mascota.setImageResource(R.drawable.perrito5)}
            6->{ myViewHolder.imagen_mascota.setImageResource(R.drawable.perrito6)}
            7->{ myViewHolder.imagen_mascota.setImageResource(R.drawable.perrito7)}
            8->{ myViewHolder.imagen_mascota.setImageResource(R.drawable.perrito8)}
            9->{ myViewHolder.imagen_mascota.setImageResource(R.drawable.perrito9)}
            10->{ myViewHolder.imagen_mascota.setImageResource(R.drawable.perrito10)}
            else->{myViewHolder.imagen_mascota.setImageResource(R.drawable.perrito3)}

        }


    }



}