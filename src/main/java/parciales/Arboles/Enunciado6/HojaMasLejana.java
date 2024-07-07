/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Arboles.Enunciado6;

import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen
 */
public class HojaMasLejana {
    public List<Integer> resolver (GeneralTree<Integer> arbol){
        List <Integer> camino = new LinkedList<Integer> ();
        if(!arbol.isEmpty()){
            List<Integer> caminoAct = new LinkedList<Integer> ();
            buscar (arbol, camino, caminoAct);
        }
        return camino;
    }
    
    public void buscar (GeneralTree<Integer> arbol, List<Integer> camino, List<Integer> caminoAct){
        caminoAct.add(arbol.getData());
        if(arbol.isLeaf()){
            if (caminoAct.size() > camino.size()){
                camino.clear();
                camino.addAll(caminoAct);
            }
        } else {
            List<GeneralTree<Integer>> children = arbol.getChildren();
            for (GeneralTree<Integer> child: children)
                buscar (child, camino, caminoAct);
        }
        caminoAct.remove(caminoAct.size() - 1);
    }
}
