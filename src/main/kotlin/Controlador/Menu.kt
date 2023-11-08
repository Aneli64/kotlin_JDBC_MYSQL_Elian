package Controlador
import Vista.Valores

class Menu {
    companion object {
        fun start() {
            SqlOper.delete() //delete inicial para la bd (hay que quitarlo)
            var input = Valores.inicio()
            while (input.isNotBlank()) {
                when (input) {
                    "1" -> {
                        Valores.imprimeSelect()
                        input = Valores.inicio()
                    }

                    "2" -> {
                        SqlOper.insert()
                        input = Valores.inicio()
                    }

                    "3" -> {
                        SqlOper.delete()
                        input = Valores.inicio()
                    }

                    "4" -> {
                        SqlOper.deleteRegistro()
                        input = Valores.inicio()
                    }

                    "5" -> {
                        SqlOper.update()
                        input = Valores.inicio()
                    }

                    "6" -> break
                }
            }
        }
    }
}

