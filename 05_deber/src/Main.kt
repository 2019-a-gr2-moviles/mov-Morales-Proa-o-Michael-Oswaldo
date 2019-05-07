import java.io.File
import java.util.*
import javax.swing.JOptionPane
import kotlin.collections.ArrayList

fun main(args: Array<String>){
    println("Hola perros")
    val user = JOptionPane.showInputDialog("   Bienvenido a 'My PetShop' " +
            "\n" +
            "Ingrese su nombre de usuario:" +
            "")
    val password = JOptionPane.showInputDialog("Ingrese su password:")
    if (validar(user,password)){
        if (user == "admin"){
            crud()
        }
        else{

            adoptar_mascota(user)
        }

    }
    else{

        println("No se encontro Usuario")

    }



}
fun validar(usuario:String,contraseña:String):Boolean{
    val path = "./src/usuarios.txt"
    val arreglo_usuarios = ArrayList<String>()
    File(path).forEachLine { linea ->
        arreglo_usuarios.add(linea)
    }
    var split_usuarios = listOf<String>()

    arreglo_usuarios.forEach { leida ->
        split_usuarios = leida.split(",")
        if (split_usuarios[0]==usuario && split_usuarios[1] == contraseña) {
            return true
        }
    }
    return false


}

fun adoptar_mascota(nombre:String){

    JOptionPane.showMessageDialog(null,"Bienvenido $nombre \n Presiona en OK para continuar ")

    JOptionPane.showInputDialog("¿Que desea hacer? \n " +
            "1. Mostrar\n" +
            "2. Adoptar una Mascota\n" +
            "3. Salir")


}

fun crud(){
    val path = "./src/mascotas.txt"
do {
    val accion = JOptionPane.showInputDialog(
        "¿Que desea realizar? \n" +
                "1. Mostrar Mascotas\n" +
                "2. Crear Mascota\n" +
                "3. Editar Mascota\n" +
                "4. Eliminar Macota\n" +
                "5. Salir"
    )
    if(accion == "1"){
file_handler(path,"Mostrar")
    }
    if(accion == "2"){

    }
    if(accion == "3"){

    }
    if(accion == "4"){

    }
    if(accion == "5"){

    }

}while(accion != "5")

}


fun file_handler(path: String, accion:String){
    var mostrar = "Código:      Tipo:        Nombre:\n"
    val arreglo_usuarios = ArrayList<String>()
    if (accion == "Mostrar" ) {

       File(path).forEachLine { linea ->
           arreglo_usuarios.add(linea)

       }

arreglo_usuarios.forEach {
    mostrar = mostrar + "        "+it.split(',')[2]+"          "+it.split(',')[1]+"        "+it.split(',')[0]+"\n"
}
        JOptionPane.showMessageDialog(null, mostrar)
   }
    else if(accion == "Crear"){


   }else if(accion == "Editar"){

   }else if(accion == "Eliminar"){


   }


}