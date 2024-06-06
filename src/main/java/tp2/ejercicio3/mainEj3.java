/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2.ejercicio3;
import tp2.ejercicio1.BinaryTree;
import java.util.ArrayList;
/**
 *
 * @author valen aruanno
 */
public class mainEj3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinaryTree <Integer> arbol = new BinaryTree <Integer> (14);
        arbol.addLeftChild(new BinaryTree <Integer>(8));
        arbol.addRightChild(new BinaryTree <Integer> (13));
        ContarArbol c1 = new ContarArbol (arbol);
        ArrayList <Integer> lista = new ArrayList <Integer> ();
        lista = c1.numerosPares(); 
        for (Integer i: lista){
            System.out.println(i);
        } 
    }
    
    
}
