package practicapeliculas;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;


public class Critica implements Compartible, Serializable{
    private String pelicula;
    private double puntuacion;
    private String texto;
    private static int identificador;

    public Critica (String pelicula){
        this.pelicula = pelicula; 
        this.puntuacion = 0; 
        this.texto = "";
        identificador++;
    }
    public Critica(String pelicula, double puntuacion, String texto){
        this.pelicula = pelicula; 
        this.puntuacion = puntuacion; 
        this.texto = texto;  
        identificador++;
    }
      
   
    @Override
    public void compartir(Usuario u) {
        StringBuilder texto = new StringBuilder(this.mostrarCritica());
        u.setMuro(texto);
    }

    @Override
    public void compartir(ArrayList<Usuario> usuarios) {
        StringBuilder texto = new StringBuilder(this.mostrarCritica());
        Iterator<Usuario> it = usuarios.iterator();
        while (it.hasNext()) {
            it.next().setMuro(texto);
        }
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public String getTexto() {
        return texto;
    }

    public String getPelicula() {
        return pelicula;
    }
    
    @Override
    public String toString(){
        return "ID: " + identificador;
    }
    
    public String mostrarCritica(){
        return "Crítica Nº: " + identificador + "\n" +
                "Puntuación: " + puntuacion + "\n" +
                texto + "\n";
    }
    
}