import java.util.*

fun main(args:  Array<String>){




    println("Hello, world")

/*
*
* comentario
* */

    //variables

    //Que es mutar ??

var nombre = "Michael Morales"
    nombre = "Juan"

    val nombreI = "Lucho"
    //nombreI = "Luis"







    val apellido:String = "Morales"
    val edad: Int =22
    val sueldo =400
    val casado = false
    val profesor = true
    val hijos = null


    val tiene = if(apellido!=null && nombre!=null ) "ok" else "no"

    println(tiene)



    estaJalado(1.0)
    estaJalado(10.0)
    estaJalado(0.0)
    estaJalado(7.0)

    holaMundo("Michael hola")
holaMundoAvanzado(34)

    val suma = sumarDosNumeros(1,2)
    println(suma)







    val arregloCumpleaños :Array<Int> = arrayOf(1,2,3,4,5,6)

    arregloCumpleaños.set(0,5)


    val notas = arrayListOf(1,2,3,4,5,6)

 //val fecha = Date()


    //el foreach Itera el Arreglo
    notas.forEachIndexed{ indice, nota->
        println("Indice: $indice")
        println("nota: $nota")


    }


    //Map itera y modifica el arreglo


    val notasDos = notas.map{ nota->


        when(nota % 2 ){
             0 -> {
                nota+ 1
             }
            else ->{

                nota + 2
            }

        }
    }

    println("$notasDos")


    val respuestaFilter = notas.filter{

        it in 3..6


    }.map{

        it * 4


    }
respuestaFilter.forEach{println(it)}



    val novias = arrayListOf(1,2,3,4,5,6)


    val respuestaNovias = novias.any{

        it==3
    }
    val tazos = arrayListOf(1,2,3,4,5,6,7)

   val respuestaTazos =  tazos.all{
        it > 1


    }

    println(respuestaTazos)


    val valorTazos = tazos.reduce{  valorAcumulado, tazo  ->

        valorAcumulado + tazo


    }

    println(valorTazos)

}




fun estaJalado(nota:Double){

    when(nota){

        7.0 ->{
            println("Pasaste con las Justas")


        }
        10.0 ->{
            println("fELICITACIONES PASASTE")


        }
        0.0 ->{
            println("Ya te jalaste mijo: !!! ")


        }
        else -> {

            println("Tu nota es : $nota " )


        }


    }


}

fun holaMundo(mensaje: String):Unit{

    println("mensaje: $mensaje.")


}
fun holaMundoAvanzado(mensaje: Any):Unit{
    println("mensaje: $mensaje.")
}

fun sumarDosNumeros(numUno: Int, numDos: Int):Int{
    return numUno + numDos

}

