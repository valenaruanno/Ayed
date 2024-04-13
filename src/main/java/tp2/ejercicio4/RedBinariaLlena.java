/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2.ejercicio4;
import tp2.ejercicio1.BinaryTree;
/**
 *
 * @author valen aruanno
 */
public class RedBinariaLlena <Integer> {
    private BinaryTree <Integer> arbol;
    
    public RedBinariaLlena ( BinaryTree <Integer> a){
        this.setArbol(a);
    }

    public BinaryTree<Integer> getArbol() {
        return arbol;
    }
    
    public void setArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    
    public int retardoReenvio (){
        return (!this.getArbol().isEmpty()) ? retR (this.getArbol()): 0;
    }
    
    private int retR (BinaryTree <Integer> bt){
        int retI = 0;
        int retD = 0;
        int i = (int)bt.getData();
        if (bt.hasLeftChild ())
            retI += retR (bt.getLeftChild());
        if (bt.hasRightChild())
            retD += retR (bt.getRightChild());
        return (Math.max(retI, retD) + i);
    }
}
