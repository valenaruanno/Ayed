/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Arboles.Parcial2023Tema2;

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
        List<Integer> lista = new LinkedList<Integer> ();
        int cant = 0;
        if (!this.arbol.isEmpty())
           cant = procesar (this.arbol, lista);
        Resultado res = new Resultado (lista, cant);
        return res;
    }
    
    private int procesar (BinaryTree<Integer> arbol, List<Integer> lista){
        int cant = 0;
        boolean izq = false;
        boolean der = false;
        if (arbol.hasLeftChild()){
            izq = true;
            cant += procesar (arbol.getLeftChild(), lista);
        }
        if (arbol.hasRightChild()){
            der = true;
            cant += procesar (arbol.getRightChild(), lista);
        }
        if (arbol.getData() % 2 == 1)
            cant++;
        if (((izq && !der) || (!izq && der)) && (arbol.getData() % 2 == 1))
            lista.add(arbol.getData());
        return cant;
    }
    
    public static void main (String[] args){
        
        BinaryTree<Integer> hid = new BinaryTree<Integer> (9);
        hid.addLeftChild(new BinaryTree<Integer> (11));
        
        BinaryTree<Integer> hii = new BinaryTree<Integer> (1);
        hii.addRightChild(new BinaryTree<Integer> (20));
        
        BinaryTree<Integer> hi = new BinaryTree<Integer> (6);
        hi.addLeftChild(hii);
        hi.addRightChild(hid);
        
        
        BinaryTree<Integer> hdi = new BinaryTree<Integer> (8);
        hdi.addLeftChild(new BinaryTree<Integer> (2));
        hdi.addRightChild(new BinaryTree<Integer> (4));
        
        BinaryTree<Integer> hdd = new BinaryTree<Integer> (3);
        hdd.addRightChild(new BinaryTree<Integer> (4));
        
        BinaryTree<Integer> hd = new BinaryTree<Integer> (2);
        hd.addLeftChild(hdi);
        hd.addRightChild(hdd);
        
        BinaryTree<Integer> a = new BinaryTree<Integer> (10);
        a.addLeftChild(hi);
        a.addRightChild(hd);
        
        ProcesadorDeArbol pro = new ProcesadorDeArbol (a);
        Resultado res = pro.procesar();
        System.out.println(res.getLista());
        System.out.println(res.getCantImpares());
    }
}
