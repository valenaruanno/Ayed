/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2.ejercicio6;

import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author valen aruanno
 */
public class mainEj6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinaryTree <Integer> arbolIzq = new BinaryTree <Integer> (8);
        arbolIzq.addLeftChild(new BinaryTree <Integer>(5));
        arbolIzq.addRightChild(new BinaryTree <Integer> (6));
        BinaryTree <Integer> arbolDer = new BinaryTree <Integer> (13);
        arbolDer.addLeftChild(new BinaryTree <Integer>(7));
        arbolDer.addRightChild(new BinaryTree <Integer> (8));
        BinaryTree <Integer> arbol = new BinaryTree <Integer> (14);
        arbol.addLeftChild(arbolIzq);
        arbol.addRightChild(arbolDer);
        Transformacion arbol2 = new Transformacion (arbol);
        BinaryTree <Integer> arbolT = new BinaryTree <Integer> ();
        
        System.out.println(arbol.getData());
        System.out.println(arbol.getLeftChild().getData());
        System.out.println(arbol.getRightChild().getData());
        System.out.println(arbol.getLeftChild().getLeftChild().getData());
        System.out.println(arbol.getLeftChild().getRightChild().getData());
        System.out.println(arbol.getRightChild().getLeftChild().getData());
        System.out.println(arbol.getRightChild().getRightChild().getData());
        System.out.println("-------------------------------------------------");
        arbolT = arbol2.suma();
        System.out.println(arbolT.getData());
        System.out.println(arbolT.getLeftChild().getData());
        System.out.println(arbolT.getRightChild().getData());
        System.out.println(arbol.getLeftChild().getLeftChild().getData());
        System.out.println(arbol.getLeftChild().getRightChild().getData());
        System.out.println(arbol.getRightChild().getLeftChild().getData());
        System.out.println(arbol.getRightChild().getRightChild().getData());
    }
    
}
