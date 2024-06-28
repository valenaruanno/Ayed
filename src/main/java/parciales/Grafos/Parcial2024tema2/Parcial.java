/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Grafos.Parcial2024tema2;

import java.util.Iterator;
import java.util.List;
import tp5.ayed2024.src.tp5.ejercicio1.Edge;
import tp5.ayed2024.src.tp5.ejercicio1.Graph;
import tp5.ayed2024.src.tp5.ejercicio1.Vertex;

/**
 *
 * @author valen
 */
public class Parcial {
    
    public String resolver (Graph<Sitio> sitios, int tiempo){
        String ok = "No alcanzable";
        if (!sitios.isEmpty())
            ok = buscar (sitios, tiempo, ok);
        return ok;
    }
    
    private String buscar (Graph<Sitio> sitios, int tiempo, String ok){
        boolean[] marcas = new boolean [sitios.getSize()];
        int cant = 0;
        List<Vertex<Sitio>> lista = sitios.getVertices();
        Iterator<Vertex<Sitio>> it = lista.iterator();
        Vertex<Sitio> inicio = null;
        while ((it.hasNext()) && (inicio == null)){
            Vertex<Sitio> aux =it.next();
            if (aux.getData().getNombre().equals("Entrada"))
                inicio = aux;
        }
        if (inicio != null)
            ok = dfs (sitios, inicio, tiempo, marcas, "Alcanzable");
        return ok;
    }
    
    private String dfs (Graph<Sitio> sitios, Vertex<Sitio> ini, int tiempo, boolean [] marcas, String ok){
        marcas[ini.getPosition()] = true;
        tiempo -= ini.getData().getTiempo();
        if (tiempo < 0)
            ok = "No alcanzable";
        else {
            List<Edge<Sitio>> adyacentes = sitios.getEdges(ini);
            Iterator<Edge<Sitio>> it = adyacentes.iterator();
            while ((it.hasNext()) && (ok != "No alcanzable")){
                Edge<Sitio> ady = it.next();
                Vertex<Sitio> aux = ady.getTarget();
                if (tiempo - ady.getWeight() > 0){
                    if (!marcas[aux.getPosition()])
                        ok = dfs (sitios, aux, tiempo - ady.getWeight(), marcas, ok);
                } else 
                    ok = "No alcanzable";
            }
        }
        return ok;
    }
}
