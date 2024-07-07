/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Arboles.Enunciado7;

import java.util.LinkedList;
import java.util.List;
import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author valen
 */
public class Parcial {
    public List<Integer> resolver (BinaryTree<Integer> arbol){
        List<Integer> lista = new LinkedList<Integer> ();
        if (!arbol.isEmpty())
            chequear (arbol, lista);
        return lista;
    }
    
    private void chequear (BinaryTree<Integer> arbol, List<Integer> lista){
        int cantI = 0;
        int cantD = 0;
        if (arbol.hasLeftChild()){
            cantI+= contar (arbol.getLeftChild());
            chequear (arbol.getLeftChild(), lista);
        }
        if (arbol.hasRightChild()){
            cantD += contar (arbol.getRightChild());
            chequear (arbol.getRightChild(), lista);
        }
        if (cantI == cantD)
            lista.add(arbol.getData());
    }
    
    public int contar (BinaryTree<Integer> arbol){
        int cant = 1;
        if (arbol.hasLeftChild())
            cant += contar (arbol.getLeftChild());
        if (arbol.hasRightChild())
            cant += contar (arbol.getRightChild());
        return cant;
    }
    
     public static void main(String[] args) {
        BinaryTree<Integer> ab = new BinaryTree<Integer>(2);
        ab.addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(16));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(6));
        ab.addRightChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
        ab.getRightChild().getRightChild().addLeftChild(new BinaryTree<Integer>(22));
        Parcial p = new Parcial();
        
        System.out.println(p.resolver(ab));
    }
}
