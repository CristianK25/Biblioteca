
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Usuario;
import util.Log;


public class UsuarioDAO {
    
    /**
     * Busca en la base de datos si existe el usuario enviado
     * @param usuario
     * @return true si existe - false si no existe
     */
    public static boolean existeUsuario(Usuario usuario){
        String sql = "SELECT * FROM Usuarios WHERE nombre = ?";
        try(PreparedStatement ps = ConexionBD.obtenerConexion().prepareStatement(sql)){
            ps.setString(1,usuario.getNombre());
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    return true;
                }
            }
        }catch(SQLException e){
            Log.error("No se pudo buscar usuario: "+ usuario.toString(), e);
        }
        return false;
    }
    
    /**
     * Registra al usuario en la base de datos de ser posible
     * @param usuario
     * @return true si lo registra correctamente - false si no lo registra
     */
    public static boolean registrarUsuario(Usuario usuario){
        if(existeUsuario(usuario)) return false;
        String sql = "INSERT INTO Usuario(nombre,contra,tipoUsuario) VALUES (?,?,?)";
        try(PreparedStatement ps = ConexionBD.obtenerConexion().prepareStatement(sql)){
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getContraseña());
            ps.setString(3, usuario.getTipoUsuario().name());
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            Log.error("No se pudo registrar el usuario",e);
        }
        return false;
    }
}
