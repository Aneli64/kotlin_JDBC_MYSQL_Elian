import Controlador.ControladorLog
import Controlador.Menu
import Vista.ControladorVista

fun main() {
    //Borramos contenido de files
    ControladorLog().ficheroLog.writeText("")
    ControladorVista().ficheroLog.writeText("")
    Menu.start()
}