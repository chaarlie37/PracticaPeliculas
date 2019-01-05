package practicapeliculas;
import java.util.HashSet; 
// falta implements compartible
public class Critica {
    private String pelicula;
    private double puntuacion;
    private String texto;
    private static HashSet<Critica> listaCriticas = new HashSet<>();

    public Critica (String pelicula){
        this.pelicula = pelicula; 
        this.puntuacion = 0; 
        this.texto = "";  
    }
    public Critica(String pelicula, double puntuacion, String texto){
        this.pelicula = pelicula; 
        this.puntuacion = puntuacion; 
        this.texto = texto;  
    }
    
    public HashSet<Critica> getListaCriticas(){
        return listaCriticas; 
    }
    
    
   
   /* @Override
    public void compartir(Usuario u) {
    
    }

    @Override
    public void compartir(HashSet<Usuario> usuarios) {
        
    }
    */

    public double getPuntuacion() {
        return puntuacion;
    }

    public String getTexto() {
        return texto;
    }
    
}