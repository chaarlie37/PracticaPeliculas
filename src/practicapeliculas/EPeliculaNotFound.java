package practicapeliculas;
public class EPeliculaNotFound extends Exception{
    public EPeliculaNotFound(){
        super();
    }
    public EPeliculaNotFound(String msg){
        super(msg);
    }
}
