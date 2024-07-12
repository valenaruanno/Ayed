/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Arboles;

import java.util.LinkedList;
import java.util.List;
import tp1.Ej8.Queue;
import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen
 */
public class Parcial2024Tema2 {
    private GeneralTree<Integer> arbol;
    
    public Parcial2024Tema2 (GeneralTree<Integer> arbol){
        this.arbol = arbol;
    }
    
    public List<Integer> nivel (int num){
        Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>> ();
        cola.enQueue(this.arbol);
        cola.enQueue(null);
        List<Integer> lista = new LinkedList<Integer> ();
        boolean esta = false;
        boolean cumple = true;
        GeneralTree<Integer> aux = new GeneralTree<Integer> ();
        while ((!cola.isEmpty()) && (!esta)){
            aux = cola.deQueue();
            if ( aux != null){
                lista.add(aux.getData());
                List<GeneralTree<Integer>> children = aux.getChildren();
                for (GeneralTree<Integer> child : children)
                    cola.enQueue(child);
                System.out.println("La cantidad de hijos que posee el nodo es :" + children.size());
                if (children.size() < num)
                    cumple = false;
            } else {
                if (cumple)
                    esta = true;
                else {
                    lista.clear();
                    if ((!cola.isEmpty()) && (!esta)){
                        cola.enQueue(null);
                        cumple = true;
                    }
                }
            }
        }
        return lista;
    }
    
    public static void main(String[] args) {
        List<GeneralTree<Integer>> children1 = new LinkedList<GeneralTree<Integer>>();
        children1.add(new GeneralTree<Integer>(-6));
        children1.add(new GeneralTree<Integer>(2));
        children1.add(new GeneralTree<Integer>(8));
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(5, children1);
        
        List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
        children2.add(new GeneralTree<Integer>(28));
        children2.add(new GeneralTree<Integer>(55));
        children2.add(new GeneralTree<Integer>(18));
        GeneralTree<Integer> subAb2 = new GeneralTree<Integer>(22, children2);
        
        List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
        children3.add(new GeneralTree<Integer>(4));
        children3.add(new GeneralTree<Integer>(2));
        children3.add(new GeneralTree<Integer>(8));
        GeneralTree<Integer> subAb3 = new GeneralTree<Integer>(19, children3);
        
        List<GeneralTree<Integer>> children4 = new LinkedList<GeneralTree<Integer>>();
        children4.add(subAb1);
        children4.add(subAb2);
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(8, children4);
        
        List<GeneralTree<Integer>> children5 = new LinkedList<GeneralTree<Integer>>();
        children5.add(subAb3);
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(-5, children5);
        
        List<GeneralTree<Integer>> ab = new LinkedList<GeneralTree<Integer>>();
        ab.add(a1);
        ab.add(a2);
        GeneralTree<Integer> a = new GeneralTree<Integer>(10, ab);
        
        Parcial2024Tema2 p = new Parcial2024Tema2(a);
        
        System.out.println(p.nivel(4));
        //System.out.println(p.nivel(4));
        
    }
}
