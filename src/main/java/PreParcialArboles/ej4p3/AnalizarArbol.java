/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreParcialArboles.ej4p3;
import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio1.GeneralTree;
import tp1.Ej8.Queue;
/**
 *
 * @author valen
 */
public class AnalizarArbol {
    
    public static double devolverMayorPromedio (GeneralTree<AreaEmpresa> arbol){
        double max = -1;
        int tot = 0;
        int cant = 0;
        Queue <GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>> ();
        cola.enQueue(arbol);
        cola.enQueue(null);
        GeneralTree<AreaEmpresa> aux = new GeneralTree<AreaEmpresa> ();
        while (!cola.isEmpty()){
            aux = cola.deQueue();
            if (aux != null){
                cant++;
                tot = tot + aux.getData().getTardanza();
                LinkedList <GeneralTree<AreaEmpresa>> children = (LinkedList) aux.getChildren();
                for (GeneralTree<AreaEmpresa> child : children)
                    cola.enQueue(child);
            } else {
                if ((tot / cant) > max)
                    max = tot / cant;
                if (!cola.isEmpty()){
                    cola.enQueue(null);
                    tot = 0;
                    cant = 0;
                }
            }
        }
        return max;
    }
}
