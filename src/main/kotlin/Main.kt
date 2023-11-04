fun main() {
    //Objeto SQL
    val Bd_SQL = Sql_Oper(Conexion.connect)

    //DELETE
    val deleteQuery = "DELETE FROM tb_nomina"
    Bd_SQL.delete(deleteQuery)

    //INSERT
    val insertQuery = "INSERT INTO tb_nomina (nomb_emp, ape_emp, n_emp, sal_base, hs_trab, deducc, fech_pag) VALUES (?, ?, ?, ?, ?, ?, ?)"
    val listaUser1: List<Any> = listOf("Juan", "Perez", 1, 1200.00, 40, 200.00, "12/02/2000")
    val listaUser2: List<Any> = listOf("Maria", "Lopez", 2, 1400.00, 50, 300.00, "17/04/2002")

    //Pasamos lista de valores que va a incluir y la query de insercción
    Bd_SQL.insert(listaUser1, insertQuery)
    Bd_SQL.insert(listaUser2, insertQuery)

    //SELECT
    print(Bd_SQL.select("SELECT * FROM tb_nomina"))

    //Lista de objetos extraía de la BD
    val listaNominas = Bd_SQL.selectToNominaObject("tb_nomina")
    //for (item in listaNominas) println(item)
}