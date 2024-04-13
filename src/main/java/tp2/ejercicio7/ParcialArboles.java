/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2.ejercicio7;
import tp2.ejercicio1.BinaryTree;
/**
 *
 * @author valen aruanno
 */
public class ParcialArboles {
    private BinaryTree <Integer> arbol;

    public ParcialArboles(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public BinaryTree<Integer> getArbol() {
        return arbol;
    }

    public void setArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public boolean isLeftTree (int num){
         boolean resultado = false;
         if (!this.getArbol().isEmpty()){
             BinaryTree <Integer> arbolInt = new BinaryTree <Integer> ();
             arbolInt = buscar (this.getArbol(), num);
             resultado = check (arbolInt);
         }
        return resultado;
    }
    
    private static BinaryTree <Integer> buscar (BinaryTree <Integer> ab, int num){
        boolean res = false;
        BinaryTree <Integer> abInt = new BinaryTree <Integer> ();
        if (!ab.isEmpty()){
            if (ab.getData() == num){
                res = true;
                abInt = ab;
            }else{
                if (ab.hasLeftChild())
                    abInt = buscar (ab.getLeftChild(), num);
                if ((res != true) && (ab.hasRightChild()))
                    abInt = buscar (ab.getRightChild(), num);
            }
        }
        return abInt;
    }
    
    private static boolean check (BinaryTree <Integer> ab){
        int cantI = 0;
        int cantD = 0;
        if (!ab.isEmpty()){ 
            if (ab.hasLeftChild())
                cantI += calcular (ab.getLeftChild());
            else
                cantI = -1;
            if (ab.hasRightChild())
               cantD += calcular (ab.getRightChild());
            else
                cantD = -1;
        }
        return (cantI > cantD);
    }
    
    private static int calcular (BinaryTree <Integer> ab){
        int cant = 0;
        if (!ab.isLeaf()){
            if ((ab.hasLeftChild()) && (!ab.hasRightChild())){
                cant++;
                cant += calcular (ab.getLeftChild());
            }
            if ((!ab.hasLeftChild()) && (ab.hasRightChild())){
                cant++;
                cant += calcular (ab.getRightChild());
            }
            if ((ab.hasLeftChild()) && (ab.hasRightChild())){
                cant += calcular (ab.getLeftChild());
                cant += calcular (ab.getRightChild());
            }
        }
        return cant;
    }
}
