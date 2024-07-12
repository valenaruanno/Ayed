/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Arboles.SegundaFecha2024;

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
    
    public BinaryTree<Integer> nuevoTree(){
        BinaryTree<Integer> nuevo = new BinaryTree<Integer> ();
        if (!this.arbol.isEmpty())
            nuevo = crear (this.arbol, 0);
        return nuevo;
    }
    
    private BinaryTree<Integer> crear (BinaryTree<Integer> arbol, int izq){
        BinaryTree<Integer> nuevo = new BinaryTree<Integer> (arbol.getData() + izq);
        int izquierdo = 0;
        if (arbol.hasLeftChild()){
            izquierdo = arbol.getLeftChild().getData();
            nuevo.addLeftChild(crear (arbol.getLeftChild(), 0));
        }
        if (arbol.hasRightChild())
            nuevo.addRightChild(crear (arbol.getRightChild(), izquierdo));
        return nuevo;
    }
    
    public BinaryTree<Integer> nuevoTreeTema1(){
        BinaryTree<Integer> nuevo = new BinaryTree<Integer> ();
        if (!this.arbol.isEmpty())
            nuevo = crearTema1 (this.arbol, 0);
        return nuevo;
    }
    
    private BinaryTree<Integer> crearTema1 (BinaryTree<Integer> arbol, int padre){
        BinaryTree<Integer> nuevo = new BinaryTree<Integer> (arbol.getData() + padre);
        if (arbol.hasLeftChild())
            nuevo.addLeftChild(crearTema1 (arbol.getLeftChild(), arbol.getData()));
        if (arbol.hasRightChild())
            nuevo.addRightChild(crearTema1 (arbol.getRightChild(), 0));
        return nuevo;
    }
    
    
    public void imprimir (BinaryTree<Integer> arbol){
        System.out.println(arbol.getData());
        if (arbol.hasLeftChild())
            imprimir (arbol.getLeftChild());
        if (arbol.hasRightChild())
            imprimir (arbol.getRightChild());
    }
    
    public static void main (String [] args){
        
        BinaryTree<Integer> hi = new BinaryTree<Integer> (2);
        hi.addLeftChild(new BinaryTree<Integer> (4));
        
        
        BinaryTree<Integer> hddi = new BinaryTree<Integer> (8);
        hddi.addLeftChild(new BinaryTree<Integer> (9));
        hddi.addRightChild(new BinaryTree<Integer> (10));
        
        BinaryTree<Integer> hdd = new BinaryTree<Integer> (7);
        hdd.addLeftChild(hddi);
        
        BinaryTree<Integer> hd = new BinaryTree<Integer> (3);
        hd.addRightChild(hdd);
        
        BinaryTree<Integer> a = new BinaryTree<Integer> (1);
        a.addLeftChild(hi);
        a.addRightChild(hd);
        
        ParcialArboles p = new ParcialArboles (a);
        
        BinaryTree<Integer> aux = p.nuevoTree();
        
        //p.imprimir(aux);
        
        BinaryTree<Integer> auxTema1 = p.nuevoTreeTema1();
        p.imprimir(auxTema1);
    }
}
