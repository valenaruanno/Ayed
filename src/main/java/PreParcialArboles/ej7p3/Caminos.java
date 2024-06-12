/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PreParcialArboles.ej7p3;
import tp3.ejercicio1.GeneralTree;
import java.util.List;
import java.util.LinkedList;
/**
 *
 * @author valen aruanno
 */
public class Caminos {
    private GeneralTree<Integer> arbol;

    public Caminos(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public GeneralTree<Integer> getArbol() {
        return arbol;
    }

    public void setArbol(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public List<Integer> caminoAHojaMasLejana (){
        List<Integer> camino = new LinkedList<Integer> ();
        if (!arbol.isEmpty()){
            int max = -1;
            List<Integer> caminoAct = new LinkedList<Integer> ();
            max = buscar (arbol, camino, caminoAct, max);
        }
        return camino;
    }
    
    private int buscar (GeneralTree<Integer> ag, List<Integer> camino, List<Integer> caminoAct, int max){
        caminoAct.add(ag.getData());
        if (ag.isLeaf()){
            if (caminoAct.size() > max){
                max = caminoAct.size();
                camino.removeAll(camino);
                camino.addAll(caminoAct);
            }
        } else{
            LinkedList<GeneralTree<Integer>> children = (LinkedList) ag.getChildren();
            for (GeneralTree<Integer> child : children){
                max = buscar (child, camino, caminoAct, max);
            }
        }
        caminoAct.remove(ag.getData()); 
        return max;
    }
}
