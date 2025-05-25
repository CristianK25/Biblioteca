
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Autor;
import util.Log;


public class AutorDAO {
    private Connection conexion;
    
    public AutorDAO() {
        this.conexion = ConexionBD.obtenerConexion();
    }
 
    public boolean insertarAutor(Autor autor){
        if (buscarAutor(autor) != null){
            return false;
        }
        String sql = "INSERT INTO Autor(pseudonimo) VALUES (?)";
        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setString(1, autor.getPseudonimo());
            return true;
        }catch(SQLException e){
            Log.error("No se pudo insertar Autor: " + autor.toString(),e);
            return false;
        }
    }
    
    public Autor buscarAutor(Autor autor){
        String sql = "SELECT nombre FROM Autor WHERE nombre = ?";
        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setString(1,autor.getPseudonimo());
            try (ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    return new Autor(rs.getString("nombre"));
                }
            }
        }catch(SQLException e){
            Log.error("No se pudo encontrar el autor : " + autor.toString(),e);
        }
        return null;
    }
}
