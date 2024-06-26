/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp5.ejercicio5;

import java.util.LinkedList;
import java.util.List;
import tp5.ayed2024.src.tp5.ejercicio1.Graph;
import tp5.ayed2024.src.tp5.ejercicio1.Vertex;
import tp5.ayed2024.src.tp5.ejercicio1.adjList.AdjListGraph;

/**
 *
 * @author valen aruanno
 */
public class mainEj5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Graph<Persona> red = new AdjListGraph<Persona>();
        Vertex<Persona> v1 = red.createVertex(new Persona ("empleado","e3","1y54"));
        Vertex<Persona> v2 = red.createVertex(new Persona ("jubilado","j4","c493"));
        Vertex<Persona> v3 = red.createVertex(new Persona ("jubilado","j5","c189"));
        Vertex<Persona> v4 = red.createVertex(new Persona ("jubilado","j2","c189"));
        Vertex<Persona> v5 = red.createVertex(new Persona ("jubilado","j3","1y54"));
        Vertex<Persona> v6 = red.createVertex(new Persona ("empleado","e2","1y54"));
        Persona per = new Persona ("empleado","e1","1y54");
        Vertex<Persona> v7 = red.createVertex(per);
        Vertex<Persona> v8 = red.createVertex(new Persona ("jubilado","j1","1y54"));
        
        red.connect(v1, v2);
        red.connect(v2, v1);
        red.connect(v1, v5);
        red.connect(v5, v1);
        red.connect(v2, v3);
        red.connect(v3, v2);
        red.connect(v2, v4);
        red.connect(v4, v2);
        red.connect(v3, v6);
        red.connect(v6, v3);
        red.connect(v4, v6);
        red.connect(v6, v4);
        red.connect(v5, v7);
        red.connect(v7, v5);
        red.connect(v6, v8);
        red.connect(v8, v6);
        red.connect(v7, v6);
        red.connect(v6, v7);
        
        List<Persona> listado = BancoItau.reparto(red, per, 2);
        
        for (Persona p: listado)
            System.out.println(p.getNombre());
        }
}

