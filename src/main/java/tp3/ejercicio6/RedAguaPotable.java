/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ejercicio6;

import java.util.LinkedList;
import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen aruanno
 */
public class RedAguaPotable {
    private GeneralTree<Character> arbol;

    public RedAguaPotable(GeneralTree<Character> arbol) {
        this.arbol = arbol;
    }
   

    public GeneralTree<Character> getArbol() {
        return arbol;
    }

    public double minimoCaudal  (double Caudal){
        double min = 9999;
        return (! arbol.isEmpty()) ? calcular (arbol, min, Caudal): min;
    }
    
    private double calcular (GeneralTree<Character> arbol, double min, double Caudal){
        if (arbol.isLeaf()){
            if (Caudal < min)
                min = Caudal;
        } else {
            LinkedList <GeneralTree<Character>> children = (LinkedList) arbol.getChildren();
            int cant = 0;
            for (GeneralTree <Character> child: children)
                cant++;
            System.out.println(arbol.getData() +"Tiene " + cant + " hijos");
            Caudal = Caudal / cant;
            System.out.println(Caudal);
            for (GeneralTree<Character> child: children){
                min = calcular (child, min, Caudal);
            }
        }
        return min;
    } 
}
