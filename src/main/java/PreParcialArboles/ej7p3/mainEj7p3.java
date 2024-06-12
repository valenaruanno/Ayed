/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PreParcialArboles.ej7p3;
import tp3.ejercicio1.GeneralTree;
import java.util.LinkedList;
/**
 *
 * @author valen aruanno
 */
public class mainEj7p3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneralTree<Integer> HMD = new GeneralTree<Integer> (4);
        HMD.addChild(new GeneralTree <Integer> (7));
        
        GeneralTree<Integer> HI = new GeneralTree<Integer> (2);
        
        GeneralTree<Integer> HMI = new GeneralTree<Integer> (3);
        
        GeneralTree<Integer> HD = new GeneralTree<Integer> (5);
        GeneralTree<Integer> HDD = new GeneralTree<Integer> (6);
        HDD.addChild(new GeneralTree<Integer> (8));
        HD.addChild(HDD);
        
        GeneralTree<Integer> arbol = new GeneralTree<Integer> (1);
        arbol.addChild(HI);
        arbol.addChild(HMI);
        arbol.addChild(HMD);
        arbol.addChild(HD);
        
        Caminos cam = new Caminos (arbol);
        LinkedList<Integer> camino = new LinkedList<Integer> ();
        camino = (LinkedList) cam.caminoAHojaMasLejana();
        
        for (Integer i: camino)
            System.out.println(i);
    }
    
}
