import java.sql.DriverManager

fun main() {
    // Datos de conexión
    val jdbcUrl = "jdbc:mysql://localhost:3306/nomina"
    val user = "user"
    val passwd = "user"
    val conexion = DriverManager.getConnection(jdbcUrl, user, passwd) //intentar gestionar posible null

    //statment de la bd
    val statement = conexion.createStatement()

    val deleteQuery = "DELETE FROM tb_nomina"
    statement.executeUpdate(deleteQuery)

    //insert
    val insert =
        conexion.prepareStatement("INSERT INTO tb_nomina (nomb_emp, ape_emp, n_emp, sal_base, hs_trab, deducc, fech_pag) VALUES (?, ?, ?, ?, ?, ?, ?)")

    insert.setString(1, "Juan")
    insert.setString(2, "Perez")
    insert.setInt(3, 1)
    insert.setDouble(4, 1200.00)
    insert.setInt(5, 40)
    insert.setDouble(6, 200.00)
    insert.setString(7, "12/02/2000")
    insert.executeUpdate()


    val select = statement.executeQuery("SELECT * FROM tb_nomina")

    while (select.next()) {
        println("${select.getString("nomb_emp")} || ${select.getString("ape_emp")}")
    }
}