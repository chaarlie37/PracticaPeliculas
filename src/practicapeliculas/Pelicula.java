package practicapeliculas;
import java.util.ArrayList;

public class Pelicula implements Compartible {
    private String titulo;
    private int ano;
    private String director;
    private String actor;
    private String actriz;
    private String genero;

    // se olvidó el constructor, he hecho uno incompleto para hacer pruebas
    public Pelicula(String titulo, int ano, String director, String actor, String actriz, String genero){
        this.titulo = titulo;
        this.ano = ano;
        this.director = director;
        this.actor = actor; 
        this.actriz = actriz; 
        this.genero = genero; 
    }
    
    public Pelicula(String titulo){
        this.titulo= titulo; 
    }
    
    public Pelicula(){
        
    }

    public int getAno() {
        return ano;
    }

    public String getGenero() {
        return genero;
    }

    public String getActor() {
        return actor;
    }

    public String getActriz() {
        return actriz;
    }

    public String getDirector() {
        return director;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString(){
        return ("Titulo: " + titulo +  "\n Año: " + ano + "\n Director: " + director + "\n Actor: " + actor + "\n Actriz: " + actriz);
    }
  
    @Override
    public void compartir (Usuario u){
    }
    
   @Override
   
   public boolean equals(Object o){
       if (o == null)
           return false; 
       if (o.getClass() != this.getClass())
           return false; 
       if (o == this)
        return true;
       Pelicula film = (Pelicula) o; 
       return (film.getTitulo().equals(this.getTitulo())); 
   }
    
    @Override
    public void compartir(ArrayList<Usuario> usuarios) {
    }
}