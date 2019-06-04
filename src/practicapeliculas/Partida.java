package practicapeliculas;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;

public class Partida implements Compartible, Serializable {

    private static int contadorPartidas;
    private Pregunta preguntaActual;
    private int identificador;
    private Usuario ganador;
    private String resultado_final;
    private int ptos_jugador1;
    private int ptos_jugador2;
    private int puntosTotales;
    private Usuario j1;
    private Usuario j2;
    private Pregunta[] listaPreguntas = new Pregunta[6];
    private int contadorPreguntas;

    public Partida(Usuario j1, Usuario j2, Usuarios users, Peliculas films){
        this.j1 = j1;
        this.j2 = j2;
        for(int i = 0; i < 6; i++){
            listaPreguntas[i] = new Pregunta(i, films);
        }
        contadorPreguntas = 0;
        preguntaActual = listaPreguntas[contadorPreguntas];
        puntosTotales = 0;
        contadorPartidas++;
        identificador = contadorPartidas;
        ptos_jugador1 = 0;
        ptos_jugador2 = 0;
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
        if(ptos_jugador1 > ptos_jugador2){
            ganador = j1;
        }else if (ptos_jugador1 < ptos_jugador2){
            ganador = j2;
        }else{
            ganador = null;
        }
        j1.anadirPartidaCompletada(this);
        j2.anadirPartidaCompletada(this);
        generarResultadoFinal();
    }
    
    public Usuario getGanador() {
        return ganador;
    }

    public Pregunta[] getListaPreguntas() {
        return listaPreguntas;
    }

    public void setPreguntaActual(Pregunta p) {
        this.preguntaActual = p;
    }

    public Pregunta getPreguntaActual() {
        return preguntaActual;
    }
    
    public String ofrecerNuevaPregunta() {
        contadorPreguntas++;
        preguntaActual = listaPreguntas[contadorPreguntas];
        return preguntaActual.toString();
    }
    
    public void setContadorPreguntasACero(){
        contadorPreguntas = 0;
        preguntaActual = listaPreguntas[contadorPreguntas];
        ptos_jugador2 = 0;
    }

    public int getIdentificador() {
        return identificador;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public void setPuntosTotales(int puntosTotales) {
        this.puntosTotales = puntosTotales;
    }

    public void setResultado_final(String resultado_final) {
        this.resultado_final = resultado_final;
    }

    public void setContadorPreguntas(int contadorPreguntas) {
        this.contadorPreguntas = contadorPreguntas;
    }

    public int getContadorPreguntas() {
        return contadorPreguntas;
    }
   
    public void actualizarPuntos(int jugador){
        if (jugador == 1) {
            ptos_jugador1 += preguntaActual.getPuntos_jugador_1();
        } else if (jugador == 2) {
            ptos_jugador2 += preguntaActual.getPuntos_jugador_2();
        }
    }
    

    @Override
    public void compartir(Usuario u) {
        StringBuilder texto = new StringBuilder(this.getResultado_final());
        u.setMuro(texto);
    }

    @Override
    public void compartir(ArrayList<Usuario> usuarios) {
        StringBuilder texto = new StringBuilder(this.getResultado_final());
        Iterator<Usuario> it = usuarios.iterator();
        while (it.hasNext()) {
            it.next().setMuro(texto);
        }
    }
    
    @Override
    public String toString(){
        return j1.getNombre() + " (ID: " + identificador + ")";
    }
    
    public void generarResultadoFinal(){
        resultado_final = j1.getNombre() + " VS. " + j2.getNombre() + "\n" +
                            "GANADOR: " + ganador.getNombre() + "\n" + 
                            "Puntos " + j1.getNombre() + ": " + ptos_jugador1 + "\n" +
                            "Puntos " + j2.getNombre() + ": " + ptos_jugador2 + "\n";
    }

    public String getResultado_final() {
        generarResultadoFinal();
        return resultado_final;
    }
    
    
}
