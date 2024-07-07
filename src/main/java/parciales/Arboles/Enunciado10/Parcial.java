/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Arboles.Enunciado10;

import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen
 */
public class Parcial {
    public int resolver (GeneralTree<Integer> arbol){
        int resultado = 0;
        if (!arbol.isEmpty()){
            List<Integer> lista = new LinkedList<Integer> ();
            calcular (arbol, lista);
            System.out.println (lista.size());
            if (lista.size() % 2 == 0){
                resultado = buscarPositivos (lista);
            } else {
                resultado = buscarNegativos (lista);
            }
        }
        return resultado;
    }
    
    private void calcular (GeneralTree<Integer> arbol, List<Integer> lista){
        List<GeneralTree<Integer>> children = arbol.getChildren();
        if (!children.isEmpty())
            calcular (children.get(0), lista);
        lista.add(arbol.getData());
        for (int i = 1; i < children.size(); i++)
            calcular (children.get(i), lista);
    }
    
    private int buscarPositivos (List<Integer> lista){
        int cant = 0;
        for (Integer num : lista){
            if (num > 0)
                cant++;
        }
        return cant;
    }
    
    private int buscarNegativos (List<Integer> lista){
        int cant = 0;
        for (Integer num : lista){
            if (num < 0)
                cant++;
        }
        return cant;
    }
    
    public static void main(String[] args) {
        List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(2));
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(7, subChildren1);
        List<GeneralTree<Integer>> subChildren2 = new LinkedList<GeneralTree<Integer>>();
        //subChildren2.add(new GeneralTree<Integer>(-4));
        subChildren2.add(subAb1);
        subChildren2.add(new GeneralTree<Integer>(-6));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(3, subChildren2);
        
        List<GeneralTree<Integer>> subChildren3 = new LinkedList<GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(1));
        subChildren3.add(new GeneralTree<Integer>(-9));
        subChildren3.add(new GeneralTree<Integer>(10));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(5, subChildren3);
        
        List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
        arbol.add(a1);
        arbol.add(a2);
        GeneralTree<Integer> a = new GeneralTree<Integer>(-7, arbol);
        
        Parcial p = new Parcial();
        System.out.println(p.resolver(a));
    }
}
