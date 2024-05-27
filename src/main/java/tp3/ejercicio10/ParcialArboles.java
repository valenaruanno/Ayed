/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ejercicio10;
import tp3.ejercicio1.GeneralTree;
import java.util.List;
import java.util.LinkedList;
/**
 *
 * @author valen aruanno
 */
public class ParcialArboles {
    public static List <Integer> resolver (GeneralTree<Integer> arbol){
        List <Integer> caminoAct = new LinkedList <Integer> ();
        List <Integer> camino = new LinkedList <Integer> ();
        int i;
        if (!arbol.isEmpty()){
            i = resolver (arbol, caminoAct, camino, 0, 0, 0);
            System.out.println(i);
        }
        return camino;
    }
    
    private static int resolver (GeneralTree<Integer> arbol, List<Integer> caminoAct, List<Integer> camino, int nivel, int resCaminoAct, int resCamino){
        if (arbol.getData() == 1){
            camino.add(1);
            resCaminoAct = resCaminoAct + (nivel * 1);
        }
        if (!arbol.isLeaf()){
            List <GeneralTree <Integer>> children = arbol.getChildren();
            for (GeneralTree <Integer> child : children){
                resCaminoAct = resolver(child, caminoAct, camino, nivel++, resCaminoAct, resCamino);
                caminoAct.removeLast();
            }
        } else{
            if (resCaminoAct > resCamino){
                resCamino = resCaminoAct;
                camino.clear();
                camino.addAll(caminoAct);
            }
        }
        return resCaminoAct;
    }
}
