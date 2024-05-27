/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp3.ejercicio11;
import tp3.ejercicio1.GeneralTree;
/**
 *
 * @author valen aruanno
 */
public class mainEj11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneralTree <Integer> HIII = new GeneralTree <Integer> (7);
        GeneralTree <Integer> HIID = new GeneralTree <Integer> (8);
        GeneralTree <Integer> HII = new GeneralTree <Integer> (4);
        HII.addChild(HIII);
        HII.addChild(HIID);
        
        GeneralTree <Integer> HMM = new GeneralTree <Integer> (9);
        GeneralTree <Integer> HM = new GeneralTree <Integer> (5);
        HM.addChild(HMM);
        
        GeneralTree <Integer> HDDD = new GeneralTree <Integer> (10);
        GeneralTree <Integer> HDD = new GeneralTree <Integer> (6);
        HDD.addChild(HDDD);
        
        GeneralTree <Integer> HI = new GeneralTree <Integer> (2);
        HI.addChild(HII);
        HI.addChild(HM);
        
        GeneralTree <Integer> HD = new GeneralTree <Integer> (3);
        HD.addChild(HDD);
        
        GeneralTree <Integer> arbol = new GeneralTree <Integer> (1);
        arbol.addChild(HI);
        arbol.addChild(HD);
        
        System.out.println(ParcialArboles.resolver(arbol));
    }
    
}
