/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Arboles.Enunciado1;

import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author valen
 */
public class Parcial {
    public Integer sumaImparesPostOrderMayorA (BinaryTree<Integer> arbol, int limite){
        int suma = 0;
        if (!arbol.isEmpty())
            suma = sumar (arbol, limite);
        return suma;
    }
    
    private Integer sumar (BinaryTree<Integer> arbol, int limite){
        int suma = 0;
        if (arbol.hasLeftChild())
            suma += sumar (arbol.getLeftChild(), limite);
        if (arbol.hasRightChild())
            suma += sumar (arbol.getRightChild(), limite);
        if ((arbol.getData() > limite) && (arbol.getData() % 2 == 1))
            suma += arbol.getData();
        return suma;
    }
    
    public static void main (String [] args){
        
        
        BinaryTree<Integer> hiidid = new BinaryTree<Integer> (43);
        hiidid.addLeftChild(new BinaryTree<Integer> (9));
        hiidid.addRightChild(new BinaryTree<Integer> (10));
        
        BinaryTree<Integer> hiidi = new BinaryTree<Integer> (16);
        hiidi.addRightChild(hiidid);
        
        BinaryTree<Integer> hiid = new BinaryTree<Integer> (77);
        hiid.addLeftChild(hiidi);
        
        
        BinaryTree<Integer> hii = new BinaryTree<Integer> (38);
        hii.addLeftChild(new BinaryTree<Integer> (87));
        hii.addRightChild(hiid);
        
        BinaryTree<Integer> hiddd = new BinaryTree<Integer> (2);
        hiddd.addLeftChild(new BinaryTree<Integer> (1));
        
        BinaryTree<Integer> hidd = new BinaryTree<Integer> (94);
        hidd.addRightChild(hiddd);
        
        BinaryTree<Integer> hid = new BinaryTree<Integer> (31);
        hid.addRightChild(hidd);
        
        BinaryTree<Integer> hi = new BinaryTree<Integer> (56);
        hi.addLeftChild(hii);
        hi.addRightChild(hid);
        
        
        BinaryTree<Integer> hd = new BinaryTree<Integer> (25);
        hd.addLeftChild(new BinaryTree<Integer> (5));
        hd.addRightChild(new BinaryTree<Integer> (6));
        
        
        BinaryTree<Integer> a = new BinaryTree<Integer> (7);
        a.addLeftChild(hi);
        a.addRightChild(hd);
        
        Parcial p = new Parcial ();
        
        System.out.println(p.sumaImparesPostOrderMayorA(a, 76));
    }
}
