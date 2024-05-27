/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ejercicio11;
import tp1.Ej8.Queue;
import tp3.ejercicio1.GeneralTree;
import java.util.List;
import java.util.LinkedList;
/**
 *
 * @author valen aruanno
 */
public class ParcialArboles {
    public static boolean resolver (GeneralTree<Integer> arbol){
        boolean ok = true;
        Queue <GeneralTree<Integer>> cola = new Queue <GeneralTree<Integer>> ();
        cola.enQueue(arbol);
        cola.enQueue(null);
        int cant = 1;
        int cantC = 0;
        while ((!cola.isEmpty()) && (ok == true)){
            GeneralTree<Integer> aux = new GeneralTree<Integer> ();
            aux = cola.deQueue();
            if (aux != null){
                List <GeneralTree<Integer>> children = aux.getChildren();
                for (GeneralTree<Integer> child: children){
                    cantC++;
                    cola.enQueue(child);
                }
            } else{
                if (!cola.isEmpty()){
                    cola.enQueue(null);
                    if (!(cant + 1 == cantC))
                        ok = false;
                    System.out.println(ok);
                    cant++;
                    cantC = 0;
                }
            }
        }
        return ok;
    }
}
