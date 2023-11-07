package Vista

import Controlador.Sql_Oper
import Modelo.Conexion

class Valores {
    companion object {

        private val bdSQL = Sql_Oper(Conexion.connect)
        fun inicio(): String {
            print("Seleccione una opción: \n 1) Select de la tabla \n 2) Insertar datos \n 3) Borrar tabla \n 4) Salir \n")
            return readln()
        }

        fun imprimeSelect() {
            print(bdSQL.select("SELECT * FROM tb_nomina"))
        }

        fun realizaInsert() {
            bdSQL.insert(
                bdSQL.datosToInsert(),
                "INSERT INTO tb_nomina (nomb_emp, ape_emp, n_emp, sal_base, hs_trab, deducc, fech_pag) VALUES (?, ?, ?, ?, ?, ?, ?)"
            )
        }

        fun realizardelete(){
            bdSQL.delete("DELETE FROM tb_nomina")
        }
    }
}