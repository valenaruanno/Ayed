/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Grafos.GrafosEnunciado1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tp5.ayed2024.src.tp5.ejercicio1.Edge;
import tp5.ayed2024.src.tp5.ejercicio1.Graph;
import tp5.ayed2024.src.tp5.ejercicio1.Vertex;
import tp5.ayed2024.src.tp5.ejercicio1.adjList.AdjListGraph;

/**
 *
 * @author valen
 */
public class Parcial {
    public List<Ciudad> resolver (Graph<Ciudad> ciudades, String origen, String destino){
        List<Ciudad> camino = new LinkedList<Ciudad> ();
        if (!ciudades.isEmpty())
            buscar (ciudades, origen, destino, camino);
        return camino;
    }
    
    private void buscar (Graph<Ciudad> ciudades, String origen, String destino, List<Ciudad> camino){
        boolean [] marcas = new boolean [ciudades.getSize()];
        Vertex<Ciudad> o = null;
        Vertex<Ciudad> d = null;
        boolean encontre = false;
        List<Vertex<Ciudad>> vertices = ciudades.getVertices();
        Iterator<Vertex<Ciudad>> it = vertices.iterator();
        while ((it.hasNext()) && ((o == null) || (d == null))){
            Vertex<Ciudad> ver = it.next();
            if (ver.getData().getNombre() == origen)
                o = ver;
            if (ver.getData().getNombre() == destino)
                d = ver;
        }
        if ((o != null) && (d != null))
            encontre = buscarCamino (ciudades, o, destino, camino, marcas);
    }
    
    private boolean buscarCamino (Graph<Ciudad> ciudades, Vertex<Ciudad> origen, String destino, List<Ciudad> camino, boolean [] marcas){
        marcas[origen.getPosition()] = true;
        camino.add(origen.getData());
        boolean ok = false;
        if (origen.getData().getNombre() == destino){
            ok = true;
        } else {
            List<Edge<Ciudad>> adyacentes = ciudades.getEdges(origen);
            Iterator<Edge<Ciudad>> it = adyacentes.iterator();
            while ((it.hasNext()) && (!ok)){
                Vertex<Ciudad> v = it.next().getTarget();
                if ((!marcas[v.getPosition()]) && (v.getData().getFase() != "1"))
                    ok = buscarCamino (ciudades, v, destino, camino, marcas);
            }
            if (!ok){
                camino.remove(camino.size() - 1);
            }
        }
        return ok;
    }
    
    public static void main(String args[]) {
        Graph<Ciudad> grafo = new AdjListGraph<Ciudad>();
        //Descarte Saladillo, Lobos y Pinamar
        Vertex<Ciudad> v1 = grafo.createVertex(new Ciudad("Suipacha", "Fase 5"));
        Vertex<Ciudad> v2 = grafo.createVertex(new Ciudad("Carlos Keen", "Fase 3"));
        Vertex<Ciudad> v3 = grafo.createVertex(new Ciudad("Moreno", "Fase 1"));
        Vertex<Ciudad> v4 = grafo.createVertex(new Ciudad("Quilmes", "Fase 1"));
        Vertex<Ciudad> v5 = grafo.createVertex(new Ciudad("Navarro", "Fase 4"));
        Vertex<Ciudad> v6 = grafo.createVertex(new Ciudad("Cañuelas", "Fase 3"));
        Vertex<Ciudad> v7 = grafo.createVertex(new Ciudad("Abasto", "Fase 2"));
        Vertex<Ciudad> v8 = grafo.createVertex(new Ciudad("La Plata", "Fase 2"));
        
        grafo.connect(v1, v2);
        grafo.connect(v2, v1);
        grafo.connect(v2, v3);
        grafo.connect(v3, v2);
        grafo.connect(v3, v4);
        grafo.connect(v4, v3);
        grafo.connect(v1, v5);
        grafo.connect(v5, v1);
        grafo.connect(v5, v6);
        grafo.connect(v6, v5);
        grafo.connect(v6, v7);
        grafo.connect(v7, v6);
        grafo.connect(v7, v3);
        grafo.connect(v3, v7);
        grafo.connect(v7, v8);
        grafo.connect(v8, v7);
        grafo.connect(v8, v4);
        grafo.connect(v4, v8);
        
        Parcial p = new Parcial();
        List<Ciudad> lista = p.resolver(grafo, "La Plata", "Carlos Keen");
        for (Ciudad c: lista)
            System.out.println(c.getNombre());
    }
}
