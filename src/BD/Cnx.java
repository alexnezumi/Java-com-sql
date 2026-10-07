package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Cnx {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/achados_perdidos";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConexao() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

