package practicapeliculas;

public class Pregunta{
    private int id;
    private Pelicula p;
    private int puntos_jugador_1;
    private int puntos_jugador_2;
    private int numero_pista = 0;
    private String respuesta;

    public Pregunta(int id, Peliculas films){
        Pelicula film;
        //do{
            film = films.peliculaAleatoria();
            this.p = film;
        //}while(film == null);
        
        this.id = id;
        switch (id){
            case 0: respuesta = p.getTitulo();
                break;
            case 1: respuesta = String.valueOf(p.getAno());
                break;
            case 2: respuesta = p.getGenero();
                break;
            case 3: respuesta = p.getDirector();
                break;
            case 4: respuesta = p.getActor();
                break;
            case 5: respuesta = p.getActriz();
                break;
        }
    }

    public String ofrecerNuevaPista(){          // boton de pista
        String pista = "Has alcanzado el número de pistas máximo.";       
        switch(numero_pista){
            case 0: if(id > 2) pista = ofrecerAno();
                    else pista = ofrecerGenero();
            break;
            case 1: if(id > 3 && id < 6) pista = ofrecerGenero();
                    else pista = ofrecerDirector();
            break;
            case 2: if(id > 4) pista = ofrecerDirector();
                    else pista = ofrecerActor();
            break;
            case 3: if(id > 5) pista = ofrecerActor();
                    else pista = ofrecerActriz();
            break;
        }       
        numero_pista++;
        return pista;
    }


    private String ofrecerAno(){
        return "Año: " + String.valueOf(p.getAno()) + "\n";
    }
    private String ofrecerTitulo(){
        return "Título: " + p.getTitulo() + "\n";
    }
    private String ofrecerGenero(){
        return "Género: " + p.getGenero() + "\n";
    }
    private String ofrecerActor(){
        return "Actor: " + p.getActor() + "\n";
    }
    private String ofrecerActriz(){
        return "Actriz: " + p.getActriz() + "\n";
    }
    private String ofrecerDirector(){
        return "Director: " + p.getDirector() + "\n";
    }

    @Override
    public String toString(){
        switch (id){
            case 0: return "¿Cómo se llama la película estrenada en el año " + p.getAno()+"?";
            case 1: return "¿En qué año se estrenó la película " + p.getTitulo() + "?";
            case 2: return "¿De qué género es la película " + p.getTitulo() + "?";
            case 3: return "¿Quién es el director de la película " + p.getTitulo() + "?";
            case 4: return "¿Quién es el actor protagonista de la película " + p.getTitulo() + "?";
            case 5: return "¿Quién es la actriz protagonista de la película " + p.getTitulo() + "?";
        }
        return null;
    }

    public void hacerPregunta(){
        System.out.println(this.toString());
        //Scanner sc = new Scanner(System.in);
        //String respuestaJugador = sc.nextLine();

    }

    public boolean comprobarRespuesta(String r){            // boton de contestar
        return r.equals(this.respuesta);
    }

    public int getNumero_pista() {
        return numero_pista;
    }
    
    public void incrementarNumeroPistas() {
        numero_pista++;
    }


    public int getPuntos_jugador_1() {
        return puntos_jugador_1;
    }

    public int getPuntos_jugador_2() {
        return puntos_jugador_2;
    }

    public void setPuntos_jugador_1(int puntos_jugador_1) {
        this.puntos_jugador_1 = puntos_jugador_1;
    }

    public void setPuntos_jugador_2(int puntos_jugador_2) {
        this.puntos_jugador_2 = puntos_jugador_2;
    }
}
