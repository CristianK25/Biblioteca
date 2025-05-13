
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBD {
    private static final String URL = "jdbc:h2:./Base de datos/db";
    private static final String USER = "sa";
    private static final String PASS = "";
    
    public static Connection obtenerConexion() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASS);
    }
    
    public static void iniciarBaseDatos(){
    }
}
