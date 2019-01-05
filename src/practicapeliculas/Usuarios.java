/**
 * Ultima actualizacion: 30/12/2018
 * Cambios: (Por Carlos Sánchez Muñoz) Añadidos varios métodos
 * Version:2
 *
 */

package practicapeliculas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.HashSet;


public class Usuarios{
    private HashSet<Usuario> listaUsuarios = new HashSet<Usuario>();
    private Peliculas films;

    public Usuarios(Peliculas films){
        this.films = films;
    }
    /*
    public void autenticar(Usuario u) throws EUserNotFound, EPeliculaNotFound{
        boolean encontrado = false;
        Iterator<Usuario> i = listaUsuarios.iterator();
        Usuario user = null;
        while(i.hasNext() && !encontrado){
            user = i.next();
            encontrado = user.equals(u);
        }
        if(encontrado){
            Scanner sc = new Scanner(System.in);
            int opcion;
            do{
                menuUsuarioLogueado();
                opcion = sc.nextInt();
                switch (opcion){
                    case 1:
                        films.introducirPelicula();
                        break;
                    case 2:
                        Scanner read = new Scanner(System.in);
                        System.out.println("¿Qué película quieres compartir?");
                        String titulo = read.nextLine();
                        Pelicula p = films.buscarPelicula(titulo);
                        System.out.println("¿Con quién quieres compartir la película?");
                        String nombre = read.nextLine();
                        Usuario usu = buscarUsuario(nombre);
                        user.compartirPelicula(p, usu);
                        break;
                    case 3:
                        u.iniciarPartida(usuarioAleatorio());
                }
            }while(opcion != 4);
        }else{
            throw new EUserNotFound("Usuario no encontrado.");
        }
    }
    */
    public void identificar(Usuario u) throws EUserNotFound{
        Usuario user = buscarUsuario(u.getNombre());
    }

    public void registrar(Usuario u){
        listaUsuarios.add(u);
    }


    public  HashSet<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }


    // menu de prueba
    public void menuUsuarioLogueado(){
        System.out.println("***** Bienvenido *****");
        System.out.println("1. Añadir película");
        System.out.println("2. Compartir película");
        System.out.println("3. Iniciar Partida");
        System.out.println("4. Cerrar sesión");
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

    public Usuario usuarioAleatorio(Usuario usuario, HashSet<Usuario> set){                 // coger un usuario aleatorio menos "usuario"
        HashSet<Usuario> nuevoHashSet = set;        //copia del set
        Object[] lista = nuevoHashSet.toArray();
        Usuario usuarioDevuelto; 
        do{
            usuarioDevuelto = (Usuario) lista[(int) (Math.random() * lista.length)];
            
        }        
        while(usuarioDevuelto.equals(usuario));
        return usuarioDevuelto;
        /*
        int indice = (int) Math.random()*nuevoHashSet.size() + 1;
        Iterator<Usuario> it = nuevoHashSet.iterator();
        int i = 0;
        Usuario usu = it.next();
        while(it.hasNext() && i<indice){
            usu = it.next();
            if(usu.equals(usuario)){
                it.remove();
            }
        }
        return usu;
*/
    }
    
    public boolean existe(String nombre){
        if (getListaUsuarios().size()<1){
            return false; 
         }
        return (new Usuario(nombre).equals(buscarUsuario(nombre)));
    }
    
    public void WriteUsuarios(FileOutputStream file) {
        try {
            ObjectOutputStream outStream = new ObjectOutputStream(file);
            outStream.writeObject(listaUsuarios);
            outStream.close();
        } catch (IOException ex) {
        };

    }

    public void ReadUsuarios(FileInputStream file){
        try {
            ObjectInputStream inputStream = new ObjectInputStream(file);
            HashSet<Usuario> listaUsuariosGuardados = (HashSet<Usuario>) inputStream.readObject();
            listaUsuarios = listaUsuariosGuardados;
            inputStream.close();
        } catch (IOException ex) {
        } catch (ClassNotFoundException exc) {
        }

    }
}