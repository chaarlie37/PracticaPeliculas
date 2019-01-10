/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapeliculas;
import java.util.Comparator;

/**
 *
 * @author carlo
 */
public class OrdenItemPorcentaje implements Comparator<Item>{
    @Override
    public int compare(Item o1, Item o2){
        return ((int) (o2.getPorcentaje_victorias() - o1.getPorcentaje_victorias()));
    }
}
