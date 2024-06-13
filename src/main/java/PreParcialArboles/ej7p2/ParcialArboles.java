/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreParcialArboles.ej7p2;

import tp1.Ej8.Queue;
import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author valen
 */
public class ParcialArboles {
    private BinaryTree<Integer> arbol;

    public ParcialArboles(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    
    public boolean isLeaftTree (int num){
        boolean ok = false;
        if (!this.arbol.isEmpty()){
            ok = buscar (arbol, num, ok);
        }
        return ok;
    }
    
    public boolean buscar (BinaryTree<Integer> ab, int num, boolean ok){
        Queue <BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>> ();
        BinaryTree<Integer> aux = new  BinaryTree<Integer> ();
        cola.enQueue(ab);
        while ((!cola.isEmpty()) && (!ok)){
            aux = cola.deQueue();
            if (aux.getData() == num)
                ok = true;
            else {
                if (aux.hasLeftChild())
                    cola.enQueue(aux.getLeftChild());
                if (aux.hasRightChild())
                    cola.enQueue(aux.getRightChild());
            }
        }
        if (ok){
            ok = chequear (aux);
        }else
            System.out.println("No se ha encontrado num en el arbol");
        return ok;
    }
    
    private boolean chequear (BinaryTree<Integer> ab){
        boolean result = false;
        int cantI = 0;
        int cantD = 0;
        if (!ab.isLeaf()){
            if (ab.hasLeftChild() && !ab.hasRightChild())
                result = true;          //considero la rama derecha como -1
            else{
                if (ab.hasLeftChild() && ab.hasRightChild()){
                    cantI = contarNodos(ab.getLeftChild());
                    cantD = contarNodos(ab.getRightChild());
                    result = cantI > cantD;
                }
            }
        }
        return result;
    }

    private int contarNodos(BinaryTree<Integer> ab){
        int cant = 0;
        Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
        cola.enQueue(ab);
        BinaryTree<Integer> aux;
        while (!cola.isEmpty()){
            aux = cola.deQueue();
            if ((aux.hasLeftChild() && !aux.hasRightChild())|| (aux.hasRightChild() && !aux.hasLeftChild())){
                cant++;
            }
            if (aux.hasLeftChild())
                cola.enQueue(aux.getLeftChild());
            if (aux.hasRightChild())
                cola.enQueue(aux.getRightChild());
        }
        return cant;
    }

    public static void main (String [] args){
        BinaryTree <Integer> arbolIzq = new BinaryTree <Integer> (8);
        arbolIzq.addLeftChild(new BinaryTree <Integer>(5));
        BinaryTree <Integer> arbolDer = new BinaryTree <Integer> (13);
        arbolDer.addRightChild(new BinaryTree <Integer> (8));

        BinaryTree <Integer> arbol = new BinaryTree <Integer> (14);
        arbol.addLeftChild(arbolIzq);
        arbol.addRightChild(arbolDer);

        ParcialArboles par = new ParcialArboles(arbol);
        System.out.println(par.isLeaftTree(8));
    }
    /*private boolean chequear (BinaryTree<Integer> ab){
        boolean si = false;
        int cantI = 0;
        int cantD = 0;
        if (!ab.isLeaf()){
            if ((ab.hasLeftChild()) && (!(ab.hasRightChild())))
                cantD = -1;
            else{
                if ((!(ab.hasLeftChild())) && (ab.hasRightChild()))
                    cantI = -1;
                else
            }
                
        }
        return si;
    }*/
}
