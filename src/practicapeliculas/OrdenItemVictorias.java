
package practicapeliculas;
import java.util.Comparator;


public class OrdenItemVictorias implements Comparator<Item>{
    @Override
    public int compare(Item o1, Item o2) {
        return (o2.getGanadas() - o1.getGanadas());
    }
}
