/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Arboles.Enunciado11;

import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen
 */
public class Parcial {
    public List<GeneralTree<Integer>> resolver (GeneralTree<Integer> arbol){
        List<GeneralTree<Integer>> lista = new LinkedList<GeneralTree<Integer>> ();
        if (!arbol.isEmpty())
            resolver (arbol, lista);
        return lista;
    }
    
    private void resolver (GeneralTree<Integer> arbol, List<GeneralTree<Integer>> lista){
        if (!arbol.isLeaf()){
            List<GeneralTree<Integer>> children = arbol.getChildren();
            if (!children.isEmpty())
                resolver (children.get(0), lista);
            if (children.size() % 2 == 0)
                lista.add(arbol);
            for (int i = 1; i < children.size(); i++)
                resolver (children.get(i), lista);
        }
    }
    
    public static void main(String[] args) {
        List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(2));
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(7, subChildren1);
        List<GeneralTree<Integer>> subChildren2 = new LinkedList<GeneralTree<Integer>>();
        subChildren2.add(new GeneralTree<Integer>(-4));
        subChildren2.add(subAb1);
        subChildren2.add(new GeneralTree<Integer>(-6));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(3, subChildren2);
        
        List<GeneralTree<Integer>> subChildren3 = new LinkedList<GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(1));
        subChildren3.add(new GeneralTree<Integer>(-9));
        subChildren3.add(new GeneralTree<Integer>(10));
        //subChildren3.add(new GeneralTree<Integer>(5));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(5, subChildren3);
        
        List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
        arbol.add(a1);
        arbol.add(a2);
        GeneralTree<Integer> a = new GeneralTree<Integer>(-7, arbol);
        
        Parcial p = new Parcial();
        List<GeneralTree<Integer>> lis = p.resolver(a);
        for(GeneralTree<Integer> h: lis) {
            System.out.print(h.getData() + " ~ ");
        }
    }
}
