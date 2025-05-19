
package modelo;

import java.util.ArrayList;


public class Autor {
    private String pseudonimo;

    public Autor(String pseudonimo) {
        this.pseudonimo = pseudonimo;
    }
    
    public String getPseudonimo() {
        return pseudonimo;
    }


    @Override
    public String toString() {
        return "Autor{" + "pseudonimo=" + pseudonimo;
    }
    
    
}
