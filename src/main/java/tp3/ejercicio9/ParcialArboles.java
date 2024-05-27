/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ejercicio9;
import java.util.Iterator;
import tp3.ejercicio1.GeneralTree;
import tp1.Ej8.Queue;
import java.util.List;
/**
 *
 * @author valen aruanno
 */
public class ParcialArboles {
    
    public static boolean esDeSeleccion (GeneralTree<Integer> arbol){
        boolean ok = true;
        int min;
        if ((!arbol.isEmpty()) && (!arbol.isLeaf())){
            Queue <GeneralTree<Integer>> cola = new Queue <GeneralTree<Integer>> ();
            cola.enQueue(arbol);
            while ((!cola.isEmpty()) && (ok)){
                GeneralTree<Integer> aux = new GeneralTree<Integer> ();
                aux = cola.deQueue();
                min = 9999;
                if (!aux.isLeaf()){
                    List <GeneralTree<Integer>> hijos = arbol.getChildren();
                    Iterator <GeneralTree<Integer>> it = hijos.iterator();
                    while ((it.hasNext()) && (ok)){
                        GeneralTree<Integer> hijo = it.next();
                        if (aux.getData() > hijo.getData())
                            ok = false;
                        else {
                            if (hijo.getData() < min)
                                min = hijo.getData();
                            if (!(hijo.isLeaf()))
                                cola.enQueue(hijo);
                        }
                    }
                    System.out.println(ok);
                    if (min != aux.getData())
                        ok = false;
                    System.out.println(aux.getData());
                    System.out.println("soy el minimo" + min);
                    System.out.println(ok);
                }
            }
        }
        return ok;
    }
}
