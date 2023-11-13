package Vista

import java.io.File
import java.time.LocalTime

class ControladorVista {
    val ficheroLog = File("log/logVista")

    fun msgLogVista(opcion: Int){
        var log = "El usuario ha elegido la opcion || $opcion || ${LocalTime.now().hour}:${LocalTime.now().minute}"

        //Utilizamos un when para controlar datos de interes a utilizar por nuestro analizador de logs
        when(opcion) {
            6 -> log =  "El usuario ha elegido la opcion de salida || 6 || SALIR || ${LocalTime.now().hour}:${LocalTime.now().minute}"
            7 -> log  = "El usuario ha elegido una opcion no valida || ERROR || ${LocalTime.now().hour}:${LocalTime.now().minute}"
        }
        ficheroLog.appendText("$log\n")
    }
}