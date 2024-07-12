/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Arboles.EjerciciosParcialPractica.LeftTree;

import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author valen
 */
public class ParcialArboles {
    private BinaryTree<Integer> arbol;
    
    public ParcialArboles (BinaryTree<Integer> arbol){
        this.arbol = arbol;
    }
    
    public boolean isLeftTree (int num){
        boolean es = false;
        if (!arbol.isEmpty()){
            BinaryTree<Integer> a = new BinaryTree<Integer> ();
            a = buscar (this.arbol, num);
            if (a!= null)
                es = chequear (a);
        }
        return es;
    }
    
    private BinaryTree<Integer> buscar (BinaryTree<Integer> arbol, int num){
        BinaryTree<Integer> aux = new BinaryTree<Integer> ();
        if (arbol.getData() == num)
            aux = arbol;
        else {
            if (arbol.hasLeftChild())
                aux = buscar (arbol.getLeftChild(), num);
            if ((arbol.hasRightChild()) && (aux == null))
                aux = buscar (arbol.getRightChild(), num);
        }
        return aux;
    }
    
    private boolean chequear (BinaryTree<Integer> arbol){
        boolean es = false;
        int cantI = 0;
        int cantD = 0;
        if ((arbol.hasLeftChild()) && (!arbol.hasRightChild())){
            cantD = -1;
            cantI += contar (arbol.getLeftChild());
        } else {
            if (!arbol.hasLeftChild() && arbol.hasRightChild()){
                cantI = -1;
                cantD += contar (arbol.getRightChild());
            } else {
                if (arbol.hasLeftChild())
                    cantI += contar (arbol.getLeftChild());
                if (arbol.hasRightChild())
                    cantD += contar (arbol.getRightChild());
            }
        }
        return (cantI > cantD);
    }
    
    private int contar (BinaryTree<Integer> arbol){
        int cant = 0;
        if (((arbol.hasLeftChild()) && (!arbol.hasRightChild())) || ((!arbol.hasLeftChild()) && (arbol.hasRightChild())))
            cant++;
        if (arbol.hasLeftChild())
            cant += contar (arbol.getLeftChild());
        if (arbol.hasRightChild())
            cant += contar (arbol.getRightChild());
        return cant;
    }
    
    public static void main (String[] args) { 
        System.out.println("Test Ejercicio 7");
        
        BinaryTree<Integer> ab = new BinaryTree<Integer>(2);
        ab.addLeftChild(new BinaryTree<Integer>(7));
        ab.addRightChild(new BinaryTree<Integer>(-5));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(23));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(-3));
        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(55));
        ab.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(11));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(19));
        ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(4));
        ab.getRightChild().getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(18));
        
        ParcialArboles parcialArb = new ParcialArboles(ab);
        System.out.println("Resultado=" + parcialArb.isLeftTree(7));
        System.out.println("Resultado=" + parcialArb.isLeftTree(2));
        System.out.println("Resultado=" + parcialArb.isLeftTree(-5));
        System.out.println("Resultado=" + parcialArb.isLeftTree(19));
        System.out.println("Resultado=" + parcialArb.isLeftTree(-3));
    }
}
