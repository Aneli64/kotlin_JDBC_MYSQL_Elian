package Vista

import Controlador.SqlOper

class Valores {
    companion object {
        fun inicio(): Int? {
            println("Seleccione una opción: \n 1) Select de la tabla \n 2) Insertar datos \n 3) Borrar tabla \n 4) Borrar registro\n 5) Update \n 6) Salir \n")
            return readln().toIntOrNull()
        }
        fun printError(){
            println("Opcion no disponible, inténtelo de nuevo")
        }
        fun imprimeSelect() {
            println(SqlOper().select())
        }

        fun imprimeSalir(){
            println("Saliendo...")
        }

    }
}