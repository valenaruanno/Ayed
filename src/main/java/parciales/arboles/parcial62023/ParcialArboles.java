/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.arboles.parcial62023;

import tp1.Ej8.Queue;
import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author valen
 */
public class ParcialArboles {
    private BinaryTree<Integer> arbol = new BinaryTree<Integer> ();
    
    public ParcialArboles (BinaryTree<Integer> arbol){
        this.arbol = arbol;
    }
    
    public boolean isTwoTree (int num){
        boolean es = false;
        if (!this.arbol.isEmpty())
            es = buscar (this.arbol, num);
        return es;
    }
    
    private boolean buscar (BinaryTree<Integer> arbol, int num){
        boolean es = false;
        Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>> ();
        cola.enQueue(arbol);
        BinaryTree<Integer> aux = new BinaryTree<Integer> ();
        while ((!cola.isEmpty()) && (!es)){
            aux = cola.deQueue();
            if (aux != null){
                if (aux.getData().equals(num))
                    es = true;
                else {
                    if (aux.hasLeftChild())
                        cola.enQueue(aux.getLeftChild());
                    if (aux.hasRightChild())
                        cola.enQueue(aux.getRightChild());
                }
            } 
        }
        if (es == true)
            es = chequear (aux);
        return es;
    }
    
    private boolean chequear (BinaryTree<Integer> arbol){
        int cantI = -1;
        int cantD = -1;
        if (arbol.hasLeftChild())
            cantI = contar (arbol.getLeftChild());
        if (arbol.hasRightChild())
            cantD = contar (arbol.getRightChild());
        return cantI == cantD;
    }
    
    private int contar (BinaryTree<Integer> arbol){
        int cant = 0;
        if (arbol.hasLeftChild())
            cant+= contar (arbol.getLeftChild());
        if (arbol.hasRightChild())
            cant+= contar (arbol.getRightChild());
        if (arbol.hasLeftChild() && arbol.hasRightChild())
            cant++;
        return cant;
    }
}
