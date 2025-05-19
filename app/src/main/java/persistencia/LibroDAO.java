
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Libro;
import modelo.Tema;
import util.Log;


public class LibroDAO {
 
    public static boolean insertarLibro(Libro libro){
        if(buscarLibro(libro) != null){
            return false;
        }
        String sql = "INSERT INTO Libro(numero,titulo,clasificacion,tema) VALUES (?,?,?,?)";
        try(PreparedStatement ps = ConexionBD.obtenerConexion().prepareStatement(sql) ){
            ps.setInt(1, libro.getNumero());
            ps.setString(2, libro.getTitulo());
            ps.setString(3,libro.getClasificacion());
            ps.setString(4,libro.getConsiste_en().name());
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            Log.escribirLog("No se pudo insertar Libro: " + libro.toString(),e.getMessage());
            return false;
        }
    }
    
    public static Libro buscarLibro(Libro libro){
        String sql = "SELECT * FROM Libro WHERE titulo = ?";
        try(PreparedStatement ps = ConexionBD.obtenerConexion().prepareStatement(sql)){
            ps.setString(1, libro.getTitulo());
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    return new Libro(
                            rs.getInt("numero"),
                            rs.getString("titulo"),
                            rs.getString("clasificacion"),
                            Tema.valueOf(rs.getString("tema").toUpperCase()));
                }
            }
        }catch(SQLException e){
            Log.escribirLog("No se pudo buscar el libro "+ libro.toString(),e.getMessage());
        }
        return null;
    }
}
