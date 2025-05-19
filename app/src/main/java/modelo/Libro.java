
package modelo;


public class Libro {
    private String titulo;
    private String clasificacion;
    private int numero;
    private Tema consiste_en;

    public Libro(int numero,String titulo,String clasificacion,Tema consiste_en) {
        this.titulo = titulo;
        this.clasificacion = clasificacion;
        this.numero = numero;
        this.consiste_en = consiste_en;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public int getNumero() {
        return numero;
    }

    public Tema getConsiste_en() {
        return consiste_en;
    }

    
    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo + ", clasificacion=" 
                + clasificacion + ", numero=" + numero 
                + ", consiste_en=" + consiste_en;
    }
    
}
