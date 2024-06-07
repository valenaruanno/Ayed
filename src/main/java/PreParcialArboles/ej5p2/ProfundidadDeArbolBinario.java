/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreParcialArboles.ej5p2;
import tp2.ejercicio1.BinaryTree;
import tp1.Ej8.Queue;
import java.util.List;
/**
 *
 * @author valen
 */
public class ProfundidadDeArbolBinario {
    private BinaryTree<Integer> arbol;

    public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public BinaryTree<Integer> getArbol() {
        return arbol;
    }

    public void setArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    
    public int sumaElementosProfundidad (int proof){
        int cant = 0;
        int total = 0;
        if (!this.arbol.isEmpty()){
            Queue <BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>> ();
            cola.enQueue(arbol);
            cola.enQueue(null);
            BinaryTree<Integer> aux = new BinaryTree<Integer> ();
            while ((!cola.isEmpty())&&(cant < proof)){
                aux = cola.deQueue();
                if (aux != null){
                    if (arbol.hasLeftChild())
                        cola.enQueue(arbol.getLeftChild());
                    if (arbol.hasRightChild())
                        cola.enQueue(arbol.getRightChild());
                } else{
                    cant++;
                    if (!cola.isEmpty()){
                        cola.enQueue(null);
                    }
                }
            }
            if (cant == proof){
                boolean ok = false; 
                while ((!cola.isEmpty()) && (ok == false)){
                    aux = cola.deQueue();
                    if (aux != null)
                        total = total + aux.getData();
                    else
                        ok = true;
                }
            }
        }
        return total;
    }
}
