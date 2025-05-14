
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.Log;


public class ConexionBD {
    private static Connection conexion;
    private static final String URL = "jdbc:h2:./Base de datos/db";
    private static final String USER = "sa";
    private static final String PASS = "";
    
    public static Connection obtenerConexion(){
        if (conexion == null){
            try{
                conexion = DriverManager.getConnection(URL, USER, PASS);
            }catch(SQLException e){
                Log.escribirLog("No se pudo obtener la conexion a la base de datos");
            }
        }
        return conexion;
    }
    
    public static void cerrarConexion(){
        try{
            if(conexion != null && !conexion.isClosed()){
                conexion.close();
                conexion = null;
            }
        }catch(SQLException e){
            Log.escribirLog("No se pudo cerrar la conexion a la base de datos");
        }
    }
    
    private static void crearTabla(String sql, String nombreTabla) {
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            Log.escribirLog("No se pudo crear la tabla " + nombreTabla);
        }
    }
    
    public static void inicializar(){
        String tbUsuario = "CREATE TABLE IF NOT EXISTS Usuario("
                + "idUsuario INT AUTO_INCREMENT,"
                + "nombre VARCHAR(50),"
                + "contra VARCHAR(60),"
                + "tipoUsuario VARCHAR(20),"
                + "PRIMARY KEY (idUsuario)"
                + ");";
        String tbLibro = "CREATE TABLE IF NOT EXISTS Libro("
                + "numero INT AUTO_INCREMENT,"
                + "titulo VARCHAR(50) NOT NULL,"
                + "clasificacion VARCHAR(50) NOT NULL,"
                + "PRIMARY KEY(numero)"
                + ");";
        String tbAutor = "CREATE TABLE IF NOT EXISTS Autor("
                + "idAutor INT AUTO_INCREMENT,"
                + "pseudonimo VARCHAR(50),"
                + "PRIMARY KEY (idAutor)"
                + ");";
        String tbPrestamo = "CREATE TABLE IF NOT EXISTS Prestamo("
                + "idPrestamo INT AUTO_INCREMENT,"
                + "dia_prestamo DATE NOT NULL,"
                + "dia_devolucion DATE,"
                + "numeroLibro INT,"
                + "idUsuario INT,"
                + "PRIMARY KEY (idPrestamo),"
                + "FOREIGN KEY (numeroLibro) REFERENCES Libro(numero),"
                + "FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario)"
                + ");";
        String tbAutorLibro = "CREATE TABLE IF NOT EXISTS Autor_Libro("
                + "numeroLibro INT,"
                + "idAutor INT,"
                + "PRIMARY KEY (numeroLibro,idAutor),"
                + "FOREIGN KEY (numeroLibro) REFERENCES Libro(numero),"
                + "FOREIGN KEY (idAutor) REFERENCES Autor(idAutor)"
                + ");";
        crearTabla(tbUsuario, "Usuario");
        crearTabla(tbAutor, "Autor");
        crearTabla(tbLibro, "Libro");
        crearTabla(tbPrestamo, "Prestamo");
        crearTabla(tbAutorLibro, "Autor_Libro");
    }
}
