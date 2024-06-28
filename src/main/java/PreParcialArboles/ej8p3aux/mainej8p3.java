/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreParcialArboles.ej8p3aux;

import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen
 */
public class mainej8p3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneralTree<Integer> HI = new GeneralTree <Integer> (1);
    HI.addChild(new GeneralTree <Integer> (1));
    HI.addChild(new GeneralTree <Integer> (1));
    HI.addChild(new GeneralTree <Integer> (1));
    
    GeneralTree <Integer> HM = new GeneralTree <Integer> (1);
    HM.addChild(new GeneralTree <Integer> (1));
    HM.addChild(new GeneralTree <Integer> (1));
    HM.addChild(new GeneralTree <Integer> (1));
    
    GeneralTree <Integer> HD = new GeneralTree <Integer> (1);
    HD.addChild(new GeneralTree <Integer> (1));
    HD.addChild(new GeneralTree <Integer> (1));
    HD.addChild(new GeneralTree <Integer> (1));
    
    GeneralTree <Integer> arbol = new GeneralTree <Integer> (1);
    arbol.addChild(new GeneralTree <Integer> (1));
    //arbol.addChild(new GeneralTree <Integer> (1));
    arbol.addChild(new GeneralTree <Integer> (1));
    arbol.addChild(HI);
    arbol.addChild(HM);
    arbol.addChild(HD);
    
    Navidad navidad = new Navidad (arbol);
    System.out.println(navidad.esAbetoNavidenio());
    }
    
}
