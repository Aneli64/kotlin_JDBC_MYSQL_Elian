package Controlador

import Vista.Valores

class Menu {
    companion object {
        fun start() {
            when (Valores.inicio()) {
                1 -> {
                    Valores.imprimeSelect()
                    start()
                }

                2 -> {
                    SqlOper.insert()
                    start()
                }

                3 -> {
                    SqlOper.delete()
                    start()
                }

                4 -> {
                    SqlOper.deleteRegistro()
                    start()
                }

                5 -> {
                    SqlOper.update()
                    start()
                }

                6 -> {
                    Valores.imprimeSalir()
                }

                else -> {
                    Valores.printError()
                    start()
                }
            }
        }
    }
}

