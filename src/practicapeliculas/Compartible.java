package practicapeliculas;
import java.util.ArrayList;

public interface Compartible {
    void compartir(Usuario u);
    void compartir(ArrayList<Usuario> usuarios);
}
