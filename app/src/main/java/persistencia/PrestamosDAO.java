
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Prestamo;
import util.Log;


public class PrestamosDAO {
    private Connection conexion;
    
    public PrestamosDAO() {
        this.conexion = ConexionBD.obtenerConexion();
    }
 
    public void insertarPrestamo(Prestamo prestamo){
        String sql = "INSERT INTO Autor(pseudonimo) VALUES (?,?)";
        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setString(1, prestamo.toString());
        }catch(SQLException e){
            Log.error("No se pudo insertar Autor: " + prestamo.toString(),e);
        }
    }
}
