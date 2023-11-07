package Vista

import Controlador.Sql_Oper
import Modelo.Conexion

class Valores {
    companion object {
        fun inicio(): String {
            print("Seleccione una opción: \n 1) Select de la tabla \n 2) Insertar datos \n 3) Borrar tabla \n 4) Update \n 5) Salir \n")
            return readln()
        }
        fun imprimeSelect() {
            print(Sql_Oper.select())
        }

    }
}