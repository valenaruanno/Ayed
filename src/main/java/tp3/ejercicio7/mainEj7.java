/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp3.ejercicio7;
import tp3.ejercicio1.GeneralTree;
import java.util.List;
import java.util.LinkedList;
/**
 *
 * @author valen aruanno
 */
public class mainEj7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneralTree <Integer> HII = new GeneralTree <Integer> (8);
        GeneralTree <Integer> HID = new GeneralTree <Integer> (23);
        GeneralTree <Integer> HI = new GeneralTree <Integer> (16);
        HI.addChild(HII);
        HI.addChild(HID);
    
        GeneralTree <Integer> HMI = new GeneralTree <Integer> (9);
        GeneralTree <Integer> HM = new GeneralTree <Integer> (7);
        HM.addChild(HMI);
        
        GeneralTree <Integer> HDI = new GeneralTree <Integer> (1);
        GeneralTree <Integer> HDD = new GeneralTree <Integer> (3);
        HDD.addChild(new GeneralTree<Integer> (10));
        GeneralTree <Integer> HD = new GeneralTree <Integer> (17);
        HD.addChild(HDI);
        HD.addChild(HDD);
        
        GeneralTree <Integer> arbol = new GeneralTree <Integer> (15);
        arbol.addChild(HI);
        arbol.addChild(HM);
        arbol.addChild(HD);
        
        Caminos camino = new Caminos (arbol);
        List <Integer> max = new LinkedList<Integer> ();
        max = camino.caminoAHojaMasLejana();
        
        for (Integer pos: max)
            System.out.println(pos);
    }
    
}
