import java.io.File
import java.util.*
import javax.swing.JOptionPane

fun main(args: Array<String>){
    println("Hola perros")
    val user = JOptionPane.showInputDialog("Ingrese su nombre de usuario:")
    val password = JOptionPane.showInputDialog("Ingrese su password:")
    if (validar(user,password)){
        if (user == "admin"){
            crud()
        }
        else{

            adoptar_mascota()
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

fun adoptar_mascota(){

    JOptionPane.showMessageDialog(null,"Bienvenidos a 'My PetShop', click en OK para continuar ")

    JOptionPane.showInputDialog("¿Que desea hacer? \n " +
            "1. Mostrar\n" +
            "2. Adoptar una Mascota\n" +
            "3. Salir")


}

fun crud(){



}
