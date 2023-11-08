package Controlador

import Modelo.Conexion
import Modelo.Nomina
import java.sql.Connection

class SqlOper {
    companion object {
        //VARIABLES NECESARIAS PARA LA CONEXION DE LA BD
        private val statement = Conexion.connect.createStatement()
        private val connect: Connection = Conexion.connect

        /**
         * Metodo que inserta nuestros datos en la BD
         */
        fun insert() {
            val insert =
                connect.prepareStatement("INSERT INTO tb_nomina (nomb_emp, ape_emp, n_emp, sal_base, hs_trab, deducc, fech_pag) VALUES (?, ?, ?, ?, ?, ?, ?)")
            val valores = datosToInsert()
            for (i in valores.indices) {
                insert.setString(i + 1, valores[i])
            }
            insert.executeUpdate()
        }


        /**
         * nomina convertida a lista de atributos string para pasarlo a nuestro metodo insert()
         */
        fun datosToInsert(): List<String> {
            /*
            nomina -> objeto Nomina
            listaAtrib -> Lista de atributos que contiene nuestro objeto Nomina()
             */
            val nomina = Nomina()
            val listaAtrib = listOf("nombEmp", "apeEmp", "nEmp", "salBase", "hsTrab", "deducc", "fechPag")

            /* Bucle con ayuda de un when,
            que itera en nuestra lista de atributos, y rellena los atributos de nuestro objeto Nomina()*/
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

        /**
         * Metodo select que nos devuelve las tablas de nuestra BD
         */
        fun select(): String {
            val select = statement.executeQuery("SELECT * FROM tb_nomina")
            var salida = ""
            //Recorremos los registros del select y los vamos imprimiendo
            while (select.next()) {
                for (i in 1..select.metaData.columnCount) {
                    salida += "${select.getString(i)}, "
                }
                salida += "\n ${"-".repeat(10)} \n"
            }

            return salida
        }

        /**
         * Metodo que nos borra todas las tablas de nuestra BD
         */
        fun delete() = statement.executeUpdate("DELETE FROM tb_nomina")

        /**
         * Metodo que actualiza un dato de un registro en base a su numero de empleado
         */
        fun update() {
            //Pedimos tanto el registro a actualizar
            print("Introduzca el dato a actualizar |nomb_emp, ape_emp, n_emp, sal_base, hs_trab, deducc, fech_pag|:\n")
            val entrada = readln()
            //como el numero para saber que empleado deseamos modificar
            print("Introduzca el numero del empleado\n")
            val numero = readln()

            //e introducimos el nuevo dato
            print("Introduzca el nuevo dato:\n")
            val nuevoDato = readln()

            //Definimos la consulta y actualizamos los valores
            val sentencia = "UPDATE tb_nomina SET $entrada = ? WHERE n_emp = ?"
            val preparedStatement = connect.prepareStatement(sentencia)
            preparedStatement.setString(1, nuevoDato)
            preparedStatement.setString(2, numero)
            preparedStatement.executeUpdate()

        }

        /**
         * Metodo que nos elimina un empleado en base a su numero de empleado
         */
        fun deleteRegistro(){
            print("Introduzca el numero del empleado que desea eliminar:\n")
            val numero = readln()
            val sql = "DELETE FROM tb_nomina WHERE n_emp = ?"

            val preparedStatement = connect.prepareStatement(sql)
            preparedStatement.setString(1, numero)
            preparedStatement.executeUpdate()
        }
    }



}