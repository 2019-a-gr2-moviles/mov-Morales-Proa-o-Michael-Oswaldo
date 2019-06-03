package com.example.mjg70.examen

class BaseAutos {
    companion object {
        val LST_AUTO:ArrayList<Auto> = ArrayList();
        var serial:Int= 1;

        fun agregarJugador(auto: Auto):ArrayList<Auto>{
            auto.id = serial
            serial++
            LST_AUTO.add(auto)
            return LST_AUTO
        }

        fun mostrarJugador(padreId:Int): List<Auto> {
            val lstFiltradaJugador = this.LST_AUTO.filter { it.idConductor ==  padreId}
            return lstFiltradaJugador
        }

        fun eliminarJugador(id:Int){
            this.LST_AUTO.removeAll{ it.id == id }
        }

        fun actualizarJugador(auto: Auto){
            val indice = this.LST_AUTO.indexOfFirst { it.id == auto.id }
            this.LST_AUTO[indice] = auto
        }

    }

}