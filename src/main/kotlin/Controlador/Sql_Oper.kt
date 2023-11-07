package Controlador

import Modelo.Conexion
import Modelo.Nomina
import java.sql.Connection

class Sql_Oper() {
    companion object {
        //VARIABLES NECESARIAS PARA LA CONEXION DE LA BD
        private val statement = Conexion.connect.createStatement()
        private val connect: Connection = Conexion.connect

        //INSERT Y DATOS NECESARIOS PARA EL INSERT
        fun insert() {
            val insert =
                connect.prepareStatement("INSERT INTO tb_nomina (nomb_emp, ape_emp, n_emp, sal_base, hs_trab, deducc, fech_pag) VALUES (?, ?, ?, ?, ?, ?, ?)")
            val valores = datosToInsert()
            for (i in valores.indices) {
                insert.setString(i + 1, valores[i])
            }
            insert.executeUpdate() //actualizamos cambios
        }

        fun datosToInsert(): List<String> {
            val nomina = Nomina()
            val listaAtrib = listOf("nombEmp", "apeEmp", "nEmp", "salBase", "hsTrab", "deducc", "fechPag")

            for (item in listaAtrib) {
                print("Introduzca su $item:\n")
                val dato = readln()
                when (item) {
                    listaAtrib[0] -> nomina.nombEmp = dato
                    listaAtrib[1] -> nomina.apeEmp = dato
                    listaAtrib[2] -> nomina.nEmp = dato.toInt()
                    listaAtrib[3] -> nomina.salBase = dato.toDouble()
                    listaAtrib[4] -> nomina.hsTrab = dato.toInt()
                    listaAtrib[5] -> nomina.deducc = dato.toDouble()
                    listaAtrib[6] -> nomina.fechPag = dato
                }
            }

            return listOf(
                nomina.nombEmp, nomina.apeEmp, nomina.nEmp.toString(),
                nomina.salBase.toString(), nomina.hsTrab.toString(), nomina.deducc.toString(), nomina.fechPag
            )
        }

        fun select(): String {
            val select = statement.executeQuery("SELECT * FROM tb_nomina")
            var salida = ""
            while (select.next()) { //Recorremos los registros del select y los vamos imprimiendo
                for (i in 1..select.metaData.columnCount) {
                    salida += "${select.getString(i)}, "
                }
                salida += "\n ${"-".repeat(10)} \n"
            }

            return salida
        }

        fun delete() = statement.executeUpdate("DELETE FROM tb_nomina")
        fun update() { //no funciona, mirar pq
            print("Introduzca el dato a actualizar |nomb_emp, ape_emp, n_emp, sal_base, hs_trab, deducc, fech_pag|:\n")
            val entrada = readln()

            print("Introduzca el numero del empleado\n")
            val numero = readln()

            print("Introduzca el nuevo dato:\n")
            val nuevoDato = readln()

            statement.executeQuery("Update tb_nomina Set '$entrada'='$nuevoDato' Where n_emp = '$numero'")
        }
    }

    //cosas de XML (Hay que moverlo de aqui a otro proyecto)
    fun selectToNominaObject(nombre_tabla: String): MutableList<Nomina> {
        val sentencia =
            "SELECT * FROM $nombre_tabla" //hacemos un select de la tabla para extraer sus datos y convertirlos a objetos
        val select = statement.executeQuery(sentencia)
        var nomina = Nomina()
        val listaNominas: MutableList<Nomina> = mutableListOf()
        while (select.next()) { //Recorremos los registros del select y los vamos imprimiendo
            for (i in 1..select.metaData.columnCount step (7)) { //almacenamos cada 7 valores para obtener cada objeto
                nomina.nombEmp = select.getString(i)
                nomina.apeEmp = select.getString(i + 1)
                nomina.nEmp = select.getString(i + 2).toInt()
                nomina.salBase = select.getString(i + 3).toDouble()
                nomina.hsTrab = select.getString(i + 4).toInt()
                nomina.deducc = select.getString(i + 5).toDouble()
                nomina.fechPag = select.getString(i + 6)
            }
            listaNominas.add(nomina) //añadimos a la lista antes de pasar a la siguiente nomina
            nomina = Nomina() //borramos la nomina una vez guardada, para almacenar la siguiente
        }
        return listaNominas
    }

}