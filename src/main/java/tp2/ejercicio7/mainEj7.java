/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2.ejercicio7;

import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author valen aruanno
 */
public class mainEj7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinaryTree <Integer> arbolIzq = new BinaryTree <Integer> (8);
        arbolIzq.addLeftChild(new BinaryTree <Integer>(5));
        BinaryTree <Integer> arbolDer = new BinaryTree <Integer> (13);
        arbolDer.addRightChild(new BinaryTree <Integer> (8));
        BinaryTree <Integer> arbol = new BinaryTree <Integer> (14);
        arbol.addLeftChild(arbolIzq);
        arbol.addRightChild(arbolDer);
        
        ParcialArboles a = new ParcialArboles (arbol);
        System.out.println(a.isLeftTree(14));
    }
    
}
