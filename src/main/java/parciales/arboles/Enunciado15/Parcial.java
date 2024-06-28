/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.arboles.Enunciado15;

import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen
 */
public class Parcial {
    
    public List<String> resolver (int menor, int mayor, GeneralTree<Integer> arbol){
        List<String> lista = new LinkedList<String> ();
        if (!arbol.isEmpty())
            llenar (menor, mayor, arbol, lista, 0);
        return lista;
    }
    
    private void llenar (int menor, int mayor, GeneralTree<Integer> arbol, List<String> lista, int nivel){
        List<GeneralTree<Integer>> children = arbol.getChildren();
        for (GeneralTree<Integer> child: children)
            llenar (menor, mayor, child, lista, nivel++);
        if ((arbol.getData() >= menor) && (arbol.getData() <= mayor))
            lista.add (arbol.getData() + " es de nivel " + nivel);
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
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(5, subChildren3);
        
        List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
        arbol.add(a1);
        arbol.add(a2);
        GeneralTree<Integer> a = new GeneralTree<Integer>(-7, arbol);
        
        Parcial p = new Parcial();
        List<String> lis = p.resolver(5, 10, a);
        for (String s: lis)
            System.out.println(s);
    }
}
