/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Arboles.Enunciado9;

import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen
 */
public class Parcial {
    public int resolver (GeneralTree<Integer> arbol){
        int respuesta = 0;
        List<Integer> lista = new LinkedList<Integer> ();
        if (!arbol.isEmpty()){
            respuesta = resolver (arbol, lista);
            System.out.println(respuesta);
            if (respuesta % 2 == 0){
                respuesta = 0;
                respuesta = sumarPositivos(lista);
            } else{
                respuesta = 0;
                respuesta = sumarNegativos(lista);
            } 
        }
        return respuesta;
    }
    
    private int resolver (GeneralTree<Integer> arbol, List<Integer> lista){
        int suma = 0;
        List<GeneralTree<Integer>> children = arbol.getChildren();
        for (GeneralTree<Integer> child : children)
            suma += resolver (child, lista);
        suma += arbol.getData();
        lista.add(arbol.getData());
        return suma;
    }
    
    private int sumarPositivos(List<Integer> lista){
        int suma = 0;
        for (Integer num : lista){
            if (num > 0)
                suma += num;
        }
        return suma;
    }
    
    private int sumarNegativos(List<Integer> lista){
        int suma = 0;
        for (Integer num : lista){
            if (num < 0)
                suma += num;
        }
        return suma;
    }
    
    public static void main(String[] args) {
        List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(2));
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(7, subChildren1);
        List<GeneralTree<Integer>> subChildren2 = new LinkedList<GeneralTree<Integer>>();
        subChildren2.add(new GeneralTree<Integer>(-4));
        subChildren2.add(subAb1);
        subChildren2.add(new GeneralTree<Integer>(-6));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(4, subChildren2);
        
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
