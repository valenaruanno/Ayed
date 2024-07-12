/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Arboles.Enunciado2;

import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author valen
 */
public class Parcial {
    private BinaryTree<Integer> arbol;

    public Parcial(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    
    public boolean resolver (int k){
        boolean resultado = false;
        if (!this.arbol.isEmpty())
            resultado = chequear (this.arbol, k, 0);
        return resultado;
    }
    
    public boolean chequear (BinaryTree<Integer> arbol, int k, int suma){
        boolean resul = true;
        suma += arbol.getData();
        if (arbol.isLeaf()){
            if (k != suma)
                resul = false;
        } else {
            if (arbol.hasLeftChild() && (resul))
                resul = chequear (arbol.getLeftChild(), k, suma);
            if (arbol.hasRightChild() && (resul))
                resul = chequear (arbol.getRightChild(), k, suma);
        }
        return resul;
    }
    
    public static void main(String args[]) {
        
        BinaryTree<Integer> hdd = new BinaryTree<Integer>(2);
        hdd.addLeftChild(new BinaryTree<Integer> (2));
        
        BinaryTree<Integer> hdi = new BinaryTree<Integer>(1);
        hdi.addLeftChild(new BinaryTree<Integer> (3));
        
        BinaryTree<Integer> hd = new BinaryTree<Integer>(2);
        hd.addLeftChild(hdi);
        hd.addRightChild(hdd);
        
        
        BinaryTree<Integer> hid = new BinaryTree<Integer>(4);
        hid.addLeftChild(new BinaryTree<Integer> (1));
        hid.addRightChild(new BinaryTree<Integer> (1));
        
        BinaryTree<Integer> hi = new BinaryTree<Integer>(1);
        hi.addLeftChild(new BinaryTree<Integer> (5));
        hi.addRightChild(hid);
        
        BinaryTree<Integer> ab = new BinaryTree<Integer>(2);
        ab.addLeftChild(hi);
        ab.addRightChild(hd);
        
        
        Parcial a = new Parcial(ab);
        System.out.println(a.resolver(7));
    
    }
}
