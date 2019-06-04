package practicapeliculas;
import java.lang.Comparable;

public class Item implements Comparable{
    private String nombreUsuario;
    private int jugadas;
    private int ganadas;
    private int perdidas;
    private double porcentaje_victorias;
    private int ptos = 0;

    // CONSTRUCTOR
    public Item (Usuario u){
        nombreUsuario = u.getNombre();
        jugadas = u.getPartidas_completas().size();  // tamaño del ArrayList
        ganadas = u.getPartidas_ganadas();
        perdidas = u.getPartidas_perdidas();
        porcentaje_victorias = porcentajeVictorias();
        for(Partida p : u.getPartidas_completas()){
            if(p.getJ1().equals(u)){
                ptos += p.getPtos_jugador1();
            }else{
                ptos += p.getPtos_jugador2();
            }
        }
    }

    // GET Y SET
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getJugadas() {
        return jugadas;
    }

    public void setJugadas(int jugadas) {
        this.jugadas = jugadas;
    }

    public int getGanadas() {
        return ganadas;
    }

    public void setGanadas(int ganadas) {
        this.ganadas = ganadas;
    }

    public int getPerdidas() {
        return perdidas;
    }

    public void setPerdidas(int perdidas) {
        this.perdidas = perdidas;
    }

    public double getPorcentaje_victorias() {
        return porcentaje_victorias;
    }

    public int getPtos() {
        return ptos;
    }

    public void setPtos(int ptos) {
        this.ptos = ptos;
    }
    
    

    //MÉTODOS
    private double porcentajeVictorias(){  //Metodo privado para calcular el porcentaje de victorias
        double resultado = 0;
        if(this.jugadas != 0){
            resultado = (double) (this.ganadas / this.jugadas) * 100;
        }
        return resultado;
    }
    @Override
    public String toString(){
        return getNombreUsuario();
    }
    
    public String fila(){
        return (getNombreUsuario() + "           " + getJugadas() + "           " + getGanadas() + "           " + getPerdidas() + "           " + getPorcentaje_victorias() + "           " + ptos);
    }
    
    @Override
    public int compareTo(Object o){
        Item i = (Item) o;
        return this.nombreUsuario.compareTo(i.getNombreUsuario());
    }

    public String detallePartidas(Usuarios users){
        String s = "";
        Usuario u = users.bucarUsuario(nombreUsuario);
        for(Partida p : u.getPartidas_completas()){
            s += p.getResultado_final() + "\n";
        }
        return s;
    }
}