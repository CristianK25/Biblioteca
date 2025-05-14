
package modelo;

import java.util.ArrayList;


public class Autor {
    private String pseudonimo;
    private ArrayList<Libro> librosEscritos;

    public Autor(String pseudonimo, int dni) {
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

    @Override
    public String toString() {
        return "Autor{" + "pseudonimo=" + pseudonimo + ", librosEscritos=" + librosEscritos + '}';
    }
    
    
}
