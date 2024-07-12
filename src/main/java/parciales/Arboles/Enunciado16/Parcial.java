/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Arboles.Enunciado16;

import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen
 */
public class Parcial {
    private GeneralTree<Integer> arbol;

    public Parcial(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    
    public LinkedList<Integer> resolver (){
        LinkedList<Integer> lista = new LinkedList<Integer> ();
        if (!this.arbol.isEmpty())
            resolver (this.arbol, lista);
        return lista;
    }
    
    private void resolver (GeneralTree<Integer> arbol, LinkedList<Integer> lista){
        if (arbol.isLeaf() && (arbol.getData() % 2 == 0))
            lista.add(arbol.getData());
        else {
            List<GeneralTree<Integer>> children = arbol.getChildren();
            for (GeneralTree<Integer> child : children)
                resolver (child, lista);
        }
    }
}
