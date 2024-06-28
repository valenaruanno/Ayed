/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.arboles.Parcial2024;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tp1.Ej8.Queue;
import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen
 */
public class ParcialArboles {
    private GeneralTree<Integer> arbol;

    public ParcialArboles(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    
    public List<Integer> nivel (int num){
        List<Integer> lista = new LinkedList<Integer> ();
        Queue <GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>> ();
        cola.enQueue(arbol);
        cola.enQueue(null);
        GeneralTree<Integer> aux = new GeneralTree<Integer> ();
        boolean cumple = false;
        boolean ok = true;
        while((!cola.isEmpty()) && (!cumple)){
           aux = cola.deQueue();
           if (aux != null){
                List<GeneralTree<Integer>> children = aux.getChildren();
                for (GeneralTree<Integer> child : children){
                    cola.enQueue(child);
                    List<GeneralTree<Integer>> hijos = child.getChildren();
                    if (hijos.size() != num)
                        ok = false;
                    else 
                        lista.add(child.getData());
                }
            } else {
                if (ok)
                    cumple = true;
                else {
                    if (!cola.isEmpty()){
                        cola.enQueue(null);
                        lista.clear();
                        ok = true;
                    }
                }
            }
        }
       return lista;
    }
    
    
}
