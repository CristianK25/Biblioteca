
package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;


public class Log {
    private static final File archivo = new File("logs.txt");
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    
    public static void crearCarpetaLog(){
        if(!archivo.exists()){
            try{
                archivo.createNewFile();
            }catch(IOException e){
                JOptionPane.showMessageDialog(null, "No se pudo crear la carpeta log");
            }
        }
    }
    
    public static void escribirLog(String mensaje){
        archivo.setWritable(true);
        if (!archivo.canWrite()) {
            JOptionPane.showMessageDialog(null, "No hay permisos para escribir en el log");
            return;
        }
        String fechaHora = LocalDateTime.now().format(formatter);
        String mensajeCompleto = "[" + fechaHora + "] " + mensaje;
        try(FileWriter archivoEditable = new FileWriter(archivo,true)){
            archivoEditable.append(mensajeCompleto + "\n");
            archivoEditable.flush();
            archivo.setWritable(false);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "No se pudo escribir el log: "+ mensaje);
        }
    }
}
