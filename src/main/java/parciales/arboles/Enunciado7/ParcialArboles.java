/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.arboles.Enunciado7;

import java.util.LinkedList;
import java.util.List;
import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author valen
 */
public class ParcialArboles {
    
    public List<Integer> resolver (BinaryTree<Integer> arbol){
        List <Integer> lista = new LinkedList<Integer> ();
        if (!arbol.isEmpty())
            buscar (arbol, lista);
        return lista;
    }
    
    private void buscar (BinaryTree<Integer> arb, List<Integer> lista){
        int cantI = 0;
        int cantD = 0;
        if (arb.hasLeftChild()){
            cantI = chequear (arb.getLeftChild());
            buscar (arb.getLeftChild(), lista);
        }
        if (arb.hasRightChild()){
            cantD = chequear (arb.getRightChild());
            buscar (arb.getRightChild(), lista);
        }
        if (cantI == cantD)
            lista.add(arb.getData());
    }
    
    private int chequear (BinaryTree<Integer> arb){
        int cant = 1;
        if (arb.hasLeftChild())
            cant += chequear (arb.getLeftChild());
        if (arb.hasRightChild())
            cant += chequear (arb.getRightChild());
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
        ParcialArboles p = new ParcialArboles();
        
        System.out.println(p.resolver(ab));
    }
}
