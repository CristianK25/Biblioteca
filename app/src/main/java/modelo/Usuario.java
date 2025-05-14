
package modelo;


public class Usuario {
    private String nombre;
    private String contraseña;
    private TipoUsuario tipoUsuario;

    public Usuario(String nombre, String contraseña, TipoUsuario tipoUsuario) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", contrase\u00f1a=" 
                + contraseña + ", tipoUsuario=" + tipoUsuario + '}';
    }
    
    
}