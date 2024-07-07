/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Arboles.Enunciado15;

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
            buscar (menor, mayor, arbol, lista, 0);
        return lista;
    }
    
    private void buscar (int menor, int mayor, GeneralTree<Integer> arbol, List<String> lista, int nivel){
        int niv = nivel + 1;
        List<GeneralTree<Integer>> children = arbol.getChildren();
        for (GeneralTree<Integer> child : children)
            buscar (menor, mayor, child, lista, niv);
        if (arbol.getData() >= menor && arbol.getData() <= mayor)
            lista.add(arbol.getData() + " nivel " + nivel);
    }
    
    public static void main (String [] args){
        
        
        GeneralTree<Integer> a3 = new GeneralTree<Integer> (4);
        a3.addChild(new GeneralTree<Integer> (11));
        a3.addChild(new GeneralTree<Integer> (-9));
        a3.addChild(new GeneralTree<Integer> (10));
        
        GeneralTree<Integer> a2 = new GeneralTree<Integer> (5);            
        a2.addChild(new GeneralTree<Integer> (-3));
        
        GeneralTree<Integer> a1 = new GeneralTree<Integer> (-7);
        a1.addChild(new GeneralTree<Integer> (2));
        a1.addChild(new GeneralTree<Integer> (6));
        
        GeneralTree<Integer> a = new GeneralTree<Integer> (-2);
        a.addChild(a1);
        a.addChild(a2);
        a.addChild(a3);
        
        Parcial p = new Parcial ();
        List<String> lista = p.resolver(5, 10, a);
        for (String num : lista)
            System.out.println(num.toString());
    }  
}
