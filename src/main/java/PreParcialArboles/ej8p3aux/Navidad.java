/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreParcialArboles.ej8p3aux;

import java.util.Iterator;
import java.util.List;
import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen
 */
public class Navidad {
    private GeneralTree<Integer> arbol;

    public Navidad (GeneralTree<Integer> arbol){
        this.arbol = arbol;
    }

    public String esAbetoNavidenio (){
        return (!this.arbol.isEmpty()) ? chequear (this.arbol) : "no";
    }

    private String chequear (GeneralTree<Integer> arbol){
        String result = "si";
        int cant = 0;
        List<GeneralTree<Integer>> children = arbol.getChildren();
        for (GeneralTree<Integer> child : children){
            if (child.isLeaf())
                cant++;
        } 
        if (!(cant >= 3))
            result = "no";
        else{
            String resC = "si";
            Iterator<GeneralTree<Integer>> it = children.iterator();
            while (it.hasNext() && resC == "si"){
                GeneralTree<Integer> nextChild = it.next();
                if (!(nextChild.isLeaf()))
                    resC = chequear (nextChild);
            }
            result = resC;
        }
        return result;
    }
}
