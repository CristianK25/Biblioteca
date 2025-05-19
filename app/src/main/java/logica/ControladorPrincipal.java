
package logica;

import persistencia.ConexionBD;


public class ControladorPrincipal {
    public static void iniciar(){
        if (!ConexionBD.inicializar()){
            System.out.println("No se pudo inicializar");
            return;
        }
        ControladorVentanas.iniciarLogin();
    }
    
    public static void registrarUsuario(){
        
    }
}
