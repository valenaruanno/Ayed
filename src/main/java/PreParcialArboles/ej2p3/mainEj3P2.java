/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreParcialArboles.ej2p3;
import tp2.ejercicio1.BinaryTree;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author valen
 */
public class mainEj3P2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinaryTree <Integer> hi = new BinaryTree<Integer> (8);
        hi.addLeftChild(new BinaryTree<Integer> (5));
        hi.addRightChild(new BinaryTree<Integer>(4));
        
        BinaryTree <Integer> hd = new BinaryTree<Integer> ();
        hd.addLeftChild(new BinaryTree<Integer> (4));
        hd.addRightChild(new BinaryTree<Integer> (6));
        
        BinaryTree <Integer> arbol = new BinaryTree<Integer> (10);
        arbol.addLeftChild(hi);
        arbol.addRightChild(hd);
        
        ContadorArbol cont = new ContadorArbol (arbol);
        
        ArrayList<Integer> listas = new ArrayList<Integer> ();
        
        System.out.println ("Lista in orden");
        listas= cont.contarParesInOrder();
        for (Integer i: listas)
            System.out.println (i);
        
        System.out.println ("Lista post orden");
        listas = cont.contarParesPostOrder();
        for (Integer i: listas)
            System.out.println (i);
    }
    
}
