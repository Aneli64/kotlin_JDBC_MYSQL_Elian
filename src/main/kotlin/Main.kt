import Controlador.ControladorLog
import Controlador.Menu
import Vista.ControladorVista

fun main(args: Array<String>) {
    //Borramos contenido de files
    ControladorLog().ficheroLog.writeText("")
    ControladorVista().ficheroLog.writeText("")
    Menu.start()
}