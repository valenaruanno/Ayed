/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Arboles.Enunciado14;

import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen
 */
public class Parcial {
    
    public List<Numero> resolver (int valor, GeneralTree<Integer> arbol){
        List<Numero> datos = new LinkedList<Numero> ();
        if (!arbol.isEmpty())
            resolver (valor, arbol, datos, 0);
        System.out.println (datos.size() > 0);
        return datos;
    }
    
    private void resolver (int valor, GeneralTree<Integer> arbol, List<Numero> datos, int nivel){
        int nivelH = nivel + 1;
        List<GeneralTree<Integer>> children = arbol.getChildren();
        if (children.size() != 0)
            resolver (valor, children.get(0), datos, nivelH);
        if (arbol.getData() > valor){
            Numero num = new Numero (arbol.getData(), nivel);
            datos.add(num);
        }
        for (int i = 1; i < children.size(); i++)
            resolver (valor, children.get(i), datos, nivelH);
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
        List<Numero> lista = p.resolver(5, a);
        for (Numero num : lista)
            System.out.println(num.toString());
    }
}
