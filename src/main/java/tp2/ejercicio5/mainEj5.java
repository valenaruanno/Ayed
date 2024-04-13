/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2.ejercicio5;
import tp2.ejercicio1.BinaryTree;
/**
 *
 * @author valen aruanno
 */
public class mainEj5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinaryTree <Integer> arbol = new BinaryTree <Integer> (14);
        System.out.println("PARADA 1");
        arbol.addLeftChild(new BinaryTree <Integer>(8));
        System.out.println("PARADA 2");
        arbol.addRightChild(new BinaryTree <Integer> (13));
        System.out.println("PARADA 3");
        ProfundidadDeArbolBinario p1 = new ProfundidadDeArbolBinario (arbol);
        System.out.println("PARADA 4");
        System.out.println(p1.SumaElementosArbolBinario(1));
    }
    
}
