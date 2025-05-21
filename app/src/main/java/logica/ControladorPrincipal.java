
package logica;

import persistencia.ConexionBD;
import vista.VentanaInicioSesion;


public class ControladorPrincipal {
    static VentanaInicioSesion vi;
    
    
    public static void iniciar(){
        if (!ConexionBD.inicializar()){
            System.out.println("No se pudo inicializar");
            return;
        }
        vi= new VentanaInicioSesion();
    }
    
    public static void registrarUsuario(){
        
    }
}
