/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreParcialArboles.ej2p4;
import tp2.ejercicio1.BinaryTree;
/**
 *
 * @author valen
 */
public class RedBinariaLlena {
    private BinaryTree<Integer> arbol;

    public RedBinariaLlena(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public BinaryTree<Integer> getArbol() {
        return arbol;
    }

    public void setArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    
    public  int retardoReenvio (){
        int i = 0;
        int max = -1;
        return (!this.arbol.isEmpty()) ? i = calcular (this.arbol, max, i): i;
    }
    
    private int calcular (BinaryTree<Integer> ab, int max, int i){
        if (ab.isLeaf()){
            i = i + ab.getData();
            if (i > max)
                max = i;
        } else {
            i = i + ab.getData();
            if (ab.hasLeftChild()){
                max = calcular (ab.getLeftChild(), max, i);
            }
            if (ab.hasRightChild()){
                max = calcular (ab.getRightChild(), max, i);
            }
        }
        return max;
    } 
}
