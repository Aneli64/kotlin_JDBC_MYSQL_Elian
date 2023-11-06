package Controlador
//println y redln estan aqui

import Modelo.Conexion
import Vista.Valores

class Menu {
    companion object {
        //Objeto SQL
        private val bdSQL = Sql_Oper(Conexion.connect)

        fun start() {
            bdSQL.delete("DELETE FROM tb_nomina") //hacemos un delete inicial para poder crear nuevos usuarios sin problemas
            Valores.inicio()
            Valores.entrada
            while (Valores.entrada.isNotBlank()) {
                when (Valores.entrada) {
                    "1" -> {
                        print(bdSQL.select("SELECT * FROM tb_nomina"))
                        Valores.inicio()
                        Valores.entrada = readln()
                    }

                    "2" -> {
                        bdSQL.insert(
                            bdSQL.datosToInsert(),
                            "INSERT INTO tb_nomina (nomb_emp, ape_emp, n_emp, sal_base, hs_trab, deducc, fech_pag) VALUES (?, ?, ?, ?, ?, ?, ?)"
                        )
                        Valores.inicio()
                        Valores.entrada = readln()
                    }

                    "3" -> {
                        bdSQL.delete("DELETE FROM tb_nomina")
                        Valores.inicio()
                        Valores.entrada = readln()
                    }

                    "4" -> break
                }
            }
        }



    }
}

