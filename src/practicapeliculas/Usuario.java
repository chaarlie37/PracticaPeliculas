/**
 * Lidia Hernandez Calvo
 * Creado el 26/12/2018
 * Ultima actualizacion: 30/12/2018
 * Cambios: (Por Carlos Sánchez Muñoz) pequeños cambios y añadidos más constructores
 * Version:3 
 * 
 */
package practicapeliculas;

import java.util.ArrayList;
import java.util.HashSet;

public class Usuario{
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
    private ArrayList <Critica> listaCriticas = new ArrayList<>();
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
    /*
    public void invitarAmigo(Usuario u, Usuarios users){
        //Bucle for que recorre el array de usuarios para encontrar el usuario al que se quiere invitar
        for (Usuario aux: users.getListaUsuarios()){
            if (u.getNombre().equals( aux.getNombre())){
                u.getSolicitudes_amigos_pendientes().add(this);
            }
        }

    }
*/
    public void aceptarInvitacion(Usuario u){
        u.lista_amigos.add(this);
        this.lista_amigos.add(u);
        for(Usuario usu: u.getSolicitudes_amigos_pendientes()){
            if (this.nombre.equals(usu.getNombre())){
                u.getSolicitudes_amigos_pendientes().remove(usu);
            }
        }
        System.out.println("El usuario " + u.getNombre() + " ha sido añadido a tu lista de amigos." );
    }

    public void rechazarInvitacion(Usuario u){
        for(Usuario usu: u.getSolicitudes_amigos_pendientes()){
            if (this.nombre.equals(usu.getNombre())){
                u.getSolicitudes_amigos_pendientes().remove(usu);
            }
        }

        System.out.println("Has rechazado la solicitud de amistad del usuario " + u.getNombre());

    }

    public void compartirPelicula (Pelicula p){
        StringBuilder texto = new StringBuilder(p.toString()); // Asi transformamos string en stringbuildr que es lo que necesitamos
        for (Usuario usu:  lista_amigos) {
            usu.setMuro(texto);
        }
    }

    public void compartirPelicula(Pelicula p, Usuario u){
        StringBuilder texto = new StringBuilder(p.toString());
        for (Usuario usu: lista_amigos ){
            if (usu.getNombre().equals(u.getNombre())){
                u.setMuro(texto);
            }
        }
    }

    public void compartirCritica(Critica c) {
        StringBuilder texto = new StringBuilder(c.toString()); // Asi transformamos string en stringbuildr que es lo que necesitamos
        for (Usuario usu:  lista_amigos) {
            usu.setMuro(texto);
        }
        this.setMuro(texto);
    }

    public void compartirCritica(Critica c, Usuario u){
        StringBuilder texto = new StringBuilder(c.toString());
        for (Usuario usu: lista_amigos ){
            if (usu.getNombre().equals(u.getNombre())){
                u.setMuro(texto);
            }
        }
    }

    public void compartirPartida(Partida p){


    }

    public void compartirPartida(Partida p, Usuario u){

    }

    public void compartirTodo(){}

    public void compartirTodo(Usuario u){}

    public void añadirPelicula(Pelicula p, Peliculas films){
        films.getListaPeliculas().add(p);
    }

    public void añadirCritica(Critica c){
        this.listaCriticas.add(c);
    }

    public void iniciarPartida(Usuario u){
        Partida partida = new Partida(this, u, users, films);
        partida.crearVentana();
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
        else if(p.getPtos_jugador1() == p.getPtos_jugador2()){
            partidas_empatadas++;
        }
        else{
            partidas_perdidas++;
        }
    }

}
