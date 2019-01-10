package practicapeliculas;

import java.util.Iterator;
import java.util.HashSet;
import java.io.*;


public class Usuarios implements Serializable{
    private HashSet<Usuario> listaUsuarios = new HashSet<Usuario>();
    private Peliculas films;

    public Usuarios(Peliculas films){
        this.films = films;
    }
    
    public void registrar(Usuario u){
        listaUsuarios.add(u);
    }


    public  HashSet<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(HashSet<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }   

    public Usuario buscarUsuario(String nombre){
        boolean encontrado = false;
        Iterator<Usuario> i = listaUsuarios.iterator();
        Usuario usu = new Usuario();
        while(i.hasNext() && !encontrado){
            usu = i.next();
            if(usu.getNombre().equals(nombre)){
                encontrado = true;
            }
        }
        return usu;
    }

    public Usuario usuarioAleatorio(Usuario usuario){                 // coger un usuario aleatorio menos "usuario"
        HashSet<Usuario> nuevoHashSet = listaUsuarios;        //copia del set
        Object[] lista = nuevoHashSet.toArray();
        Usuario usuarioDevuelto; 
        do{
            usuarioDevuelto = (Usuario) lista[(int) (Math.random() * lista.length)];
            
        }        
        while(usuarioDevuelto.equals(usuario));
        return usuarioDevuelto;
    }
    
    public boolean existe(String nombre){
        if (getListaUsuarios().size()<1){
            return false; 
         }
        return (new Usuario(nombre).equals(buscarUsuario(nombre)));
    }

    public Usuario bucarUsuario(String nom){
        boolean encontrado = false;
        Iterator<Usuario> i = listaUsuarios.iterator();
        Usuario usu = new Usuario();
        while(i.hasNext() && !encontrado){
            usu = i.next();
            if(usu.getNombre().equals(nom)){
                encontrado = true;
            }
        }
        return usu;
    }
}