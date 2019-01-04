package practicapeliculas;
public class Item {
    private String nombreUsuario;
    private int jugadas;
    private int ganadas;
    private int perdidas;
    private double porcentaje_victorias;
    private int ptos;

    // CONSTRUCTOR
    public Item (Usuario u){
        nombreUsuario = u.getNombre();
        jugadas = u.getPartidas_completas().size();  // tamaño del ArrayList
        ganadas = u.getPartidas_ganadas();
        perdidas = u.getPartidas_perdidas();

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

    //MÉTODOS
    private void porcentajeVictorias (){  //Metodo privado para calcular el porcentaje de victorias
        porcentaje_victorias = (double) (this.ganadas / this.jugadas) * 100;
    }

    public void detallePartidas(){ //No necesita introducir nombre por argumento por como está diseñado el constructor
        System.out.println("Usuario:" + getNombreUsuario());
        System.out.println("- Partidas jugadas:" + getJugadas());
        System.out.println("- Partidas ganadas: " + getGanadas());
        System.out.println("- Partidas perdidas:" + getPerdidas());
        System.out.println("- Porcentaje de victorias:" + getPorcentaje_victorias() );
    }

}