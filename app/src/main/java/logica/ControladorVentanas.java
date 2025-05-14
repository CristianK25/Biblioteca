
package logica;

import com.formdev.flatlaf.intellijthemes.FlatVuesionIJTheme;
import javax.swing.JFrame;
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
    
    public static void iniciar(){
        FlatVuesionIJTheme.setup();
        SwingUtilities.invokeLater(() ->{
            VentanaInicioSesion v1 = new VentanaInicioSesion();
            v1.setVisible(true);
            v1.setLocationRelativeTo(null);
        });
    }
    
    public static void cambiarVentana(Usuario usuario){
        if(usuario.getTipoUsuario() == TipoUsuario.CLIENTE){
            v1.dispose();
            vc = new VentanaCliente();
            vc.setVisible(true);
        }else{
            vb = new VentanaBibliotecario();
            vb.setVisible(true);
        }
    }
    
}
