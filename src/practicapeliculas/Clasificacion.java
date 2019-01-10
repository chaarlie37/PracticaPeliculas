package practicapeliculas;

import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

public class Clasificacion{
    
    private ArrayList<Item> listaItems;
    private Usuarios users;
    
    public Clasificacion(Usuarios users){
        listaItems = new ArrayList<>();
        this.users = users;
        for (Usuario u : users.getListaUsuarios()) {
            Item i = new Item(u);
            listaItems.add(i);        
        }
        Collections.sort(listaItems);
    }
    
    public void actualizar(){
        listaItems.clear();
        for (Usuario u : users.getListaUsuarios()) {
            Item i = new Item(u);
            listaItems.add(i);
            Collections.sort(listaItems);
        }
    }

    public void ordenarVictorias(){
        Collections.sort(listaItems, new OrdenItemVictorias());
    }

    public void ordenarPorcentaje(){
        Collections.sort(listaItems, new OrdenItemPorcentaje());
        //Collections.sort(listaItems);
    }

    public void ordenarPuntos(){
        Collections.sort(listaItems, new OrdenItemPuntos());
    }

    public void volcarTXT(String ruta) throws IOException{     // se ha cambiado por la ruta para adaptarlo al JFileChooser
        try{
            FileWriter fw = new FileWriter(ruta);
            BufferedWriter b = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(b);
            pw.println("USUARIO    PJ       PG         PP          %V              PT"); 
            pw.println("__________________________________________________");
            for (Item i : listaItems) {
                pw.println(i.fila());
                pw.println("__________________________________________________");
            }
            pw.println("");
            pw.println("PJ: Partidas jugadas   PG: Partidas ganadas   PP: Partidas perdidas    %V: Porcentaje de victorias   PT: Puntos totales");
            b.close();
        }catch(IOException e){e.getMessage();};
        
    }

    public ArrayList<Item> getListaItems() {
        return listaItems;
    }

    @Override
    public String toString(){
        String s = "USUARIO    PJ       PG         PP          %V              PT\n__________________________________________________\n";
        for(Item i : listaItems){
            s += "\n" + i.fila()+ "\n__________________________________________________";
        }
        s += "\nPJ: Partidas jugadas   PG: Partidas ganadas   PP: Partidas perdidas    %V: Porcentaje de victorias   PT: Puntos totales";
        return s;
    }
}
