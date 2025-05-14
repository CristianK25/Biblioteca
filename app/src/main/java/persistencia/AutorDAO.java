
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Autor;
import util.Log;


public class AutorDAO {
    private Connection conexion;
    
    public AutorDAO() {
        this.conexion = ConexionBD.obtenerConexion();
    }
 
    public void insertarAutor(Autor autor){
        String sql = "INSERT INTO Autor(pseudonimo) VALUES (?,?)";
        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setString(1, autor.toString());
        }catch(SQLException e){
            Log.escribirLog("No se pudo insertar Autor: " + autor.toString());
        }
    }
}
