/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.arboles.Parcial2024tema1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen
 */
public class ParcialArboles {
    GeneralTree<Integer> arbol;

    public ParcialArboles(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public List<Integer> camino (int num){
        List<Integer> camino = new LinkedList<Integer> ();
        boolean cumple = false;
        if (!this.arbol.isEmpty())
            cumple = busqueda (this.arbol, num, camino, cumple);
        return camino;
    }
    
    private boolean busqueda (GeneralTree<Integer> arbol, int num, List<Integer> camino, boolean cumple){
        camino.add(arbol.getData());
        if (arbol.isLeaf())
            cumple = true;
        else {
            List<GeneralTree<Integer>> children = arbol.getChildren();
            if (children.size() >= num){
                Iterator<GeneralTree<Integer>> it = children.iterator();
                while ((it.hasNext()) && (!cumple)){
                    GeneralTree<Integer> aux = it.next();
                    cumple = busqueda (aux, num, camino, cumple);
                }
            }
        }
        if (!cumple)
            camino.remove(camino.size() -1);
        return cumple;
    }
}
