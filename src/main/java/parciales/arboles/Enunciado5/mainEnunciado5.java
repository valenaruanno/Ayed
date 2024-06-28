/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.arboles.Enunciado5;

import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author valen
 */
public class mainEnunciado5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinaryTree<Integer> hi = new BinaryTree<Integer> (13);
        hi.addLeftChild(new BinaryTree<Integer> (6));
        hi.addRightChild(new BinaryTree<Integer> (11));
        
        BinaryTree<Integer> hd = new BinaryTree<Integer> (12);
        hd.addLeftChild(new BinaryTree<Integer> (2));
        hd.addRightChild(new BinaryTree<Integer> (15));
        
        BinaryTree<Integer> arbol = new BinaryTree<Integer> (4);
        arbol.addLeftChild(hi);
        arbol.addRightChild(hd);
        
        Parcial par = new Parcial ();
        System.out.println (par.sumaImparesPosOrdenMayorA(arbol, 14));
    }
    
}
