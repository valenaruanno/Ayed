/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Grafos.ParcialGrafosSimulacro;

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
    public List<String> resolver (Graph<Ciudad> mapa, String ciudad, int cantDias){
        Vertex<Ciudad> v = null;
        boolean [] marcas = new boolean [mapa.getSize()];
        List <String> camino = new LinkedList<String> ();
        List<String> caminoAct = new LinkedList<String>();
        if (!mapa.isEmpty())
            v = buscar (mapa, ciudad);
            if ((v != null))
                dfs (mapa, v, cantDias, marcas, camino, caminoAct);
        return camino;
    }
    
    private Vertex<Ciudad> buscar (Graph<Ciudad> mapa, String ciudad){
        Vertex<Ciudad> v = null;
        boolean ok = false;
        List<Vertex<Ciudad>> ver = mapa.getVertices();
        Iterator<Vertex<Ciudad>> it = ver.iterator();
        while ((it.hasNext()) && (v == null)){
            Vertex<Ciudad> aux = it.next();
            if (aux.getData().getNombre().equals(ciudad))
                v = aux;
        }
        return v;
    }
    
    private void dfs (Graph<Ciudad> mapa, Vertex<Ciudad> inicio, int cantDias, boolean [] marcas, List<String> camino, List<String> caminoAct){
        caminoAct.add(inicio.getData().getNombre());
        marcas[inicio.getPosition()] = true;
        if (cantDias == 0){
            if (caminoAct.size() > camino.size()){
                camino.clear();
                camino.addAll( caminoAct);
            }
        } else {
            List<Edge<Ciudad>> adyacentes = mapa.getEdges(inicio);
            for (Edge<Ciudad> ady : adyacentes){
                Vertex<Ciudad> v = ady.getTarget();
                if ((!marcas[v.getPosition()]) &&(cantDias - v.getData().getCantDias() >= 0))
                    dfs (mapa, v, cantDias - v.getData().getCantDias(), marcas, camino, caminoAct);
            }
        }
        caminoAct.remove(caminoAct.size() - 1);
        marcas [inicio.getPosition()] = false;
    }
    public static void main(String args[]) {
        Graph<Ciudad> mapa = new AdjListGraph<Ciudad>();
        Vertex<Ciudad> MarDelPlata = mapa.createVertex(new Ciudad(7, "Mar Del Plata"));
        Vertex<Ciudad> Pila = mapa.createVertex(new Ciudad(1, "Pila"));
        Vertex<Ciudad> Dolores = mapa.createVertex(new Ciudad(1, "Dolores"));
        Vertex<Ciudad> Chascomus = mapa.createVertex(new Ciudad(1, "Chascomús"));
        Vertex<Ciudad> MarAzul = mapa.createVertex(new Ciudad(3, "Mar Azul"));
        Vertex<Ciudad> Pinamar = mapa.createVertex(new Ciudad(4, "Pinamar"));
        Vertex<Ciudad> Madariaga = mapa.createVertex(new Ciudad(1, "Madariaga"));
        Vertex<Ciudad> LaPlata = mapa.createVertex(new Ciudad(5, "La Plata"));
        Vertex<Ciudad> LasGaviotas = mapa.createVertex(new Ciudad(1, "Las Gaviotas"));
        Vertex<Ciudad> Querandi = mapa.createVertex(new Ciudad(1, "Querandi"));
        Vertex<Ciudad> Hudson = mapa.createVertex(new Ciudad(1, "Hudson"));
        
        mapa.connect(MarDelPlata, Pila);
        mapa.connect(Pila, MarDelPlata);
        mapa.connect(Pila, Dolores);
        mapa.connect(Dolores, Pila);
        mapa.connect(Dolores, Chascomus);
        mapa.connect(Chascomus, Dolores);
        
        mapa.connect(MarDelPlata, MarAzul);
        mapa.connect(MarAzul, MarDelPlata);
        mapa.connect(MarAzul, Pinamar);
        mapa.connect(Pinamar, MarAzul);
        mapa.connect(Pinamar, Madariaga);
        mapa.connect(Madariaga, Pinamar);
        mapa.connect(Dolores, Madariaga);
        mapa.connect(Madariaga, Dolores);
        mapa.connect(Madariaga, LaPlata);
        mapa.connect(LaPlata, Madariaga);
        mapa.connect(Chascomus, LaPlata);
        mapa.connect(LaPlata, Chascomus);
        
        mapa.connect(MarAzul, LasGaviotas);
        mapa.connect(LasGaviotas, MarAzul);
        mapa.connect(MarAzul, Querandi);
        mapa.connect(Querandi, MarAzul);
        mapa.connect(LaPlata, Hudson);
        mapa.connect(Hudson, LaPlata);
        
        Parcial p = new Parcial();
        System.out.println(p.resolver(mapa, "Mar Del Plata", 15));
    }
}
