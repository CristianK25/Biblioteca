
package modelo;


public class Usuario {
    private String nombre;
    private String contra;
    private TipoUsuario tipoUsuario;

    public Usuario(String nombre, String contrasenia, TipoUsuario tipoUsuario) {
        this.nombre = nombre;
        this.contra = contrasenia;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contra;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre = " + nombre + ", contra = " 
                + contra + ", tipoUsuario=" + tipoUsuario + '}';
    }
    
    
}