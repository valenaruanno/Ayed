/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2.ejercicio8;
import tp2.ejercicio1.BinaryTree;
/**
 *
 * @author valen aruanno
 */
public class ParcialArboles {
    
    
    public boolean esPrefijo (BinaryTree <Integer> arbol1, BinaryTree <Integer> arbol2){
        boolean es = true;
        if ((!arbol1.isEmpty()) && (!arbol2.isEmpty())){
                if (arbol1.getData() == arbol2.getData()){
                    if (arbol1.hasLeftChild()){
                        if (arbol2.hasLeftChild())
                            esPrefijo (arbol1.getLeftChild(), arbol2.getLeftChild());
                        else
                            es = false;
                    }
                    if (arbol1.hasRightChild()){
                        if (arbol2.hasRightChild())
                            esPrefijo (arbol1.getRightChild(), arbol2.getRightChild());
                        else
                            es = false;
                    }
                }
        }else
            es = false;
       return es;
    }
}
