package Controlador

import java.io.File

class ControladorLog {

    val ficheroLog = File("log/logControlador")

    fun msgInsert(datosIns: List<String>){
        var datos = ""
        datosIns.forEach { datos += "$it, " }
        val log = "Operacion: Insert || Datos: $datosIns"
        ficheroLog.appendText("$log\n")
    }

}