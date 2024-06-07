/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreParcialArboles.ej5p2;

import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author valen
 */
public class mainEj5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinaryTree<Integer> hii = new BinaryTree<Integer> (3);
        BinaryTree<Integer> hid = new BinaryTree<Integer> (9);
        BinaryTree<Integer> hi = new BinaryTree<Integer> (8);
        hi.addRightChild(hid);
        hi.addLeftChild(hii);
        
        BinaryTree<Integer> hdi = new BinaryTree<Integer> (10);
        BinaryTree<Integer> hdd = new BinaryTree<Integer> (2);
        BinaryTree<Integer> hd = new BinaryTree<Integer> (1);
        hd.addRightChild(hdd);
        hd.addLeftChild(hdi);
        
        BinaryTree<Integer> arbol = new BinaryTree<Integer> (5);
        arbol.addRightChild(hd);
        arbol.addLeftChild(hi);
        
        ProfundidadDeArbolBinario prof = new ProfundidadDeArbolBinario (arbol);
        System.out.println(prof.sumaElementosProfundidad(2));
    }
    
}
