/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Grafos.ParcialNoviembre2022;

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
    
    public List<String> estadios (Graph<Estadios> mapaEstadios, String estadioOrigen, int cantKm){
        List<String> camino = new LinkedList<> ();
        if (!mapaEstadios.isEmpty())
            buscar (mapaEstadios, estadioOrigen, cantKm, camino);
        return camino;
    }
    
    private void buscar (Graph<Estadios> mapa, String origen, int km, List<String> camino){
        boolean[] marcas = new boolean [mapa.getSize()];
        List<String> caminoAct = new LinkedList<> ();
        List<Vertex<Estadios>> vertices = mapa.getVertices();
        Vertex<Estadios> v = null;
        Iterator<Vertex<Estadios>> it = vertices.iterator();
        while ((it.hasNext()) && (v == null)){
            Vertex<Estadios> aux = it.next();
            if (aux.getData().getNombre().equals(origen))
                v = aux;
        }
        if (v != null){
            dfs (mapa, v, km, camino, caminoAct, marcas);
        }
    }
    
    private void dfs (Graph<Estadios> mapa, Vertex<Estadios> punto, int km, List<String> camino, List<String> caminoAct,  boolean [] marcas){
        marcas [punto.getPosition()] = true;
        caminoAct.add(punto.getData().getNombre());
        List<Edge<Estadios>> adyacentes = mapa.getEdges(punto);
        for (Edge<Estadios> ady : adyacentes){
            Vertex<Estadios> v = ady.getTarget();
            if ((!marcas[v.getPosition()]) && (km - ady.getWeight() >= 0))
                dfs (mapa, v, km - ady.getWeight(), camino, caminoAct, marcas);
        }
        if (caminoAct.size() > camino.size()){
            camino.clear();
            camino.addAll(caminoAct);
        }
        marcas[punto.getPosition()] = false;
        caminoAct.remove (caminoAct.size() -1);
    }
    
    public static void main(String args[]) {
        Graph<Estadios> grafo = new AdjListGraph();
        Vertex<Estadios> v1 = grafo.createVertex(new Estadios("Jor", "AI BAYT STADIUM"));
        Vertex<Estadios> v2 = grafo.createVertex(new Estadios("Lusail", "LUSAIL STADIUM"));
        Vertex<Estadios> v3 = grafo.createVertex(new Estadios("Rayán", "EDUCATION CITY STADIUM"));
        Vertex<Estadios> v4 = grafo.createVertex(new Estadios("Rayán", "AL RAYYAN STADIUM"));
        Vertex<Estadios> v5 = grafo.createVertex(new Estadios("Doha", "STADIUM 947"));
        Vertex<Estadios> v6 = grafo.createVertex(new Estadios("Doha", "KHALIFA INTERNATIONAL STADIUM"));
        Vertex<Estadios> v7 = grafo.createVertex(new Estadios("Doha", "AL THUMAMA STADIUM"));
        Vertex<Estadios> v8 = grafo.createVertex(new Estadios("Wakrah", "AL JANOUB STADIUM"));
        
        grafo.connect(v1, v2, 42);
        grafo.connect(v2, v1, 42);
        grafo.connect(v2, v3, 24);
        grafo.connect(v3, v2, 24);
        grafo.connect(v2, v5, 52);
        grafo.connect(v5, v2, 52);
        grafo.connect(v3, v4, 11);
        grafo.connect(v4, v3, 11);
        grafo.connect(v4, v6, 8);
        grafo.connect(v6, v4, 8);
        grafo.connect(v6, v7, 12);
        grafo.connect(v7, v6, 12);
        grafo.connect(v7, v8, 12);
        grafo.connect(v8, v7, 12);
        grafo.connect(v8, v5, 19);
        grafo.connect(v5, v8, 19);
        
        Parcial p = new Parcial();
        
        System.out.println(p.estadios(grafo, "AI BAYT STADIUM", 100));
    }
}
