package Controlador

import Modelo.Conexion
import Modelo.Nomina
import java.sql.Connection

class Sql_Oper(private val connect: Connection) {

    //statment de la bd
    private val statement = Conexion.connect.createStatement()

    //conexion
    //private val connect: Connection

    private fun nominaToList(nomina: Nomina): List<String> { //pasamos nomina a lista, para ser tratado con mayor facilidad
        return listOf(
            nomina.nomb_emp, nomina.ape_emp, nomina.n_emp.toString(),
            nomina.sal_base.toString(), nomina.hs_trab.toString(), nomina.deducc.toString(), nomina.fech_pag
        )

    }
    fun datosToInsert(): List<String>{
        val nomina = Nomina()
        val listaAtrib = listOf("nombEmp", "apeEmp", "nEmp", "salBase", "hsTrab", "deducc", "fechPag")

        for (item in listaAtrib) {
            print("Introduzca su $item:\n")
            val dato = readln()
            when (item) {
                listaAtrib[0] -> nomina.nomb_emp = dato
                listaAtrib[1] -> nomina.ape_emp = dato
                listaAtrib[2] -> nomina.n_emp = dato.toInt()
                listaAtrib[3] -> nomina.sal_base = dato.toDouble()
                listaAtrib[4] -> nomina.hs_trab = dato.toInt()
                listaAtrib[5] -> nomina.deducc = dato.toDouble()
                listaAtrib[6] -> nomina.fech_pag = dato
            }
        }
        return nominaToList(nomina)
    }

    fun insert(valores: List<Any>, sentencia: String) {
        val insert = connect.prepareStatement(sentencia)
        for (i in valores.indices) {
            when (valores[i]) {
                is String -> insert.setString(
                    i + 1,
                    valores[i].toString()
                ) //sumamos 1 al i ya que el parameterindex debe empezar en 1
                is Double -> insert.setDouble(i + 1, valores[i].toString().toDouble())
                is Int -> insert.setInt(i + 1, valores[i].toString().toInt())
            }
        }
        insert.executeUpdate() //actualizamos cambios
    }

    fun delete(sentencia: String) = statement.executeUpdate(sentencia)

    fun select(sentencia: String): String {
        val select = statement.executeQuery(sentencia)
        var salida = ""
        while (select.next()) { //Recorremos los registros del select y los vamos imprimiendo
            for (i in 1..select.metaData.columnCount) {
                salida += "${select.getString(i)}, "
            }
            salida += "\n ${"-".repeat(10)} \n"
        }

        return salida
    }

    fun update(){


    }

    fun selectToNominaObject(nombre_tabla: String): MutableList<Nomina> {
        val sentencia =
            "SELECT * FROM $nombre_tabla" //hacemos un select de la tabla para extraer sus datos y convertirlos a objetos
        val select = statement.executeQuery(sentencia)
        var nomina = Nomina()
        val listaNominas: MutableList<Nomina> = mutableListOf()
        while (select.next()) { //Recorremos los registros del select y los vamos imprimiendo
            for (i in 1..select.metaData.columnCount step (7)) { //almacenamos cada 7 valores para obtener cada objeto
                nomina.nomb_emp = select.getString(i)
                nomina.ape_emp = select.getString(i + 1)
                nomina.n_emp = select.getString(i + 2).toInt()
                nomina.sal_base = select.getString(i + 3).toDouble()
                nomina.hs_trab = select.getString(i + 4).toInt()
                nomina.deducc = select.getString(i + 5).toDouble()
                nomina.fech_pag = select.getString(i + 6)
            }
            listaNominas.add(nomina) //añadimos a la lista antes de pasar a la siguiente nomina
            nomina = Nomina() //borramos la nomina una vez guardada, para almacenar la siguiente
        }
        return listaNominas
    }

}