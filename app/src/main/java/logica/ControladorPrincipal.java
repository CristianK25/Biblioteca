
package logica;

import modelo.Usuario;
import persistencia.ConexionBD;
import util.Log;
import vista.VentanaBibliotecario;
import vista.VentanaCliente;
import vista.VentanaInicioSesion;


public class ControladorPrincipal {
    private static final Usuario u1 = null;
    private static VentanaInicioSesion v1;
    private static VentanaBibliotecario vb;
    private static VentanaCliente vc;
    
    public static void iniciar(){
        Log.debug("Iniciando app...");
        if (!ConexionBD.inicializar()){
            Log.warn("No se pudo incializar");
            return;
        }
        ControladorVentanas.iniciarLogin();
    }
    
    public static void registrarUsuario(){
        
    }

}
