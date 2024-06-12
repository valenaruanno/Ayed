/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PreParcialArboles.ej6p2;
import tp2.ejercicio1.BinaryTree;
/**
 *
 * @author valen aruanno
 */
public class Transformacion {
    private BinaryTree<Integer> arbol;

    public Transformacion(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public BinaryTree<Integer> getArbol() {
        return arbol;
    }

    public void setArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public BinaryTree<Integer> suma (){
        BinaryTree<Integer> nuevo = new BinaryTree<Integer> ();
        int valor;
        if (!this.arbol.isEmpty()){
            valor = modificar (this.arbol);
            nuevo = this.arbol;
        }
        return nuevo;
    }
    
    private int modificar (BinaryTree<Integer> ab){
        int valor;
        int tot;
        int valorHI = 0;
        int valorHD = 0;
        if (ab.isLeaf()){
            valor = ab.getData();
            ab.setData(0);
        }else {
            if (ab.hasLeftChild())
              valorHI = modificar (ab.getLeftChild());
            if (ab.hasRightChild())
              valorHD = modificar (ab.getRightChild());
            tot = valorHI + valorHD;
            valor = tot + ab.getData();
            ab.setData(tot);
        }
        return valor;
    }
}
