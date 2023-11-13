package Controlador

import Vista.ControladorVista
import Vista.Valores

class Menu {
    companion object {
        fun start() {
            when (Valores.inicio()) {
                1 -> {
                    ControladorVista().msgLogVista(1)
                    Valores.imprimeSelect()
                    start()
                }

                2 -> {
                    ControladorVista().msgLogVista(2)
                    SqlOper().insert()
                    start()
                }

                3 -> {
                    ControladorVista().msgLogVista(3)
                    SqlOper().delete()
                    start()
                }

                4 -> {
                    ControladorVista().msgLogVista(3)
                    SqlOper().deleteRegistro()
                    start()
                }

                5 -> {
                    ControladorVista().msgLogVista(3)
                    SqlOper().update()
                    start()
                }

                6 -> {
                    ControladorVista().msgLogVista(6)
                    Valores.imprimeSalir()

                }

                else -> {
                    ControladorVista().msgLogVista(7)
                    Valores.printError()
                    start()
                }
            }
        }
    }
}

