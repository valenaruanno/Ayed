/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Arboles.Enunciado4;

import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen
 */
public class Parcial {
    public List<List<Character>> caminosPares (GeneralTree<Character> arbol){
        List<List<Character>> caminos = new LinkedList<List<Character>> ();
        List<Character> caminoAct = new LinkedList<Character> ();
        if (!arbol.isEmpty())
            buscarCaminos(arbol, caminos, caminoAct, 0);
        return caminos;
    }
    
    private void buscarCaminos (GeneralTree<Character> arbol, List<List<Character>> caminos, List<Character> caminoAct, int cant){
        caminoAct.add(arbol.getData());
        System.out.println(caminoAct);
        cant++;
        if ((arbol.isLeaf()) && (cant % 2 == 0)){
            caminos.add(new LinkedList<Character> (caminoAct));
        } else {
            List<GeneralTree<Character>> children = arbol.getChildren();
            for (GeneralTree<Character> child : children)
                buscarCaminos (child, caminos, caminoAct, cant);
        }
        caminoAct.remove(caminoAct.size() - 1);
    }
    
    public static void main(String args[]) {
        Parcial p = new Parcial();
        
        List<GeneralTree<Character>> subChildren1 = new LinkedList<GeneralTree<Character>>();
        subChildren1.add(new GeneralTree<Character>('E'));
        GeneralTree<Character> a1 = new GeneralTree<Character>('B', subChildren1);
        
        List<GeneralTree<Character>> subChildren2 = new LinkedList<GeneralTree<Character>>();
        subChildren2.add(new GeneralTree<Character>('H'));
        subChildren2.add(new GeneralTree<Character>('I'));
        GeneralTree<Character> subAb1 = new GeneralTree<Character>('F', subChildren2);
        List<GeneralTree<Character>> subChildren3 = new LinkedList<GeneralTree<Character>>();
        subChildren3.add(subAb1);
        subChildren3.add(new GeneralTree<Character>('G'));
        GeneralTree<Character> a2 = new GeneralTree<Character>('C', subChildren3);
        
        List<GeneralTree<Character>> arbol = new LinkedList<GeneralTree<Character>>();
        arbol.add(a1);
        arbol.add(a2);
        arbol.add(new GeneralTree<Character>('D'));
        GeneralTree<Character> a = new GeneralTree<Character>('A', arbol);
        List<List<Character>> lis = p.caminosPares(a);
        
        System.out.println("--------------------------------------------------------------------------------");
        for(List<Character>l: lis) {
            System.out.println(l);
        }
    }
}
