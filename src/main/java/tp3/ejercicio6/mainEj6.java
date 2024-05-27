/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp3.ejercicio6;
import java.util.LinkedList;
import tp3.ejercicio1.GeneralTree;
/**
 *
 * @author valen aruanno
 */
public class mainEj6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneralTree<Character> HD = new GeneralTree<Character> ('d');
        HD.addChild(new GeneralTree <Character> ('f'));
        GeneralTree<Character> HII = new GeneralTree<Character> ('g');
        HII.addChild(new GeneralTree <Character> ('h'));
        HD.addChild(HII);
        
        GeneralTree<Character> HM = new GeneralTree<Character> ('c');
        GeneralTree<Character> HI = new GeneralTree<Character> ('b');
        HI.addChild(new GeneralTree<Character> ('e'));
        
        GeneralTree<Character> arbol = new GeneralTree<Character> ('a');
        arbol.addChild(HI);
        arbol.addChild(HM);
        arbol.addChild(HD);
        
        RedAguaPotable red = new RedAguaPotable (arbol);
        System.out.println("El caudal minimo es: " + red.minimoCaudal(600));
    }
    
}
