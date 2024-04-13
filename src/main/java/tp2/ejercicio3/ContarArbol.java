/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2.ejercicio3;
import tp2.ejercicio1.BinaryTree;
import java.util.ArrayList;
/**
 *
 * @author valen aruanno
 */
public class ContarArbol {
    private BinaryTree <Integer> arbol;

    public ContarArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public BinaryTree<Integer> getArbol() {
        return arbol;
    }

    public void setArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public ArrayList <Integer> numerosPares (){
        ArrayList <Integer> pares = new ArrayList <Integer> ();
        
        return (!this.getArbol().isEmpty()) ? numerosPares (this.getArbol(), pares): pares;
    }
    
    private ArrayList <Integer> numerosPares (BinaryTree <Integer> ab, ArrayList <Integer> pares){
        if ((ab.getData()%2) == 0)
            pares.add(ab.getData());
        if (ab.hasLeftChild())
            numerosPares (ab.getLeftChild(), pares);
        if (ab.hasRightChild())
            numerosPares (ab.getRightChild(), pares);
        return pares;
    }
}
