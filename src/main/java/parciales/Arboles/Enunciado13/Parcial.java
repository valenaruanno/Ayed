/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Arboles.Enunciado13;

import java.util.List;
import java.util.LinkedList;
import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen
 */
public class Parcial {
    public Integer resolver (GeneralTree<Integer> arbol, int min, int max){
        Integer result = 0;
        if (!arbol.isEmpty()){
            List <Integer> datos = new LinkedList<Integer> ();
            resolver (arbol, datos, min, max);
            int suma = 0;
            for (int i = 0; i < datos.size(); i++)
                suma += datos.get(i);
            result = suma / datos.size();
        }
        return result;
    }
    
    private void resolver (GeneralTree<Integer> arbol, List<Integer> datos, int min, int max){
        List<GeneralTree<Integer>> children = arbol.getChildren();
        if (children.size() != 0){
            resolver (children.get(0), datos, min, max);
            if ((arbol.getData() <= max) && (min <= arbol.getData()))
                datos.add(arbol.getData());
            for (int i = 1; i < children.size(); i++)
                resolver (children.get(i), datos, min, max);
        }
    }
    
    public static void main (String [] args){
        
        GeneralTree<Integer> a4 = new GeneralTree<Integer> (10);
        a4.addChild(new GeneralTree<Integer> (22));
        a4.addChild(new GeneralTree<Integer> (2));
        //a4.addChild(new GeneralTree<Integer> (2));
        
        GeneralTree<Integer> a3 = new GeneralTree<Integer> (21);
        a3.addChild(a4);
        
        GeneralTree<Integer> a2 = new GeneralTree<Integer> (45);            //si le saco 3 corroboro que da 23 clavado
        a2.addChild(new GeneralTree<Integer> (8));
        
        GeneralTree<Integer> a1 = new GeneralTree<Integer> (1);
        a1.addChild(new GeneralTree<Integer> (6));
        a1.addChild(new GeneralTree<Integer> (0));
        
        GeneralTree<Integer> a = new GeneralTree<Integer> (20);
        a.addChild(a1);
        a.addChild(a2);
        a.addChild(a3);
        
        Parcial p = new Parcial ();
        System.out.println(p.resolver(a, 10, 50));
    }
}
