package practicapeliculas;
import java.util.Comparator;

public class OrdenItemPorcentaje implements Comparator<Item>{
    @Override
    public int compare(Item o1, Item o2){
        return ((int) (o2.getPorcentaje_victorias() - o1.getPorcentaje_victorias()));
    }
}
