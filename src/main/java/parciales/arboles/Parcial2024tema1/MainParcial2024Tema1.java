/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.arboles.Parcial2024tema1;

import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen
 */
public class MainParcial2024Tema1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneralTree<Integer> hid = new GeneralTree<Integer> (22);
        hid.addChild(new GeneralTree<Integer> (28));
        hid.addChild(new GeneralTree<Integer> (55));
        hid.addChild(new GeneralTree<Integer> (18));
        
        GeneralTree<Integer> hii = new GeneralTree<Integer> (5);
        hii.addChild(new GeneralTree<Integer> (6));
        
        GeneralTree<Integer> hi = new GeneralTree<Integer> (8);
        hi.addChild(hii);
        hi.addChild(hid);
        
        GeneralTree<Integer> hdi = new GeneralTree<Integer> (19);
        hdi.addChild(new GeneralTree<Integer> (4));
        
        GeneralTree<Integer> hd = new GeneralTree<Integer> (-5);
        hd.addChild (hdi);
        hd.addChild (new GeneralTree<Integer> (-9));
        
        GeneralTree<Integer> arbol = new GeneralTree<Integer> (10);
        arbol.addChild(hi);
        arbol.addChild(new GeneralTree<Integer> (42));
        arbol.addChild(hd);
        
        ParcialArboles par = new ParcialArboles (arbol);
        
        System.out.println(par.camino(2));
    }
    
}
