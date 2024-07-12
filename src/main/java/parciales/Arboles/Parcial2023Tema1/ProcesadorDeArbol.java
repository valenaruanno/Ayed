/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Arboles.Parcial2023Tema1;

import java.util.LinkedList;
import java.util.List;
import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author valen
 */
public class ProcesadorDeArbol {
    private BinaryTree<Integer> arbol;
    
    public ProcesadorDeArbol (BinaryTree<Integer> arbol){
        this.arbol = arbol;
    }
    
    public Resultado procesar (){
        int cant = 0;
        List<Integer> lista = new LinkedList<Integer> ();
        if (!this.arbol.isEmpty())
            cant = procesar (this.arbol, lista);
        Resultado res = new Resultado (lista, cant);
        return res;
    }
    
    private int procesar (BinaryTree<Integer> arbol, List<Integer> lista){
        int cant = 0;
        if ((arbol.getData() % 2 == 0) && (arbol.hasLeftChild()) && (arbol.hasRightChild()))
            lista.add(arbol.getData());
        if (arbol.getData() % 2 == 0)
            cant++;
        if (arbol.hasLeftChild())
            cant += procesar (arbol.getLeftChild(), lista);
        if (arbol.hasRightChild())
            cant += procesar (arbol.getRightChild(), lista);
        return cant;
    }
    
    public static void main(String[] args) {
        
        BinaryTree<Integer> hii = new BinaryTree<Integer>(1);
        hii.addRightChild(new BinaryTree<Integer> (20));
        
        BinaryTree<Integer> hid = new BinaryTree<Integer>(9);
        hid.addLeftChild(new BinaryTree<Integer> (11));
        hid.addRightChild(new BinaryTree<Integer> (5));
        
        BinaryTree<Integer> hi = new BinaryTree<Integer>(6);
        hi.addLeftChild(hii);
        hi.addRightChild(hid);
        
        
        BinaryTree<Integer> hdi = new BinaryTree<Integer>(8);
        hdi.addLeftChild(new BinaryTree<Integer> (2));
        hdi.addRightChild(new BinaryTree<Integer> (4));
        
        BinaryTree<Integer> hd = new BinaryTree<Integer>(2);
        hd.addLeftChild(hdi);
        hd.addRightChild(new BinaryTree<Integer> (3));
        
        
        BinaryTree<Integer> ab = new BinaryTree<Integer>(10);
        ab.addLeftChild(hi);
        ab.addRightChild(hd);
        
        ProcesadorDeArbol p = new ProcesadorDeArbol(ab);
        
        Resultado res = p.procesar();
        System.out.println(res.getLista());
        System.out.println(res.getCantPares());
    }
}
