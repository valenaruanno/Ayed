/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2.ejercicio4;
import tp2.ejercicio1.BinaryTree;
/**
 *
 * @author valen aruanno
 */
public class mainEj4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinaryTree <Integer> a1 = new BinaryTree <Integer> (10);
        BinaryTree <Integer> a1Hi = new BinaryTree <Integer> (2);
        BinaryTree <Integer> a1Hd = new BinaryTree <Integer> (3);
        a1.addLeftChild(a1Hi);
        a1.addRightChild(a1Hd);
        RedBinariaLlena <Integer> arbol = new RedBinariaLlena <Integer> (a1);
        System.out.println("El retardo de reenvio es: " + arbol.retardoReenvio());
    }
    
}
