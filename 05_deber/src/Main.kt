import java.io.File
import java.util.*
import javax.swing.JOptionPane
import kotlin.collections.ArrayList
import java.io.FileWriter
import java.io.IOException

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
    val path = "./src/usuarios.txt"
    JOptionPane.showMessageDialog(null,"Bienvenido $nombre \n Presiona en OK para continuar ")
do {
    val accion = JOptionPane.showInputDialog(
        "¿Que desea hacer? \n " +
                "1. Mostrar Mascotas\n" +
                "2. Adoptar una Mascota\n" +
                "3. Salir"
    )
    if (accion == "1") {
        file_handler(path, "Mostrar")
    }
    if (accion == "2") {

    }

}while(accion!="3")
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
        file_handler(path,"Crear")
    }
    if(accion == "3"){
        file_handler(path,"Editar")
    }
    if(accion == "4"){
        file_handler(path,"Eliminar")
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

        val nombreMascotaCreada = JOptionPane.showInputDialog("Ingrese el Nombre de la mascota a creár")
        val tipoMascotaCreada = JOptionPane.showInputDialog("Ingrese el Tipo de la mascota a creár")
        val indiceMascotaCreada = JOptionPane.showInputDialog("Ingrese el Indice de la mascota a creár")


        try {
            val fw = FileWriter(path, true)
            fw.write("$nombreMascotaCreada,$tipoMascotaCreada,$indiceMascotaCreada\n")
            fw.close()
            JOptionPane.showMessageDialog(null,"Mascota Creada!")
        } catch (e: IOException) {
            JOptionPane.showMessageDialog(null,"Mascota No se pudo Crear!")
        }

        }

   else if(accion == "Editar"){
        val indiceEditar = JOptionPane.showInputDialog("Ingrese el indice de la mascota a editar")
        File(path).forEachLine { linea ->
            arreglo_usuarios.add(linea)
        }
       val indiceEncontrado = arreglo_usuarios.indexOfFirst {linea -> linea.split(",")[2]==indiceEditar  }
        if(indiceEncontrado>0){
            val nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre")
            val nuevoTipo = JOptionPane.showInputDialog("Ingrese el nuevo Tipo de Mascota")
            val nuevoIndice = JOptionPane.showInputDialog("Ingrese el nuevo indice de la Mascota")
            arreglo_usuarios[indiceEncontrado] = "$nuevoNombre,$nuevoTipo,$nuevoIndice"

        }else{

            JOptionPane.showMessageDialog(null, "No existe el indice ingresado")
        }
        try {
            val fw = FileWriter(path, true)

            File(path).writeText("")
            arreglo_usuarios.forEach {

                fw.write(it+"\n")
            }
            fw.close()
            JOptionPane.showMessageDialog(null,"Mascota Editada!")
        } catch (e: IOException) {
            JOptionPane.showMessageDialog(null,"Mascota No se pudo Editar!")
        }
   }
    else if(accion == "Eliminar"){
        val indiceBorrar = JOptionPane.showInputDialog("Ingrese el indice de la mascota a Borrar")
        File(path).forEachLine { linea ->
            arreglo_usuarios.add(linea)
        }
        val indiceEncontrado = arreglo_usuarios.indexOfFirst {linea -> linea.split(",")[2]==indiceBorrar  }
        if(indiceEncontrado>0){

            arreglo_usuarios.removeAt(indiceEncontrado)

        }else{

            JOptionPane.showMessageDialog(null, "No se encontro el indice mencionado")
        }
        try {
            val fw = FileWriter(path, true)

            File(path).writeText("")
            arreglo_usuarios.forEach {

                fw.write(it+"\n")
            }
            fw.close()
            JOptionPane.showMessageDialog(null,"Mascota Eliminada!")
        } catch (e: IOException) {
            JOptionPane.showMessageDialog(null,"Mascota No se pudo Eliminar!")
        }
    }
}