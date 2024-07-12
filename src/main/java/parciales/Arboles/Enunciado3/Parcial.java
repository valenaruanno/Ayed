/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Arboles.Enunciado3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen
 */
public class Parcial {
    
    public static boolean esDeSeleccion (GeneralTree<Integer> arbol){
        boolean es = true;
        if (!arbol.isEmpty())
            es = chequear (arbol);
        return es;
    }
    
    private static boolean chequear (GeneralTree<Integer> arbol){
        boolean es = true;
        int min = 9999;
        if (!arbol.isLeaf()){
            List<GeneralTree<Integer>> children = arbol.getChildren();
            for (GeneralTree<Integer> child : children){
                if (child.getData() < min)
                    min = child.getData();
            }
            if (min == arbol.getData()){
                Iterator<GeneralTree<Integer>> it = children.iterator();
                while ((it.hasNext()) && (es)){
                    GeneralTree<Integer> aux = it.next();
                    es = chequear (aux);
                }
            } else 
                es = false;
        }
        return es;
    }
    
        public static void main(String args[]) {
        
        GeneralTree<Integer> hid = new GeneralTree<Integer> (12);
        hid.addChild(new GeneralTree<Integer> (12));
        hid.addChild(new GeneralTree<Integer> (21));
        hid.addChild(new GeneralTree<Integer> (30));
        
        GeneralTree<Integer> hii = new GeneralTree<Integer> (35);
        hii.addChild(new GeneralTree<Integer> (35));
            
        GeneralTree<Integer> hi = new GeneralTree<Integer> (12);
        hi.addChild(hii);
        hi.addChild(hid);
        
        GeneralTree<Integer> hd = new GeneralTree<Integer> (25);
        hd.addChild(new GeneralTree<Integer> (25));
            
        GeneralTree<Integer> a = new GeneralTree<Integer> (12);
        a.addChild(hi);
        a.addChild(hd);
        System.out.println(esDeSeleccion(a));
    }

}
