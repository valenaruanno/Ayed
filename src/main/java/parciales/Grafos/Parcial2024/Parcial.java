/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Grafos.Parcial2024;

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
    
    public int resolver (Graph<Sitio> sitios, int tiempo){
        int cant = 0;
        if (!sitios.isEmpty())
            cant = buscar (sitios, tiempo);
        return cant;
    }
    
    private int buscar (Graph<Sitio> sitios, int tiempo){
        boolean [] marcas = new boolean [sitios.getSize()];
        int recoMax = 0;
        Vertex<Sitio> ver = null;
        List<Vertex<Sitio>> lista = sitios.getVertices();
            Iterator<Vertex<Sitio>> it = lista.iterator();
            while ((it.hasNext()) && (ver == null)){
                Vertex<Sitio> v = it.next();
                if (v.getData().getNombre() == "Entrada")
                    ver = v;
            }
            if (ver != null)
                recoMax = dfs (sitios, ver, tiempo, marcas, recoMax, 0);
        return recoMax;
    }
    
    private int dfs (Graph<Sitio> sitios, Vertex<Sitio> punto, int tiempo, boolean [] marcas, int recoMax, int reco){
        tiempo -= punto.getData().getTiempo();
        marcas [punto.getPosition()] = true;
        if (tiempo >= 0){
            reco++;
            if (reco > recoMax)
                recoMax = reco;
            List<Edge<Sitio>> adyacentes = sitios.getEdges(punto);
            for (Edge<Sitio> ady : adyacentes){
                Vertex<Sitio> v = ady.getTarget();
                if (!marcas[v.getPosition()] && tiempo - ady.getWeight() > 0)
                    recoMax = dfs (sitios, v, tiempo-= ady.getWeight() , marcas, recoMax, reco); 
            }
        }
        marcas[punto.getPosition()] = false;
        return recoMax;
    }
    
    public static void main(String args[]) {
        Graph<Sitio> grafo = new AdjListGraph<Sitio>();
        Vertex<Sitio> Entrada = grafo.createVertex(new Sitio("Entrada", 15));
        Vertex<Sitio> Cebras = grafo.createVertex(new Sitio("Cebras", 10));
        Vertex<Sitio> Tigres = grafo.createVertex(new Sitio("Tigres", 10));
        Vertex<Sitio> Flamencos = grafo.createVertex(new Sitio("Flamencos", 10));
        Vertex<Sitio> Murcielagos = grafo.createVertex(new Sitio("Murciélagos", 20));
        Vertex<Sitio> Wallabies = grafo.createVertex(new Sitio("Wallabies", 30));
        Vertex<Sitio> Tortugas = grafo.createVertex(new Sitio("Tortugas", 10));
        Vertex<Sitio> Pumas = grafo.createVertex(new Sitio("Pumas", 10));
        
        grafo.connect(Entrada, Cebras, 10);
        grafo.connect(Cebras, Entrada, 10);
        grafo.connect(Entrada, Tigres, 10);
        grafo.connect(Tigres, Entrada, 10);
        grafo.connect(Entrada, Murcielagos, 20);
        grafo.connect(Murcielagos, Entrada, 20);
        grafo.connect(Entrada, Flamencos, 25);
        grafo.connect(Flamencos, Entrada, 25);
        
        grafo.connect(Tigres, Cebras, 8);
        grafo.connect(Cebras, Tigres, 8);
        grafo.connect(Cebras, Tortugas, 10);
        grafo.connect(Tortugas, Cebras, 10);
        grafo.connect(Flamencos, Murcielagos, 25);
        grafo.connect(Murcielagos, Flamencos, 25);
        grafo.connect(Murcielagos, Wallabies, 10);
        grafo.connect(Wallabies, Murcielagos, 10);
        grafo.connect(Wallabies, Tortugas, 10);
        grafo.connect(Tortugas, Wallabies, 10);
        grafo.connect(Tortugas, Pumas, 15);
        grafo.connect(Pumas, Tortugas, 15);
        
        Parcial p = new Parcial();
        
        System.out.println(p.resolver(grafo, 100));
        System.out.println(p.resolver(grafo, 30));
    }
}
