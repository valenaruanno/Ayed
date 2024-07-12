/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Arboles.Enunciado16;

import java.util.LinkedList;
import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen
 */
public class mainEnunciado16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneralTree<Integer> hii = new GeneralTree<Integer> (10);
        hii.addChild(new GeneralTree<Integer> (3));
        hii.addChild(new GeneralTree<Integer> (2));
        hii.addChild(new GeneralTree<Integer> (13));
        
        GeneralTree<Integer> hi = new GeneralTree<Integer> (17);
        hi.addChild(hii);
        hi.addChild(new GeneralTree<Integer> (6));
        
        
        GeneralTree<Integer> hmm = new GeneralTree<Integer> (8);
        hmm.addChild(new GeneralTree<Integer> (1));
        hmm.addChild(new GeneralTree<Integer> (5));
        
        GeneralTree<Integer> hm = new GeneralTree<Integer> (9);
        hm.addChild(hmm);
        
        GeneralTree<Integer> hd = new GeneralTree<Integer> (15);
        hd.addChild(new GeneralTree<Integer> (4));

        GeneralTree<Integer> ab = new GeneralTree<Integer> (12);
        ab.addChild(hi);
        ab.addChild(hm);
        ab.addChild(hd);
        
        Parcial p = new Parcial (ab);
        
        LinkedList<Integer> lista = p.resolver();
        
        System.out.println(lista.toString());
    }
    
}
