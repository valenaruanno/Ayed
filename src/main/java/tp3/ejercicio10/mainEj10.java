/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp3.ejercicio10;
import tp3.ejercicio1.GeneralTree;
import java.util.List;
import java.util.LinkedList;
/**
 *
 * @author valen aruanno
 */
public class mainEj10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneralTree <Integer> a = new GeneralTree <Integer> (0);
        a.addChild(new GeneralTree <Integer> (1));
        GeneralTree <Integer> HI = new GeneralTree <Integer> (1);
        HI.addChild(a);
        HI.addChild(new GeneralTree <Integer> (1));
        HI.addChild(new GeneralTree <Integer> (1));
        
        GeneralTree <Integer> HM = new GeneralTree <Integer> (1);
        HM.addChild(new GeneralTree <Integer> (1));
        HM.addChild(new GeneralTree <Integer> (1));
        HM.addChild(new GeneralTree <Integer> (1));
        
        GeneralTree <Integer> HD = new GeneralTree <Integer> (1);
        HD.addChild(new GeneralTree <Integer> (1));
        HD.addChild(new GeneralTree <Integer> (1));
        HD.addChild(new GeneralTree <Integer> (1));
        
        GeneralTree <Integer> arbol = new GeneralTree <Integer> (1);
        arbol.addChild(HI);
        arbol.addChild(HM);
        arbol.addChild(HD);
        
        List <Integer> lista = new LinkedList <Integer> ();
        lista = ParcialArboles.resolver(arbol);
        
        for (Integer b: lista)
            System.out.println(b);
    }   
}
