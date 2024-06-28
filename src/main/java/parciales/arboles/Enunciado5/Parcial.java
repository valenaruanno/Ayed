/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.arboles.Enunciado5;

import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author valen
 */
public class Parcial {
    
    
    public Integer sumaImparesPosOrdenMayorA (BinaryTree<Integer> arbol, int limite){
        int total = 0;
        if (!arbol.isEmpty())
            total = analisis (arbol, limite);
        return total;
    }
    
    private int analisis (BinaryTree<Integer> arbol, int limite){
        int num = 0;
        if (arbol.hasLeftChild())
            num += analisis (arbol.getLeftChild(), limite);
        if (arbol.hasRightChild())
            num += analisis (arbol.getRightChild(), limite);
        if ((arbol.getData() % 2 == 1) && (arbol.getData() > limite))
            num += arbol.getData();
        return num;
    }
}
