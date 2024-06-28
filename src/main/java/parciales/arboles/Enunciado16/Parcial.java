/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.arboles.Enunciado16;

import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen
 */
public class Parcial {
    GeneralTree<Integer> arbol;

    public Parcial(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    
    
    public LinkedList<Integer> resolver (){
        LinkedList<Integer> lista = new LinkedList<Integer> ();
        if (!this.arbol.isEmpty())
            frontera (this.arbol, lista);
        return lista;
    }
    
    public void frontera (GeneralTree<Integer> arbol, LinkedList<Integer> lista){
        if (arbol.isLeaf()){
            if (arbol.getData() % 2 == 0)
                lista.add(arbol.getData());
        } else {
            List<GeneralTree<Integer>> children = arbol.getChildren();
            for (GeneralTree<Integer> child : children)
                frontera (child, lista);
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
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(5, subChildren3);
        
        List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
        arbol.add(a1);
        arbol.add(a2);
        GeneralTree<Integer> a = new GeneralTree<Integer>(-7, arbol);
        
        Parcial p = new Parcial(a);
        List<Integer> lis = p.resolver();
        System.out.println(lis);
    }
}
