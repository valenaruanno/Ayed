/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2.ejercicio9;
import tp2.ejercicio1.BinaryTree;
/**
 *
 * @author valen aruanno
 */
public class mainEj9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinaryTree <Integer> hIzq = new BinaryTree <Integer> (10);
        hIzq.addLeftChild(new BinaryTree <Integer> (11));
        hIzq.addRightChild(new BinaryTree <Integer> (12));
        BinaryTree <Integer> hDer = new BinaryTree <Integer> (15);
        hDer.addLeftChild (new BinaryTree <Integer> (12));
        hDer.addRightChild(new BinaryTree <Integer> (13));
        BinaryTree <Integer> arbol = new BinaryTree <Integer> (9);
        arbol.addLeftChild(hIzq);
        arbol.addRightChild(hDer);
        
        ParcialArboles ej = new ParcialArboles ();
        BinaryTree <Data> nuevo = new BinaryTree <Data> ();
        System.out.println("--------------------------------");
        nuevo = ej.sumAndDif(arbol);
        ej.preOrden(nuevo);
    }
    
}
