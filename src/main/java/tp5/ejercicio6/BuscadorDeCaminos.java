/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp5.ejercicio6;

import java.util.LinkedList;
import java.util.List;
import tp5.ayed2024.src.tp5.ejercicio1.Edge;
import tp5.ayed2024.src.tp5.ejercicio1.Graph;
import tp5.ayed2024.src.tp5.ejercicio1.Vertex;

/**
 *
 * @author valen aruanno
 */
public class BuscadorDeCaminos {
    private Graph<String> bosque;

    public BuscadorDeCaminos(Graph<String> bosque) {
        this.bosque = bosque;
    }
    
    
    public List<List<String>> recorridosMasSeguros (){
        List<List<String>> caminos = new LinkedList<List<String>> ();
        if (!bosque.isEmpty())
            buscarCaminos (bosque, caminos);
        return caminos;
    }
    
    private List<List<String>> buscarCaminos (Graph<String> bosque, List<List<String>> caminos){
        boolean [] marcas = new boolean [bosque.getSize()];
        List<String> caminoAct = new LinkedList<String>();
        Vertex <String> inicio = bosque.search("Casa Caperucita");
        if (inicio != null)
            dfs (bosque, inicio, caminos, marcas, caminoAct);
        return caminos;
    }
    
    private void dfs (Graph<String> bosque, Vertex<String> v, List<List<String>> caminos, boolean [] marcas, List<String> caminoAct){
        caminoAct.add(v.getData());
        marcas [v.getPosition()] = true;
        if (v.getData().equals("Casa Abuelita"))
            caminos.add(new LinkedList<String> (caminoAct));
        else {
            List<Edge<String>> adyacentes = bosque.getEdges(v);
            for (Edge<String> ady : adyacentes){
                Vertex<String> ini = ady.getTarget();
                if ((!marcas[ini.getPosition()]) && (ady.getWeight() < 5))
                    dfs (bosque, ini, caminos, marcas, caminoAct);
            }
        }
        caminoAct.remove(caminoAct.size() -1);
        marcas[v.getPosition()] = false;
    }
}
