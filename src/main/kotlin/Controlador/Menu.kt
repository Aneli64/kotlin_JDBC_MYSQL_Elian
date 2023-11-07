package Controlador
//println y redln estan aqui

import Vista.Valores

class Menu {
    companion object {
        //Objeto SQL
        //private val bdSQL = Sql_Oper(Conexion.connect)

        fun start() {
            Valores.realizardelete() //delete inicial para la bd (hay que quitarlo)
            var input = Valores.inicio()
            while (input.isNotBlank()) {
                when (input) {
                    "1" -> {
                        Valores.imprimeSelect()
                        input = Valores.inicio()
                    }

                    "2" -> {
                        Valores.realizaInsert()
                        input = Valores.inicio()
                    }

                    "3" -> {
                        Valores.realizardelete()
                        input = Valores.inicio()
                    }

                    "4" -> break
                }
            }
        }


    }
}

