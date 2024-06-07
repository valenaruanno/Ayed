/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreParcialArboles.ej6p3;
import java.util.LinkedList;
import tp3.ejercicio1.GeneralTree;
import tp1.Ej8.Queue;
/**
 *
 * @author valen
 */
public class RedAguaPotable {
    private GeneralTree<Character> arbol;

    public RedAguaPotable() {
    }

    public RedAguaPotable(GeneralTree<Character> arbol) {
        this.arbol = arbol;
    }
    
    
    
    public double minimoCaudal (double caudal){
        double min = 9999;
        return (!arbol.isEmpty()) ? calcular (arbol, caudal, min): min;
    }
    
    private double calcular (GeneralTree<Character> ag, double caudal, double min){
        if (ag.isLeaf()){
            if (caudal < min)
                min = caudal;
        } else {
            int cant = 0;
            LinkedList<GeneralTree<Character>> children = (LinkedList) ag.getChildren();
            for (GeneralTree<Character> child : children)
                cant++;
            for (GeneralTree<Character> child : children){
                double cau = caudal / cant;
                min = calcular (child, cau, min);
            }
        }
        return min;
    }
}
