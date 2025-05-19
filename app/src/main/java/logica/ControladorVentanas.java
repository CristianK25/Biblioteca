
package logica;

import javax.swing.SwingUtilities;
import modelo.*;
import vista.VentanaBibliotecario;
import vista.VentanaCliente;
import vista.VentanaInicioSesion;


public class ControladorVentanas {
    private static final Usuario u1 = null;
    private static VentanaInicioSesion v1;
    private static VentanaBibliotecario vb;
    private static VentanaCliente vc;
    
    public static void iniciarLogin(){
        SwingUtilities.invokeLater(() ->{
            VentanaInicioSesion v1 = new VentanaInicioSesion();
            v1.setVisible(true);
            v1.setLocationRelativeTo(null);
        });
    }
    
    public static void iniciarTipoUsuario(Usuario usuario){
        if(usuario.getTipoUsuario() == TipoUsuario.CLIENTE){
            v1.dispose();
            vc = new VentanaCliente();
            vc.setVisible(true);
        }else{
            v1.dispose();
            vb = new VentanaBibliotecario();
            vb.setVisible(true);
        }
    }
    
}
