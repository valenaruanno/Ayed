/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Arboles.Enunciado8;

import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen
 */
public class Parcial {
    public int resolver (GeneralTree<Integer> arbol){
        int max = -1;
        if (!arbol.isEmpty())
            max = buscar (arbol, max);
        return max;
    }
    
    private int buscar (GeneralTree<Integer> arbol, int max){
        List<GeneralTree<Integer>> children = arbol.getChildren();
        for (GeneralTree<Integer> child : children)
            max = buscar (child,max);
        if (arbol.getData() > max)
            max = arbol.getData();
        return max;
    }
    
    public static void main(String[] args) {
        List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(3));
        subChildren1.add(new GeneralTree<Integer>(1));

        List<GeneralTree<Integer>> subChildren2 = new LinkedList<GeneralTree<Integer>>();
        subChildren2.add(new GeneralTree<Integer>(2));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(6, subChildren1);
        
        GeneralTree<Integer> a5 = new GeneralTree<Integer> (1);
        a5.addChild(new GeneralTree<Integer> (8));
        a5.addChild(new GeneralTree<Integer> (22));
        a5.addChild(new GeneralTree<Integer> (9));
        
        List<GeneralTree<Integer>> subChildren3 = new LinkedList<GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(20));
        subChildren3.add(a5);

        GeneralTree<Integer> a2 = new GeneralTree<Integer>(31, subChildren3);
        
        GeneralTree<Integer> a4 = new GeneralTree<Integer> (9);
        a4.addChild(new GeneralTree<Integer> (4));
        
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(5);
        a3.addChild(a4);
        
        List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
        arbol.add(a1);
        arbol.add(a2);
        arbol.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>(2, arbol);
        
        Parcial r = new Parcial();
        System.out.println(r.resolver(a));
    }
}
