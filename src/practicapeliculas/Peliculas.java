package practicapeliculas;
import java.util.HashSet;
import java.util.Iterator;
import java.io.*;


public class Peliculas implements Serializable{

    private HashSet<Pelicula> listaPeliculas = new HashSet<>();
    
    
    // Constructor vacio
    public Peliculas() {
    }

    public HashSet<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }
    
    public void setListaPeliculas(HashSet<Pelicula> l){
        this.listaPeliculas= l; 
    }

    //Métodos
    public void anadirPelicula(Pelicula p){
        listaPeliculas.add(p);
    }

    public void verInfoPeliculas(){
        for (Pelicula p: listaPeliculas){
            System.out.println(p.toString());
        }
    }

    public Pelicula buscarPelicula(String titulo){
        boolean encontrado = false;
        Iterator<Pelicula> i = listaPeliculas.iterator();
        Pelicula film = new Pelicula();
        while(i.hasNext() && !encontrado){
            film = i.next();
            if(film.getTitulo().equals(titulo)){
                encontrado = true;
            }
        }
        return film;
    }
   
     public boolean existe(String titulo){
         if (getListaPeliculas().size()<1){
            return false; 
         }
         return ((new Pelicula(titulo)).equals(buscarPelicula(titulo))); 
    }
     

    public Pelicula peliculaAleatoria(){
            Iterator<Pelicula> it = listaPeliculas.iterator();
            int indice = (int) (Math.random()*listaPeliculas.size());
            System.out.println("-------indice " + indice);
            int i = 0;
            Pelicula p = new Pelicula();
            while(i <= indice && it.hasNext()){
                p = it.next();               
                i++;
            }
            System.out.println(p.toString());
        return p;
    }
         
}