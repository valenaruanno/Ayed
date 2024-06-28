/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Grafos.Enunciado3;

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
public class ParcialGrafo {
    
    public List<Control> traslado (Graph<Control> ciudad){
        List<Control> ruta = new LinkedList<Control> ();
        if (!ciudad.isEmpty())
            buscar (ciudad, ruta);
        return ruta;
    }
    
    private void buscar (Graph<Control> ciudad, List<Control> ruta){
        boolean [] marcas = new boolean [ciudad.getSize()];
        List<Vertex<Control>> vertices = ciudad.getVertices();
        Iterator<Vertex<Control>> it = vertices.iterator();
        Vertex<Control> inicio = null;
        boolean encontre = false;
        while ((it.hasNext()) && (inicio == null)){
            Vertex<Control> v = it.next();
            if (v.getData().getLugar().equals("Casa del intendente"));
                inicio = v;
        }
        if (inicio != null)
            encontre = dfs (ciudad, inicio, ruta, marcas);
    }
    
    private boolean dfs (Graph<Control> ciudad, Vertex<Control> v, List<Control> ruta, boolean [] marcas){
        ruta.add(v.getData());
        marcas [v.getPosition()] = true;
        boolean encontre = false;
        if (v.getData().getLugar().equals("Municipalidad"))
           encontre = true; 
        else {
            List<Edge<Control>> adyacentes = ciudad.getEdges(v);
            Iterator<Edge<Control>> it = adyacentes.iterator();
            while ((it.hasNext()) && (!encontre)){
                Edge<Control> ady = it.next();
                Vertex<Control> aux = ady.getTarget();
                if ((!marcas[aux.getPosition()]) && (ady.getWeight() != 1) && (aux.getData().getControlado() != "M"))
                    encontre = dfs (ciudad, aux, ruta, marcas);
            }
            if (!encontre)
                ruta.remove(ruta.size() -1);
        }
        return encontre;
    }
    
    public static void main(String args[]) {
        Graph<Control> grafo = new AdjListGraph<Control>();
        Vertex<Control> v1 = grafo.createVertex(new Control("Casa del Intendente", "no"));
        Vertex<Control> v2 = grafo.createVertex(new Control("3", "no"));
        Vertex<Control> v3 = grafo.createVertex(new Control("4", "M"));
        Vertex<Control> v4 = grafo.createVertex(new Control("2", "no"));
        Vertex<Control> v5 = grafo.createVertex(new Control("Municipalidad", "no"));
        Vertex<Control> v6 = grafo.createVertex(new Control("1", "no"));
        
        grafo.connect(v1, v2, 1);
        grafo.connect(v2, v1, 1);
        grafo.connect(v1, v3, 0);
        grafo.connect(v3, v1, 0);
        grafo.connect(v1, v4, 0);
        grafo.connect(v4, v1, 0);
        grafo.connect(v2, v5, 1);
        grafo.connect(v5, v2, 1);
        grafo.connect(v3, v5, 1);
        grafo.connect(v5, v3, 1);
        grafo.connect(v4, v6, 0);
        grafo.connect(v6, v4, 0);
        grafo.connect(v6, v5, 0);
        grafo.connect(v5, v6, 0);
        
        ParcialGrafo p = new ParcialGrafo();
        List<Control> lista = p.traslado(grafo);
        for (Control c: lista)
            System.out.println(c.getLugar());
    }
}
