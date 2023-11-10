package Controlador

import java.io.File
import java.time.LocalTime
import java.util.Timer

class ControladorLog {

    private val ficheroLog = File("log/logControlador")

    //intentar hacer un fun general para todos
    //hay que controlar nulos compi

    fun msgInsert(datosIns: List<String>) {
        var datos = ""
        datosIns.forEach { datos += "$it, " }
        val log = "Tipo_Operacion: INSERT || Datos: $datosIns || Hora: ${LocalTime.now()}"
        ficheroLog.appendText("$log\n")
    }

    fun msgSelect(salidaSelect: String) {
        val log = "Tipo_Operacion: SELECT || Datos: $salidaSelect || Hora: ${LocalTime.now()}\n"
        ficheroLog.appendText("$log\n")
    }

    fun msgUpdate(datoToUpdate: String, datoActualizado: String) {
        val log =
            "Tipo_Operacion: UPDATE || Dato a actualizar: $datoToUpdate \n Nuevo dato: $datoActualizado || Hora: ${LocalTime.now()}"
        ficheroLog.appendText("$log\n")
    }

    fun msgDeleteTable() {
        val log = "Tipo_Operacion: DELETE || Tabla eliminada completamente|| Hora: ${LocalTime.now()}"
        ficheroLog.appendText("$log\n")
    }

    fun msgDeleteRegistro(registroBorrado: String) {
        val log = "Tipo_Operacion: DELETE REGISTRO || Usuario numero: $registroBorrado ha sido eliminado|| Hora: ${LocalTime.now()}"
        ficheroLog.appendText("$log\n")
    }


}