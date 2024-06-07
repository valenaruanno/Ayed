/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreParcialArboles.ej6p3;

import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen
 */
public class mainEj6P3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneralTree<Character> HD = new GeneralTree<Character> ('e');
        
        GeneralTree<Character> HMD = new GeneralTree<Character> ('d');
        HMD.addChild(new GeneralTree <Character> ('h'));
        HMD.addChild(new GeneralTree <Character> ('i'));
        HMD.addChild(new GeneralTree <Character> ('j'));

        GeneralTree<Character> HMI = new GeneralTree<Character> ('c');
        HMI.addChild(new GeneralTree<Character> ('f'));
        HMI.addChild(new GeneralTree<Character> ('g'));
        
        GeneralTree<Character> HI = new GeneralTree<Character> ('b');
        
        GeneralTree<Character> arbol = new GeneralTree<Character> ('a');
        arbol.addChild(HI);
        arbol.addChild(HMI);
        arbol.addChild(HMD);
        arbol.addChild(HD);
        
        RedAguaPotable red = new RedAguaPotable (arbol);
        System.out.println("El caudal minimo es: " + red.minimoCaudal(1000));
    }
    
}
