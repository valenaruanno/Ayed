import tp1.Ej8.Queue;
import tp5.ayed2024.src.tp5.ejercicio1.Edge;
import tp5.ayed2024.src.tp5.ejercicio1.Graph;
import tp5.ayed2024.src.tp5.ejercicio1.Vertex;
import java.util.Iterator;
import java.util.List;

public class Virus {
    public int infeccion (Graph<Computadora> empresa){
        boolean visitado[] = new boolean [empresa.getSize()];
        int minutos = 0;
        if (!empresa.isEmpty()){
            Vertex<Computadora> origen = buscar (empresa);
            if (origen != null)
                minutos = bfs (empresa, origen, visitado);

        }
        return minutos;
    } 

    private Vertex<Computadora> buscar (Graph<Computadora> empresa){
        List<Vertex<Computadora>> lista = empresa.getVertices();
        Iterator<Vertex<Computadora>> it = lista.iterator();
        Vertex<Computadora> aux = null;
        while (it.hasNext() && aux== null){
            Vertex<Computadora> v = it.next();
            if (v.getData().getEstaInfectado())
                aux = v;
        }
        return aux;
    }

    private int bfs (Graph<Computadora> empresa, Vertex<Computadora> origen, boolean [] visitado){
        int minutos = 0;
        Queue<Vertex<Computadora>> cola = new Queue<Vertex<Computadora>> ();
        cola.enQueue(origen);
        cola.enQueue(null);
        visitado [origen.getPosition()] = true;
        Vertex<Computadora> v;
        while (!cola.isEmpty()){
            v = cola.deQueue();
            if (v != null){
                List<Edge<Computadora>> aristas = empresa.getEdges(v);
                for (Edge<Computadora> a : aristas){
                    Vertex<Computadora> ver = a.getTarget();
                    if (!visitado[ver.getPosition()]){
                        visitado[ver.getPosition()] = true;
                        cola.enQueue(ver);
                        ver.getData().setEstaInfectado(true);
                    }
                }
            } else {
                if(!cola.isEmpty()){
                    minutos++;
                    cola.enQueue(null);
                }
            }
        }
        return minutos;
    }
}