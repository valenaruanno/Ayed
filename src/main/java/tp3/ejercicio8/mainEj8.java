/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp3.ejercicio8;
import tp3.ejercicio1.GeneralTree;
/**
 *
 * @author valen aruanno
 */
public class mainEj8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneralTree <Integer> HI = new GeneralTree <Integer> (1);
        HI.addChild(new GeneralTree <Integer> (1));
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
        arbol.addChild(new GeneralTree <Integer> (1));
        arbol.addChild(new GeneralTree <Integer> (1));
        arbol.addChild(new GeneralTree <Integer> (1));
        arbol.addChild(HI);
        arbol.addChild(HM);
        arbol.addChild(HD);
        
        Navidad navidad = new Navidad (arbol);
        System.out.println(navidad.esAbetoNavidenio());
    }
    
}
