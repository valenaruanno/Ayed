/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Arboles.Parcial2024Tema1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen
 */
public class Parcial {
    private GeneralTree<Integer> arbol;
    
    public Parcial (GeneralTree<Integer> arbol){
        this.arbol = arbol;
    }
    
    public List<Integer> camino (int num){
        List<Integer> camino = new LinkedList<Integer> ();
        boolean cumple;
        if (!this.arbol.isEmpty())
            cumple = buscar (this.arbol, num, camino);
        return camino;
    }
    
    private boolean buscar (GeneralTree<Integer> arbol, int num, List<Integer> camino){
        boolean cumple = false;
        camino.add(arbol.getData());
        if (arbol.isLeaf()){
            cumple = true;
        } else {
            List<GeneralTree<Integer>> children = arbol.getChildren();
            if (children.size() >= num){
                Iterator<GeneralTree<Integer>> it = children.iterator();
                while ((it.hasNext()) && (!cumple)){
                    GeneralTree<Integer> child = it.next();
                    cumple = buscar (child, num, camino);
                }
            }
        }
        if (!cumple)
            camino.remove(camino.size() - 1);
        return cumple;
    } 
    
    public static void main(String args[]) {
        GeneralTree<Integer> arbol = new GeneralTree<Integer>(10);
        
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(5);
        subAb1.addChild(new GeneralTree<Integer>(-6));
        GeneralTree<Integer> subAb2 = new GeneralTree<Integer>(22);
        subAb2.addChild(new GeneralTree<Integer>(28));
        subAb2.addChild(new GeneralTree<Integer>(55));
        subAb2.addChild(new GeneralTree<Integer>(18));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(8);
        a1.addChild(subAb1);
        a1.addChild(subAb2);
        
        arbol.addChild(a1);
        arbol.addChild(new GeneralTree<Integer>(42));
        
        GeneralTree<Integer> subAb3 = new GeneralTree<Integer>(19);
        subAb3.addChild(new GeneralTree<Integer>(4));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(-5);
        a2.addChild(subAb3);
        a2.addChild(new GeneralTree<Integer>(-9));
        
        arbol.addChild(a2);
        
        Parcial p = new Parcial(arbol);
        
        System.out.println(p.camino(2));
        System.out.println(p.camino(3));
    }
}
