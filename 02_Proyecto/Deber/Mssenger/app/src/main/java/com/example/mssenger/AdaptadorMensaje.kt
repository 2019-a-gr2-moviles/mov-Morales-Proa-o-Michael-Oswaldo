package com.example.mssenger


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView

class AdaptadorMensaje (private val listaMensajes:List<Mensaje>,
                        private val contexto:MainActivity,
                        private val recyclerview:RecyclerView): RecyclerView.Adapter<AdaptadorMensaje.MyViewHolder>() {


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var imagen_usuario: ImageView
        var txt_autor_mensaje: TextView
        var txt_mensaje: TextView
        var txt_hora: TextView

        init {
            imagen_usuario = view.findViewById(R.id.img_profile_image) as ImageView
            txt_autor_mensaje = view.findViewById(R.id.txt_nombre_usuario) as TextView
            txt_mensaje = view.findViewById(R.id.txt_mensaje) as TextView
            txt_hora = view.findViewById(R.id.txt_hora) as TextView

            val layout = view.findViewById(R.id.layout_messenger) as RelativeLayout


        }
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout_messenger,
                p0,
                false
            )

        return MyViewHolder(itemView)

    }

    override fun getItemCount(): Int {

        return listaMensajes.size

    }

    override fun onBindViewHolder(myViewHolder: AdaptadorMensaje.MyViewHolder, position: Int) {
        val mensaje = listaMensajes[position]

        myViewHolder.txt_mensaje.text = mensaje.mensaje
        myViewHolder.txt_autor_mensaje.text = mensaje.autor
        myViewHolder.txt_hora.text = mensaje.hora

        when (mensaje.id_usuario) {
            1 -> {
                myViewHolder.imagen_usuario.setImageResource(R.drawable.a1)
            }
            2 -> {
                myViewHolder.imagen_usuario.setImageResource(R.drawable.a2)
            }
            3 -> {
                myViewHolder.imagen_usuario.setImageResource(R.drawable.a3)
            }
            4 -> {
                myViewHolder.imagen_usuario.setImageResource(R.drawable.a4)
            }
            5 -> {
                myViewHolder.imagen_usuario.setImageResource(R.drawable.a5)
            }
            6 -> {
                myViewHolder.imagen_usuario.setImageResource(R.drawable.a6)
            }
            7 -> {
                myViewHolder.imagen_usuario.setImageResource(R.drawable.a7)
            }
            8 -> {
                myViewHolder.imagen_usuario.setImageResource(R.drawable.a8)
            }
            9 -> {
                myViewHolder.imagen_usuario.setImageResource(R.drawable.a9)
            }
            10 -> {
                myViewHolder.imagen_usuario.setImageResource(R.drawable.a10)
            }
            else -> {
                myViewHolder.imagen_usuario.setImageResource(R.drawable.a1)
            }
        }

    }

}