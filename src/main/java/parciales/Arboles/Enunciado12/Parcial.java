/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Arboles.Enunciado12;

import java.util.LinkedList;
import java.util.List;
import tp1.Ej8.Queue;
import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen
 */
public class Parcial {
    public int resolver (GeneralTree<Integer> arbol){
        int result = 0;
        if (!arbol.isEmpty()){
            List<Integer> datos = new LinkedList<Integer> ();
            Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>> ();
            cola.enQueue(arbol);
            cola.enQueue(null);
            GeneralTree<Integer> aux = new GeneralTree<Integer> ();
            while (!cola.isEmpty()){
                aux = cola.deQueue();
                if (aux != null){
                    datos.add(aux.getData());
                    List<GeneralTree<Integer>> children = aux.getChildren();
                    for (GeneralTree<Integer> child : children)
                        cola.enQueue(child);
                } else {
                    if (!cola.isEmpty()){
                        cola.enQueue(null);
                        datos.clear();
                    }
                }
            }
            result = datos.get(0);
            for (int i = 1; i < datos.size(); i++)
                result = result * datos.get(i);
        }
        return result;
    }
    
    public static void main (String [] args){
        
        GeneralTree<Integer> a4 = new GeneralTree<Integer> (10);
        a4.addChild(new GeneralTree<Integer> (22));
        a4.addChild(new GeneralTree<Integer> (2));
        //a4.addChild(new GeneralTree<Integer> (2));
        
        GeneralTree<Integer> a3 = new GeneralTree<Integer> (21);
        a3.addChild(a4);
        
        GeneralTree<Integer> a2 = new GeneralTree<Integer> (45);
        a2.addChild(new GeneralTree<Integer> (8));
        
        GeneralTree<Integer> a1 = new GeneralTree<Integer> (1);
        a1.addChild(new GeneralTree<Integer> (6));
        a1.addChild(new GeneralTree<Integer> (0));
        
        GeneralTree<Integer> a = new GeneralTree<Integer> (20);
        a.addChild(a1);
        a.addChild(a2);
        a.addChild(a3);
        
        Parcial p = new Parcial ();
        System.out.println(p.resolver(a));
    }
}