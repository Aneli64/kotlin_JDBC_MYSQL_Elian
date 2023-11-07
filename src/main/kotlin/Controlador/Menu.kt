package Controlador
//println y redln estan aqui

import Vista.Valores

class Menu {
    companion object {
        fun start() {
            Sql_Oper.delete() //delete inicial para la bd (hay que quitarlo)
            var input = Valores.inicio()
            while (input.isNotBlank()) {
                when (input) {
                    "1" -> {
                        Valores.imprimeSelect()
                        input = Valores.inicio()
                    }

                    "2" -> {
                        Sql_Oper.insert()
                        input = Valores.inicio()
                    }

                    "3" -> {
                        Sql_Oper.delete()
                        input = Valores.inicio()
                    }

                    "4" -> {
                        Sql_Oper.update()
                        input = Valores.inicio()
                    }

                    "5" -> break
                }
            }
        }
    }
}

