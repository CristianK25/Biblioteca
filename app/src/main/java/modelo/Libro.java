
package modelo;


public class Libro {
    private String titulo;
    private String clasificacion;
    private int numero;
    private Tema consiste_en;
    private Autor creador;

    public Libro(String titulo, String clasificacion, int numero, Tema consiste_en, Autor creador) {
        this.titulo = titulo;
        this.clasificacion = clasificacion;
        this.numero = numero;
        this.consiste_en = consiste_en;
        this.creador = creador;
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

    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo + ", clasificacion=" 
                + clasificacion + ", numero=" + numero 
                + ", consiste_en=" + consiste_en 
                + ", creador=" + creador + '}';
    }
    
}
