
package practicapeliculas;
import java.util.Comparator;

public class OrdenItemPuntos implements Comparator<Item>{
    @Override
    public int compare(Item o1, Item o2){
        return o2.getPtos() - o1.getPtos();
    }
}
