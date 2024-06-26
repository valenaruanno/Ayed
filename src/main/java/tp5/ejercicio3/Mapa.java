/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.ejercicio3;
import java.util.Iterator;
import tp5.ayed2024.src.tp5.ejercicio1.Graph;
import tp5.ayed2024.src.tp5.ejercicio1.Edge;
import tp5.ayed2024.src.tp5.ejercicio1.Vertex;
import java.util.List;
import java.util.LinkedList;
/**
 *
 * @author valen
 */
public class Mapa {
    private Graph <String> grafo;
    
    public Mapa (Graph <String> grafo){
        this.grafo = grafo;
    }
    
    public List <String> devolverCamino (String ciudad1, String ciudad2){
        List <String> camino = new LinkedList <String> ();
        buscarCamino (grafo, ciudad1, ciudad2, camino);
        return camino;
    }
    
    private void buscarCamino (Graph<String> grafo, String ciudad1, String ciudad2, List<String> camino){
        boolean[] marca = new boolean [grafo.getSize()];
        Vertex<String> origen = grafo.search(ciudad1);
        boolean ok;
        if (!origen.equals(null)){
            ok = dfs (grafo, origen, ciudad2, camino, marca);
        }
    }
    
    private boolean dfs (Graph<String> grafo, Vertex<String> v, String ciudad2, List<String> camino, boolean [] marca){
        boolean ok = false; 
        marca[v.getPosition()] = true;
        camino.add(v.getData());
        if (v.getData() == ciudad2){
            ok = true;
        }else {
            List <Edge<String>> adyacentes = grafo.getEdges (v);
            Iterator <Edge<String>> it = adyacentes.iterator();
            while ((it.hasNext()) && (ok == false)){
                Vertex <String> destino = it.next().getTarget();    //obtengo el objeto al que apunta la arista y lo guardo en una variable vertice
                if (!marca[destino.getPosition()])                  // le pido la posicion al vertice y si no esta marcada llamo al dfs
                    ok = dfs (grafo, destino, ciudad2, camino, marca);
            }
            if (ok = false)
                camino.remove(v);
        }
        
        return ok;
    }
    
    public List<String> devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades){
        List <String> camino = new LinkedList<String> ();
        buscarCaminoExceptuando (grafo, ciudad1, ciudad2, ciudades, camino);
        return camino;
    }
    
    private void buscarCaminoExceptuando (Graph<String> grafo, String ciudad1, String ciudad2, List<String> ciudades, List<String> camino){
        boolean [] marca = new boolean [grafo.getSize()];
        boolean ok = false;
        Vertex<String> v = grafo.search(ciudad1);
        if (!v.equals(null)){
            ok = dfs2 (grafo, v, ciudad2, ciudades, camino, marca);
        }
    }
    
    private boolean dfs2 (Graph<String> grafo, Vertex<String> v, String ciudad2, List<String> ciudades, List<String> camino, boolean [] marca){
        boolean ok = false;
        boolean esta = false;
        if (v.getData() == ciudad2){
            camino.add(v.getData());
            ok = true;
        }else{
            camino.add(v.getData());
            marca[v.getPosition()] = true;
            List <Edge<String>> adyacentes = grafo.getEdges(v);
            Iterator <Edge<String>> it = adyacentes.iterator();
            while ((it.hasNext()) && (ok == false)){
                Vertex<String> destino = it.next().getTarget();
                if (!marca[destino.getPosition()]){
                    int i = 0;
                    while ((i < ciudades.size()) && (esta == false)){
                        if (ciudades.get(i).equals(destino.getData()))
                            esta = true;
                        i++;
                    }
                    if (ok == false)
                        dfs2 (grafo, destino, ciudad2, ciudades, camino, marca);
                }
            }
            if (ok == false)
                camino.remove(v);
        }
        return ok;
    }
    
    public List<String> caminoMasCorto (String ciudad1, String ciudad2){
        List<String> caminoAct = new LinkedList <String> ();
        List<String> camino = new LinkedList <String> ();
        if (!grafo.isEmpty()){
            buscarCaminoCorto (grafo, ciudad1, ciudad2, caminoAct, camino);
        }
        return camino;
    }
    
    private void buscarCaminoCorto (Graph<String> grafo, String ciudad1, String ciudad2, List<String> caminoAct, List<String> camino){
        boolean [] marca = new boolean [grafo.getSize()];
        int min = 9999;
        Vertex<String> v = grafo.search(ciudad1);
        if (!v.getData().equals(null))
            min = buscar (grafo, v, ciudad2, caminoAct, camino, marca, min);
    }
    
    private int buscar (Graph<String> grafo, Vertex<String> destino, String ciudad2, List<String> caminoAct, List<String> camino, boolean [] marca, int min){
        caminoAct.add(destino.getData());
        marca[destino.getPosition()] = true;
        if (destino.getData() == ciudad2){
            if (caminoAct.size() < min){
                min = caminoAct.size();
                camino.removeAll(camino);
                camino.addAll(caminoAct);
            }
        } else{
            List<Edge<String>> adyacentes = grafo.getEdges(destino); 
            for (Edge<String> ady: adyacentes){
                Vertex<String> v = ady.getTarget();
                if (!(marca[v.getPosition()]))
                    min = buscar (grafo, v, ciudad2, caminoAct, camino, marca, min);
            }
        }
        marca[destino.getPosition()] = false;
        caminoAct.remove(destino.getData());
        return min;
    }
    
    public List<String> caminoSinCargarCombustible (String ciudad1, String ciudad2, int tanqueAuto){
        List<String> camino = new LinkedList<String> ();
        if (!grafo.isEmpty())
            caminoSinCargar(grafo, ciudad1, ciudad2, tanqueAuto, camino);
        return camino;
    }
    
    private List<String> caminoSinCargar (Graph<String> grafo,String ciudad1, String ciudad2, int tanqueAuto, List<String> camino){
        boolean [] marca = new boolean [grafo.getSize()];
        Vertex<String> origen = grafo.search(ciudad1);
        boolean ok = false;
        if ((origen != null))
            ok = dfsSinCargar(grafo, origen, ciudad2, tanqueAuto, camino, marca, ok);
        return camino;
    }
    
    private boolean dfsSinCargar (Graph<String> grafo, Vertex<String> origen, String ciudad2, int tanqueAuto, List<String> camino, boolean [] marca, boolean ok){
        marca[origen.getPosition()] = true;
        camino.add(origen.getData());
        if (origen.getData() == ciudad2){
            ok = true;
        }else {
            List<Edge<String>> adyacentes = grafo.getEdges(origen);
            Iterator<Edge<String>> it = adyacentes.iterator();
            
            while ((it.hasNext()) && (!ok)){
                Vertex<String> v = it.next().getTarget();
                if ((!marca[v.getPosition()]) && (tanqueAuto - it.next().getWeight() > 0))
                    ok = dfsSinCargar (grafo, v, ciudad2, tanqueAuto - it.next().getWeight(), camino, marca, ok);
            }
            if (!ok){
                camino.remove(camino.size() - 1);
            }
        }
        marca[origen.getPosition()] = true;
        return ok;
    }
}
