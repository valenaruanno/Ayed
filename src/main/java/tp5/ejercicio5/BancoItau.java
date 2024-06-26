/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp5.ejercicio5;

import java.util.LinkedList;
import java.util.List;
import tp5.ayed2024.src.tp5.ejercicio1.Edge;
import tp5.ayed2024.src.tp5.ejercicio1.Graph;
import tp5.ayed2024.src.tp5.ejercicio1.Vertex;

/**
 *
 * @author valen aruanno
 */
public class BancoItau {
    
    public static List<Persona> reparto (Graph <Persona> grafo, Persona empleado, int gradoMax){
        List<Persona> listado = new LinkedList<Persona> ();
        if (!grafo.isEmpty())
            buscarEmple (grafo, empleado, gradoMax, listado);
        return listado;
    }
    
    private static List<Persona> buscarEmple (Graph<Persona> grafo, Persona empleado, int gradoMax, List<Persona> listado){
        Vertex <Persona> v = grafo.search(empleado);
        boolean [] marcas = new boolean [grafo.getSize()];
        if (v != null){
            System.out.println("Arranco desde " + v.getData().getNombre());
                dfs (grafo, v, gradoMax, listado, marcas, 0); 
        }
        return listado;
    }
    
    private static void dfs (Graph<Persona> grafo, Vertex<Persona> v, int gradoMax, List<Persona> listado, boolean [] marcas, int grado){
        marcas [v.getPosition()] = true;
        System.out.println("grado = " + grado);
        if ((v.getData().getTipo() == "jubilado") && (listado.size() < 40)){
            listado.add(v.getData());
            System.out.println("Agregue a " + v.getData().getNombre());
        } else 
            System.out.println("No agregue a " + v.getData().getNombre());
        grado++;
        List<Edge<Persona>> adyacentes = grafo.getEdges(v);
        for (Edge<Persona> ady : adyacentes){
            v = ady.getTarget();
            if ((!marcas[v.getPosition()]) && (grado <= gradoMax))
                dfs (grafo, v, gradoMax, listado, marcas, grado);
        }
    }
}
