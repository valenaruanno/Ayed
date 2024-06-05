/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ejercicio7;
import tp3.ejercicio1.GeneralTree;
import java.util.List;
import java.util.LinkedList;
/**
 *
 * @author valen aruanno
 */
public class Caminos {
    private GeneralTree<Integer> arbol = new GeneralTree<Integer> ();

    public Caminos(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public List <Integer> caminoAHojaMasLejana (){
        List <Integer> lista = new LinkedList <Integer> ();
        List<Integer> definitivo = new LinkedList<Integer> ();
        return (!arbol.isEmpty()) ? camino (arbol, lista, definitivo): definitivo;
    } 
    
    private List<Integer> camino (GeneralTree<Integer> arbol, List<Integer> lista, List<Integer> definitivo){
        if (!arbol.isLeaf()){
            lista.add(arbol.getData());
            List <GeneralTree<Integer>> children = (LinkedList) arbol.getChildren();
            for (GeneralTree <Integer> child: children){
                camino (child, lista, definitivo);
                lista.remove(child);
            }
        } else{
            lista.add(arbol.getData());
            if (lista.size() > definitivo.size()){
                if (!definitivo.isEmpty()){
                    definitivo.removeAll(definitivo);
                }
                definitivo.addAll(lista);
            }
        }
        return definitivo;
    }
}
