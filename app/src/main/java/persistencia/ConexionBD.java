
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import util.Log;


public class ConexionBD {
    private static Connection conexion;
    private static final String URL = "jdbc:h2:./Base_de_datos/db";
    private static final String USER = "sa";
    private static final String PASS = "";
    
    public static Connection obtenerConexion(){
        if (conexion == null){
            try{
                conexion = DriverManager.getConnection(URL, USER, PASS);
            }catch(SQLException e){
                Log.error("No se pudo obtener la conexion a la base de datos",e);
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
            Log.error("No se pudo cerrar la conexion a la base de datos",e);
        }
    }
    
    private static void crearTabla(String sql, String nombreTabla) {
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            Log.error("No se pudo crear la tabla " + nombreTabla,e);
        }
    }
    
    public static boolean inicializar(){
        if (obtenerConexion() == null){
            return false;
        }
        String tbUsuario = "CREATE TABLE IF NOT EXISTS Usuario("
                + "idUsuario INT AUTO_INCREMENT,"
                + "nombre VARCHAR(50),"
                + "contra VARCHAR(60),"
                + "tipoUsuario VARCHAR(20),"
                + "PRIMARY KEY (idUsuario)"
                + ");";
        String tbLibro = "CREATE TABLE IF NOT EXISTS Libro("
                + "numero INT NOT NULL,"
                + "titulo VARCHAR(50) NOT NULL UNIQUE,"
                + "clasificacion VARCHAR(50) NOT NULL,"
                + "tema VARCHAR(20) NOT NULL,"
                + "PRIMARY KEY(numero)"
                + ");";
        String tbAutor = "CREATE TABLE IF NOT EXISTS Autor("
                + "idAutor INT AUTO_INCREMENT,"
                + "nombre VARCHAR(50),"
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
        return true;
    }
    private static void iniciarLibros(Connection conn){
        if (!estaVacia(conn)) return;
        Object[][] libros = {
        {1, "Don Quijote de la Mancha", "Literatura clásica"},
        {2, "Cien años de soledad", "Realismo mágico"},
        {3, "Fundación", "Ciencia ficción"},
        {4, "El arte de la guerra", null}, // Libro sin clasificación
        {5, "El señor de los anillos", "Fantasía"},
        {6, "Romeo y Julieta", "Drama"},
        {7, "Veinte poemas de amor y una canción desesperada", "Poesía"},
        {8, "It", "Terror"},
        {9, "Breves respuestas a las grandes preguntas", "Ciencia"},
        {10, "El poder del ahora", "Autoayuda"}
        };
        String sql = "INSERT INTO libro(numero,titulo,clasificacion) VALUES (?,?,?);";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
             conn.setAutoCommit(false);
        
        for (Object[] libro : libros) {
            ps.setInt(1, (Integer) libro[0]);
            ps.setString(2, (String) libro[1]);
            
            if (libro[2] != null) {
                ps.setString(3, (String) libro[2]);
            } else {
                ps.setNull(3, Types.VARCHAR);
            }
            
            ps.addBatch();
        }
        ps.executeBatch();
        conn.commit();
        }catch(SQLException e){
            System.out.println("No se pudieron ingresar los libros");
        }
    }
    public static boolean estaVacia(Connection conn){
        try (Statement checkStmt = conn.createStatement();
            ResultSet rs = checkStmt.executeQuery("SELECT COUNT(*) FROM libro")) {
           if (rs.next() && rs.getInt(1) > 0) {
               return true; // Ya hay datos, no insertar
           }
        } catch (SQLException e) {
            System.out.println("Error al verificar libros existentes");
            return false;
        }
        return false;
    }
}
