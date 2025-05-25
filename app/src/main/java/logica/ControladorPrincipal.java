package logica;

import modelo.Usuario;
import persistencia.ConexionBD;
import util.Log;
import vista.VentanaBibliotecario;
import vista.VentanaCliente;
import vista.VentanaInicioSesion;

public class ControladorPrincipal {
    private static final Usuario u1 = null;
    private static VentanaInicioSesion vi;
    private static VentanaBibliotecario vb;
    private static VentanaCliente vc;

    public static void iniciar() {
        Log.debug("Iniciando app...");
        if (!ConexionBD.inicializar()) {
            Log.warn("No se pudo inicializar");
            return;
        }
        vi = new VentanaInicioSesion();
    }

    public static void registrarUsuario() {
        // Lógica pendiente
    }
}
