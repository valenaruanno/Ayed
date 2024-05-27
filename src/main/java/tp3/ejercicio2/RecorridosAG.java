/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ejercicio2;
import java.util.Iterator;
import tp3.ejercicio1.GeneralTree;
import java.util.LinkedList;
import tp1.Ej8.Queue;
/**
 *
 * @author valen aruanno
 */
public class RecorridosAG {
    public LinkedList<Integer> numerosImparesMayoresQuePreOrden (GeneralTree<Integer> a, Integer n){
        LinkedList <Integer> lista = new LinkedList <Integer> ();
        if (!a.isEmpty())
            numerosImparesMayoresQuePreOrden (a, n, lista);
        return lista;
    }
    
    private static void numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n, LinkedList <Integer> lista){
        if ((a.getData() % 2 != 0) && (a.getData() > n))
            lista.add(a.getData());
        LinkedList <GeneralTree<Integer>> children = (LinkedList)a.getChildren();
        for (GeneralTree<Integer> child: children)
            numerosImparesMayoresQuePreOrden(child, n, lista);
    }
    
    public LinkedList<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n){
        LinkedList <Integer> lista = new LinkedList <Integer> ();
        if (!a.isEmpty())
            numerosImparesMayoresQueInOrden (a, n, lista);
        return lista;
    }
    
    private static void numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n, LinkedList <Integer> lista){
        if (!a.isLeaf()){
            boolean aux = false;
            LinkedList <GeneralTree<Integer>> children = (LinkedList) a.getChildren();
            for (GeneralTree<Integer> child: children){
                numerosImparesMayoresQueInOrden (child, n, lista);
                if ((a.getData() % 2 != 0) && (a.getData() > n) && (!aux)){
                    lista.add(a.getData());
                    aux = true;
                }
            }
        } else {
            if ((a.getData() % 2 != 0) && (a.getData() > n))
                lista.add(a.getData());
        }
    }
    
    public LinkedList<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n){
       LinkedList <Integer> lista = new LinkedList <Integer> ();
       if (!a.isEmpty())
           numerosImparesMayoresQuePostOrden (a, n, lista);
       return lista;
    }
    
    private static void numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n, LinkedList <Integer> lista){
        LinkedList <GeneralTree <Integer>> children = (LinkedList) a.getChildren();
        for (GeneralTree <Integer> child: children){
            if (!child.isLeaf())
               numerosImparesMayoresQuePostOrden (child, n, lista);
            else{
                if ((child.getData() % 2 != 0) && (child.getData() > n))
                    lista.add(child.getData());
            }
        }
        if ((a.getData() % 2 != 0) && (a.getData() > n))
            lista.add(a.getData());
    }
    
    public static LinkedList<Integer> numerosImparesMayoresQuePorNivel (GeneralTree <Integer> a, Integer n){
        LinkedList <Integer> lista = new LinkedList<Integer> ();
        Queue<GeneralTree<Integer>> cola = new Queue <GeneralTree<Integer>> ();
        GeneralTree<Integer> arb = new GeneralTree<Integer> ();
        if (!a.isEmpty()){
            cola.enQueue(a);
            while (!cola.isEmpty()){
                arb = cola.deQueue();
                LinkedList <GeneralTree<Integer>> children = (LinkedList) arb.getChildren();
                for (GeneralTree<Integer> child: children)
                    cola.enQueue(child);
                if ((arb.getData() % 2 != 0) && (arb.getData() > n))
                    lista.add(arb.getData());
            }
        }
        return lista;
    }
}
