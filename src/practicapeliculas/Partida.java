/**
 * Carlos Sánchez Muñoz
 * Creado el 26/12/2018
 * Ultima actualizacion: 26/12/2018
 * Cambios: pequeños cambios
 * Versión 3
 */
package practicapeliculas;
import java.util.ArrayList;

public class Partida implements Compartible {

    private Pregunta p;
    private int identificador;
    private Usuario ganador;
    private String resultado_final;
    private int ptos_jugador1;
    private int ptos_jugador2;
    private Usuario j1;
    private Usuario j2;

    private Pregunta[] listaPreguntas = new Pregunta[6];

    public Partida(Usuario j1, Usuario j2, Usuarios users, Peliculas films){
        this.j1 = j1;
        this.j2 = j2;
        for(int i = 0; i < 6; i++){
            listaPreguntas[i] = new Pregunta(i, films);
        }

    }

    public void setPtos_jugador1(int ptos_jugador1) {
        this.ptos_jugador1 = ptos_jugador1;
    }

    public void setPtos_jugador2(int ptos_jugador2) {
        this.ptos_jugador2 = ptos_jugador2;
    }

    public int getPtos_jugador1() {
        return ptos_jugador1;
    }

    public int getPtos_jugador2() {
        return ptos_jugador2;
    }
    
    

    public Usuario getJ1() {
        return j1;
    }

    public Usuario getJ2() {
        return j2;
    }
    
    public void ponerEnPendientes(){
        j2.anadirPartidaPendiente(this);
    }
    
    public void finalizarPartida(){
        j1.anadirPartidaCompletada(this);
        j2.anadirPartidaCompletada(this);
    }
    
    
    public void crearVentana(){
        VentanaPreguntas ventanaPreguntas = new VentanaPreguntas();
        ventanaPreguntas.setPartida(this);
        ventanaPreguntas.setJugador(j1);
        ventanaPreguntas.setListaPreguntas(listaPreguntas);
        ventanaPreguntas.inicializar();
        ventanaPreguntas.setVisible(true);
    }

    public Usuario getGanador() {
        return ganador;
    }

    public Pregunta[] getListaPreguntas() {
        return listaPreguntas;
    }
    
    
    

    @Override
    public void compartir(Usuario u) {

    }

    @Override
    public void compartir(ArrayList<Usuario> usuarios) {

    }
    
    @Override
    public String toString(){
        return j1.getNombre() + "VS. " + j2.getNombre() + "\n" +
                "GANADOR: " + j1.getNombre() + "\n" + 
                "Puntos " + j1.getNombre() + ": " + ptos_jugador1 + "\n" +
                "Puntos " + j2.getNombre() + ": " + ptos_jugador2 + "\n";
    }
}
