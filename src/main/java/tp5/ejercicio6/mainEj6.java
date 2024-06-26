/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp5.ejercicio6;
import java.util.List;
import javax.swing.SwingConstants;
import tp5.ayed2024.src.tp5.ejercicio1.Graph;
import tp5.ayed2024.src.tp5.ejercicio1.Vertex;
import tp5.ayed2024.src.tp5.ejercicio1.adjList.AdjListGraph;

/**
 *
 * @author valen aruanno
 */
public class mainEj6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Graph<String> bosque = new AdjListGraph<String> ();
        Vertex<String> cc = bosque.createVertex("Casa Caperucita");
        Vertex<String> c3 = bosque.createVertex("Claro3");
        Vertex<String> c1 = bosque.createVertex("Claro1");
        Vertex<String> c2 = bosque.createVertex("Claro2");
        Vertex<String> c4 = bosque.createVertex("Claro4");
        Vertex<String> c5 = bosque.createVertex("Claro5");
        Vertex<String> ca = bosque.createVertex("Casa Abuelita");
        
        bosque.connect(cc, c3, 4);
        bosque.connect(cc, c1, 3);
        bosque.connect(cc, c2, 4);
        bosque.connect(c3, c5, 15);
        bosque.connect(c1, c5, 3);
        bosque.connect(c1, c2, 4);
        bosque.connect(c2, c1, 4);
        bosque.connect(c2, c5, 11);
        bosque.connect(c2, c4, 10);
        bosque.connect(c5, ca, 4);
        bosque.connect(c4, ca, 9);
        
        BuscadorDeCaminos bus = new BuscadorDeCaminos (bosque);
        List<List<String>> caminos = bus.recorridosMasSeguros();
        
        for (List<String> camino : caminos)
            System.out.println(camino.toString());
    }
    
}
