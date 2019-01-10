package practicapeliculas;
import java.util.ArrayList;
import java.io.*;
import java.util.HashSet;
import java.util.Iterator;

public class Pelicula implements Compartible, Serializable{
    private String titulo;
    private int ano;
    private String director;
    private String actor;
    private String actriz;
    private String genero;
    private HashSet<Critica> listaCriticas;
    

    // se olvidó el constructor, he hecho uno incompleto para hacer pruebas
    public Pelicula(String titulo, int ano, String director, String actor, String actriz, String genero){
        this.titulo = titulo;
        this.ano = ano;
        this.director = director;
        this.actor = actor; 
        this.actriz = actriz; 
        this.genero = genero; 
        listaCriticas = new HashSet<>();
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
        return ("PELICULA \nTitulo: " + titulo +  "\n Año: " + ano + "\n Director: " + director + "\n Actor: " + actor + "\n Actriz: " + actriz);
    }
  
    @Override
    public void compartir (Usuario u){
        StringBuilder texto = new StringBuilder(this.toString());
        u.setMuro(texto);
    }
    
    @Override
    public void compartir(ArrayList<Usuario> usuarios) {
        StringBuilder texto = new StringBuilder(this.toString());
        Iterator<Usuario> it = usuarios.iterator();
        while (it.hasNext()) {
            it.next().setMuro(texto);
        }
    }
    
    public void anadirCritica(Critica c){
        listaCriticas.add(c);
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
    
    public HashSet<Critica> getListaCriticas() {
        return listaCriticas;
    }

    public void setListaCriticas(HashSet<Critica> listaCriticas) {
        this.listaCriticas = listaCriticas;
    }
    
    
}