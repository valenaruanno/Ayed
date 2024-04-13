/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2.ejercicio8;
import tp2.ejercicio1.BinaryTree;
/**
 *
 * @author valen aruanno
 */
public class mainEj8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinaryTree <Integer> hDer = new BinaryTree <Integer> (5);
        hDer.addRightChild(new BinaryTree <Integer> (13));
        BinaryTree <Integer> hIzq = new BinaryTree <Integer> (5);
        BinaryTree <Integer> arbol2 = new BinaryTree <Integer> (13);
        arbol2.addRightChild(hDer);
        
        BinaryTree <Integer> arbol1 = new BinaryTree <Integer> (13);
        arbol1.addLeftChild(new BinaryTree <Integer> (5));
        arbol1.addRightChild(new BinaryTree <Integer> (5));
        
        ParcialArboles ab = new ParcialArboles ();
        System.out.println(ab.esPrefijo(arbol1, arbol2));
    }
    
}
