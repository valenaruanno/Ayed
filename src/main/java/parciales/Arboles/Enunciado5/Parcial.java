/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Arboles.Enunciado5;

import tp1.Ej8.Queue;
import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author valen
 */
public class Parcial {
    private BinaryTree<Integer> arbol;
    
    public Parcial (BinaryTree<Integer> arbol){
        this.arbol = arbol;
    }
    
    public BinaryTree<Integer> minEnNivelAB (int n){
        int nivel = 0;
        BinaryTree<Integer> res = new BinaryTree<Integer> ();
        Queue <BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>> ();
        cola.enQueue(this.arbol);
        cola.enQueue(null);
        BinaryTree<Integer> aux = new BinaryTree<Integer> ();
        int min = 9999;
        while ((!cola.isEmpty()) && (nivel != n)){
            aux = cola.deQueue();
            if (aux != null){
                if (aux.hasLeftChild())
                    cola.enQueue(aux.getLeftChild());
                if (aux.hasRightChild())
                    cola.enQueue(aux.getRightChild());
            } else {
                nivel++;
                if (!cola.isEmpty())
                    cola.enQueue(null);
            }
        }
        
        while (!cola.isEmpty()){
            aux = cola.deQueue();
            if (aux != null){
                if ((aux.isLeaf()) && (aux.getData() < min)){
                    min = aux.getData();
                    res = aux;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        BinaryTree<Integer> ab = new BinaryTree<Integer>(2);
        ab.addLeftChild(new BinaryTree<Integer>(7));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(2));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(11));
        ab.addRightChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(9));
        ab.getRightChild().getRightChild().addLeftChild(new BinaryTree<Integer>(4));
        
        Parcial a = new Parcial(ab);
        
        //Es necesario .getData(), porque si retorna null, se hace un .toString() a un objeto nulo, tirando nullPointerException.
        
        System.out.println(a.minEnNivelAB(1).getData());
        System.out.println(a.minEnNivelAB(2).getData());
        System.out.println(a.minEnNivelAB(3).getData());
        
    }
    
}
