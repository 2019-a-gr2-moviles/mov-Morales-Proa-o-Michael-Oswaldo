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