package practicapeliculas;

import java.util.ArrayList;
import java.util.HashSet;
import java.io.*;
import java.util.Iterator;

public class Usuario implements Serializable{
    private String nombre;
    private String contrasena;
    private StringBuilder muro;
    private int partidas_ganadas;
    private int partidas_perdidas;
    private int partidas_empatadas;
    private HashSet<Partida> partidas_completas = new HashSet<Partida>();
    private HashSet<Partida> partidas_pendientes = new HashSet<Partida>();
    private ArrayList<Usuario> solicitudes_amigos_pendientes = new ArrayList<Usuario>();
    private ArrayList<Usuario> lista_amigos = new ArrayList<Usuario>();
    private Usuarios users;
    private Peliculas films;

    public Usuario(String name, String passw, Usuarios users, Peliculas films){

        this.nombre = name;
        this.contrasena = passw;
        this.muro = new StringBuilder();
        this.partidas_ganadas = 0;
        this.partidas_perdidas = 0;
        this.partidas_empatadas = 0;
        this.users = users;
        this.films = films;
    }
    
    public Usuario(){
        
    }
    
    public Usuario(String nombre){
        this.nombre = nombre;
    }
    
    public Usuario(String nombre, String pass) {
        this.nombre = nombre;
        this.contrasena = pass;
    }

    public ArrayList<Usuario> getLista_amigos() {
        return lista_amigos;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMuro(StringBuilder muro) {
        this.muro.insert(0, "\n");
        this.muro.insert(0, "\n");
        this.muro.insert(0, muro); // Al muro que metemos por argumento se añade al muro de this
    }

    public void setPartidas_completas(HashSet<Partida> partidas_completas) {
        this.partidas_completas = partidas_completas;
    }

    public void setPartidas_empatadas(int partidas_empatadas) {
        this.partidas_empatadas = partidas_empatadas;
    }

    public void setPartidas_ganadas(int partidas_ganadas) {
        this.partidas_ganadas = partidas_ganadas;
    }

    public void setPartidas_pendientes(HashSet<Partida> partidas_pendientes) {
        this.partidas_pendientes = partidas_pendientes;
    }

    public void setPartidas_perdidas(int partidas_perdidas) {
        this.partidas_perdidas = partidas_perdidas;
    }

    public void setSolicitudes_amigos_pendientes(ArrayList<Usuario> solicitudes_amigos_pendientes) {
        this.solicitudes_amigos_pendientes = solicitudes_amigos_pendientes;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public HashSet<Partida> getPartidas_completas() {
        return partidas_completas;
    }

    public HashSet<Partida> getPartidas_pendientes() {
        return partidas_pendientes;
    }

    public ArrayList<Usuario> getSolicitudes_amigos_pendientes() {
        return solicitudes_amigos_pendientes;
    }

    public int getPartidas_empatadas() {
        return partidas_empatadas;
    }

    public int getPartidas_ganadas() {
        return partidas_ganadas;
    }

    public int getPartidas_perdidas() {
        return partidas_perdidas;
    }

    public StringBuilder getMuro() {
        return muro;
    }
    
    public void invitarAmigo(Usuario u){
        //Bucle for que recorre el array de usuarios para encontrar el usuario al que se quiere invitar
        for (Usuario aux: users.getListaUsuarios()){
            if (u.getNombre().equals( aux.getNombre())){
                u.getSolicitudes_amigos_pendientes().add(this);
            }
        }

    }

    public void aceptarInvitacion(Usuario u){
        u.lista_amigos.add(this);
        this.lista_amigos.add(u);
        Iterator<Usuario> it = solicitudes_amigos_pendientes.iterator();
        boolean encontrado = false;
        Usuario usu = new Usuario();
        while(it.hasNext() && !encontrado){
            usu = it.next();
            if (usu.getNombre().equals(u.getNombre())) {
                solicitudes_amigos_pendientes.remove(usu);
                encontrado = true;
            }
        }
        System.out.println("El usuario " + u.getNombre() + " ha sido añadido a tu lista de amigos." );
    }

    public void rechazarInvitacion(Usuario u){
        Iterator<Usuario> it = solicitudes_amigos_pendientes.iterator();
        boolean encontrado = false;
        Usuario usu = new Usuario();
        while (it.hasNext() && !encontrado) {
            usu = it.next();
            if (usu.getNombre().equals(u.getNombre())) {
                solicitudes_amigos_pendientes.remove(usu);
                encontrado = true;
            }
        }

        System.out.println("Has rechazado la solicitud de amistad del usuario " + u.getNombre());

    }

    public void compartirPelicula (Pelicula p){
        p.compartir(lista_amigos);
    }

    public void compartirPelicula(Pelicula p, Usuario u){
        p.compartir(u);
    }

    public void compartirCritica(Critica c) {
        c.compartir(lista_amigos);
    }

    public void compartirCritica(Critica c, Usuario u){
        c.compartir(u);
    }

    public void compartirPartida(Partida pe){
        pe.compartir(lista_amigos);
    }

    public void compartirPartida(Partida pe, Usuario u){
        pe.compartir(u);
    }

    public void compartirTodo(){
        for(Pelicula p : films.getListaPeliculas()){
            p.compartir(lista_amigos);
            for (Critica c : p.getListaCriticas()) {
                c.compartir(lista_amigos);
            }
        }
        
        for (Partida p : partidas_completas) {
            p.compartir(lista_amigos);
        }
    }

    public void compartirTodo(Usuario u){
        for (Pelicula p : films.getListaPeliculas()) {
            p.compartir(u);
            for (Critica c : p.getListaCriticas()) {
                c.compartir(u);
            }
        }
        
        for (Partida p : partidas_completas) {
            p.compartir(u);
        }
    }

    public void añadirPelicula(Pelicula p, Peliculas films){
        films.getListaPeliculas().add(p);
    }

    public void añadirCritica(Critica c, Pelicula p){
        p.anadirCritica(c);
        setMuro(new StringBuilder(c.mostrarCritica()));
    }

    public Partida iniciarPartida(Usuario u){
        return new Partida(this, u, users, films);       
    }

    public void completarPartida (Partida p){}

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null) return false;
        if(o.getClass() != this.getClass()) return false;
        Usuario u = (Usuario) o;
        return (this.getNombre().equals(u.getNombre()));
    }

    @Override
    public int hashCode() {
        return this.getNombre().hashCode();
    }

    public void anadirPartidaPendiente(Partida p){
        partidas_pendientes.add(p);
    }
    
    public void anadirPartidaCompletada(Partida p){
        partidas_completas.add(p);
        if(p.getGanador().equals(this)){
            partidas_ganadas++;
        }
        else if(p.getGanador() == null){
            partidas_empatadas++;
        }
        else{
            partidas_perdidas++;
        }
    }

}
