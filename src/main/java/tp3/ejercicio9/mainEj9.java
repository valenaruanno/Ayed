 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp3.ejercicio9;
import tp3.ejercicio1.GeneralTree;
/**
 *
 * @author valen aruanno
 */
public class mainEj9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        GeneralTree <Integer> HI= new GeneralTree <Integer> (5);
        HI.addChild(new GeneralTree <Integer> (5));
        HI.addChild(new GeneralTree <Integer> (8));
        
        GeneralTree<Integer> HD = new GeneralTree<Integer> (7);
        HD.addChild(new GeneralTree <Integer> (9));
        HD.addChild(new GeneralTree <Integer> (7));
        
        GeneralTree <Integer> arbol = new GeneralTree <Integer> (2);
        arbol.addChild(HI);
        arbol.addChild(HD);
        arbol.addChild(new GeneralTree <Integer> (2));
        
        System.out.println (ParcialArboles.esDeSeleccion(arbol));
    }
    
}
