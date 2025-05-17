
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Libro;
import util.Log;


public class LibroDAO {
 
    public static void insertarLibro(Libro libro){
        String sql = "INSERT INTO Libro(numero,titulo,clasificacion) VALUES (?,?,?)";
        try(PreparedStatement ps = ConexionBD.obtenerConexion().prepareStatement(sql) ){
            ps.setInt(1, libro.getNumero());
            ps.setString(2, libro.getTitulo());
            ps.setString(3,libro.getClasificacion());
        }catch(SQLException e){
            Log.escribirLog("No se pudo insertar Libro: " + libro.toString());
        }
    }
    
    public static void buscarLibro(Libro libro){
        String sql = "SELECT * FROM Libro WHERE nombre = ?";
        try(PreparedStatement ps = ConexionBD.obtenerConexion().prepareStatement(sql)){
            ps.setString(1, libro.getTitulo());
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    
                }
            }
        }catch(SQLException e){
            
        }
    }
}
