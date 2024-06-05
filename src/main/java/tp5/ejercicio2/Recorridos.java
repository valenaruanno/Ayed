/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.ejercicio2;
import java.util.List;
import java.util.LinkedList;
import tp5.ayed2024.src.tp5.ejercicio1.Graph;
import tp5.ayed2024.src.tp5.ejercicio1.Vertex;
import tp1.Ej8.Queue;
import tp5.ayed2024.src.tp5.ejercicio1.Edge;
/**
 *
 * @author valen
 */
public class Recorridos {
    public List<Vertex<T>> dfs (Graph <T> grafo){
        LinkedList <Vertex<T>> lista = new LinkedList <Vertex<T>> ();
        boolean [] marca = new boolean [grafo.getSize()];
        for (int i = 0; i < grafo.getSize (); i++){
            if (!marca[i])
                dfs (i, grafo, marca, lista);      //mando a hacer el recorrido con grafo.getVertex(i).getData()
        }
        return lista;
    }
    
    private LinkedList<Vertex<T>> dfs (int i, Graph <T> grafo, boolean [] marca, LinkedList <Vertex<T>> lista){
        marca[i] = true;
        Vertex <T> v = grafo.getVertex(i);
        lista.add(v.getData());
        List <Edge<T>> adyacentes = grafo.getEdges(v); 
        for (Edge <T> e: adyacentes){
            int j = e.getTarget().getPosition();
            if (!marca[j]){
                dfs (j, grafo, marca, lista);
            }
        }
        return lista;
    }
    
    public LinkedList <T> bfs (Graph <T> grafo){
        LinkedList <T> lista = new LinkedList <T> ();
        boolean [] marca = new boolean [grafo.getSize()];
        for (int i= 0; i < grafo.getSize(); i++){
            if (!marca[i])
                bfs (i, grafo, marca, lista);
        }
        
        return lista;
    }
    
    private List<T> bfs (int i, Graph <T> grafo, boolean [] marca, LinkedList <T> lista){
        Queue <Vertex<T>> cola = new Queue <Vertex<T>> ();
        marca [i] = true;
        cola.enQueue(grafo.getVertex(i));
        int j;
        while (!cola.isEmpty()){
            Vertex <T> aux = cola.deQueue();
            if (!aux.equals(null)){
                lista.add(aux.getData());
                List <Edge<T>> adyacentes = grafo.getEdges(aux);
                for (Edge<T> e : adyacentes)
                    j = e.getTarget.getPosition();
                    if (marca[j] = false){
                        marca [j] = true;
                        cola.enQueue(e.getTarget());
                    }
                }
            }
        return lista;
    } 
}
    

