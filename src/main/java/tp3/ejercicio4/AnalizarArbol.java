/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ejercicio4;
import tp3.ejercicio1.GeneralTree;
import tp1.Ej8.Queue;
import java.util.LinkedList;
/**
 *
 * @author valen aruanno
 */
public class AnalizarArbol {
    public double devolverMaximoPromedio (GeneralTree<AreaEmpresa> arbol){
        double max = -1;
        if (!arbol.isEmpty()){
            Queue <GeneralTree<AreaEmpresa>> cola = new Queue <GeneralTree<AreaEmpresa>> ();
            cola.enQueue(arbol);
            int total = arbol.getData().getRetardo();
            int cant = 1;
            if ((total / cant) > max)
                max = total / cant;
            GeneralTree <AreaEmpresa> arb = new GeneralTree<AreaEmpresa> ();
            while (!cola.isEmpty()){
                total = 0;
                cant = 0;
                arb = cola.deQueue();
                if (!arb.isEmpty()){
                    LinkedList <GeneralTree<AreaEmpresa>> children = (LinkedList) arbol.getChildren();
                    for (GeneralTree<AreaEmpresa> child : children){
                        cola.enQueue(child);
                        total = total + child.getData().getRetardo();
                        cant++;
                    }
                }
                if ((total / cant) > max)
                    max = total / cant; 
            }
        }
        return max;
    }
}
