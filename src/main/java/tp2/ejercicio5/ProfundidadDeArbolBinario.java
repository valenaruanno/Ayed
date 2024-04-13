/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2.ejercicio5;
import tp2.ejercicio1.BinaryTree;
import tp1.Ej8.Queue;
/**
 *
 * @author valen aruanno
 */
public class ProfundidadDeArbolBinario {
    private BinaryTree <Integer> arbol;
    
    public ProfundidadDeArbolBinario (BinaryTree <Integer> arbol){
    this.arbol = arbol;
    }

    public BinaryTree<Integer> getArbol() {
        return arbol;
    }

    public void setArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    

    public int SumaElementosArbolBinario (int p){
        int suma = 0;
        int pro = 0;
        BinaryTree <Integer> aux = new BinaryTree <Integer> ();
        Queue <BinaryTree<Integer>> cola = new Queue <BinaryTree<Integer>> ();
        System.out.println("PARADA 5");
        cola.enQueue(this.getArbol());
        System.out.println("PARADA 6");
        cola.enQueue(null);
        System.out.println("PARADA 7");
        while ((!cola.isEmpty()) && (pro < p)){
            pro++;
            aux = cola.deQueue();
            System.out.println("PARADA 8");
            while ((!cola.isEmpty()) && (aux != null)){
                if (aux.hasLeftChild())
                    cola.enQueue(aux.getLeftChild());
                if (aux.hasRightChild())
                    cola.enQueue(aux.getRightChild()); 
                aux = cola.deQueue();
                System.out.println("PARADA 9");
            }
            cola.enQueue(null);
        }
        aux = cola.deQueue();
        suma = suma + aux.getData();
        System.out.println("PARADA 10");
        while ((aux != null)){
            System.out.println("PARADA 11");
            aux = cola.deQueue();
            suma = suma + aux.getData();
        }
        System.out.println("PARADA 12");
        return suma;
    }
}
