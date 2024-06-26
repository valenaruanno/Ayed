/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp5.ejercicio4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tp5.ayed2024.src.tp5.ejercicio1.Edge;
import tp5.ayed2024.src.tp5.ejercicio1.Graph;
import tp5.ayed2024.src.tp5.ejercicio1.Vertex;

/**
 *
 * @author valen aruanno
 */
public class VisitaOslo {
    
    public static List<String> paseoEnBici (Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos){
        List<String> camino = new LinkedList<String> ();
        if (!lugares.isEmpty())
            comienzo (lugares, destino, maxTiempo, lugaresRestringidos, camino);
        return camino;
    }
    
    
    private static List<String> comienzo (Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos, List<String> camino){
        boolean ok = false;
        boolean [] marcas = new boolean [lugares.getSize()];
        Vertex<String> partida = lugares.search("Ayuntamiento");
        if (partida != null)
            ok = dfs (lugares, partida, destino, maxTiempo, lugaresRestringidos, camino, ok, marcas);
        return camino;
    }
    
    private static boolean dfs (Graph<String> lugares, Vertex<String> partida, String destino, int maxTiempo, List<String> lugaresRestringidos, List<String> camino, boolean ok, boolean [] marcas){
        marcas[partida.getPosition()] = true;
        camino.add(partida.getData());
        if (partida.getData() == destino)
            ok = true;
        else{
            List<Edge<String>> adyacentes = lugares.getEdges(partida);
            Iterator<Edge<String>> it = adyacentes.iterator();
            
            while ((it.hasNext()) && (!ok)){
                Edge<String> edge = it.next();
                Vertex<String> v = edge.getTarget();
                if ((!marcas[v.getPosition()]) && (maxTiempo - edge.getWeight() > 0) && (!lugaresRestringidos.contains(edge.getTarget().getData())))
                    ok = dfs (lugares, v, destino, maxTiempo - edge.getWeight(), lugaresRestringidos, camino, ok, marcas);
            }
            if (!ok)
                camino.remove(camino.size() -1);
        }
        marcas[partida.getPosition()] = false;
        return ok;
    }
}
