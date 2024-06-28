/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.arboles.BuscarHojaMasLejana;

import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen
 */
public class BuscarHojaMasLejana {
    
    public List<Integer> hojaMasLejana (GeneralTree<Integer> arbol){
        List<Integer> camino = new LinkedList<Integer> ();
        List<Integer> caminoAct = new LinkedList<Integer> ();
        if (!arbol.isEmpty())
            buscar (arbol, camino, caminoAct);
        return camino;
    }
    
    private void buscar (GeneralTree<Integer> arbol, List<Integer> camino, List<Integer> caminoAct){
        caminoAct.add(arbol.getData());
        if (arbol.isLeaf()){
            if (caminoAct.size() > camino.size()){
                camino.clear();
                camino.addAll(caminoAct);
            } 
        } else {
            List<GeneralTree<Integer>> children = arbol.getChildren();
            for (GeneralTree<Integer> child: children){
                buscar (child, camino, caminoAct);
            }
        }
        caminoAct.remove(caminoAct.size() - 1);
    }
    
     public static void main(String main[]) {
        List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(2));
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(7, subChildren1);
        
        List<GeneralTree<Integer>> subChildren2 = new LinkedList<GeneralTree<Integer>>();
        subChildren2.add(new GeneralTree<Integer>(4));
        subChildren2.add(subAb1);
        subChildren2.add(new GeneralTree<Integer>(6));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(3, subChildren2);
        
        List<GeneralTree<Integer>> subChildren3 = new LinkedList<GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(1));
        subChildren3.add(new GeneralTree<Integer>(9));
        subChildren3.add(new GeneralTree<Integer>(10));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(5, subChildren3);
        
        List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
        arbol.add(a1);
        arbol.add(a2);
        GeneralTree<Integer> a = new GeneralTree<Integer>(8, arbol);
        
        BuscarHojaMasLejana cam = new BuscarHojaMasLejana();
        System.out.println(cam.hojaMasLejana(a));
    }
}
