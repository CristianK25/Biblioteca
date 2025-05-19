
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;


public class Prestamo {
    private int numero;
    private LocalDate dia_prestamo;
    private LocalDate dia_devolucion;
    private Usuario socio;
    private ArrayList<Libro> prestado;

    public Prestamo(int numero, LocalDate dia_prestamo, LocalDate dia_devolucion, Usuario socio) {
        this.numero = numero;
        this.dia_prestamo = dia_prestamo;
        this.dia_devolucion = dia_devolucion;
        this.socio = socio;
        this.prestado = new ArrayList<>();
    }
    
    public void agregarLibroPrestado(Libro l){
        this.prestado.add(l);
    }

    public int getNumero() {
        return numero;
    }

    public LocalDate getDia_prestamo() {
        return dia_prestamo;
    }

    public LocalDate getDia_devolucion() {
        return dia_devolucion;
    }

    public Usuario getSocio() {
        return socio;
    }

    public ArrayList<Libro> getPrestado() {
        return prestado;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "numero=" + numero + ", dia_prestamo=" 
                + dia_prestamo + ", dia_devolucion=" + dia_devolucion 
                + ", socio=" + socio + ", prestado=" + prestado + '}';
    }
    
}
