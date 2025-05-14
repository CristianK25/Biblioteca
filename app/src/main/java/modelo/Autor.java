
package modelo;

import java.util.ArrayList;


public class Autor {
    private String nombre;
    private String pseudonimo;
    private ArrayList<Libro> librosEscritos;

    public Autor(String pseudonimo, int dni, String nombre) {
        this.nombre = nombre;
        this.pseudonimo = pseudonimo;
        this.librosEscritos = new ArrayList<>();
    }

    public String getPseudonimo() {
        return pseudonimo;
    }

    public ArrayList<Libro> getLibrosEscritos() {
        return librosEscritos;
    }
    
    public void agregarLibro(Libro l){
        this.librosEscritos.add(l);
    }
}
