/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp3.ejercicio2;
import tp3.ejercicio1.GeneralTree;
import java.util.List;
import java.util.LinkedList;
import javax.swing.SwingConstants;
/**
 *
 * @author valen aruanno
 */
public class mainEj2 {

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
        GeneralTree <Integer> HD = new GeneralTree <Integer> (17);
        HD.addChild(HDI);
        HD.addChild(HDD);
        
        GeneralTree <Integer> arbol = new GeneralTree <Integer> (15);
        arbol.addChild(HI);
        arbol.addChild(HM);
        arbol.addChild(HD);
        
        LinkedList <Integer> lista = new LinkedList <Integer> ();
        RecorridosAG reco = new RecorridosAG ();
        lista = reco.numerosImparesMayoresQuePreOrden(arbol, 6);
        System.out.println("-------------PRE-ORDEN--------------------");
        for (Integer l: lista)
            System.out.println(l.toString());
        
        lista = reco.numerosImparesMayoresQueInOrden(arbol, 6);
        System.out.println("-------------IN-ORDEN--------------------");
        for (Integer l: lista)
            System.out.println(l.toString());
        
        lista = reco.numerosImparesMayoresQuePostOrden(arbol, 6);
        System.out.println("-------------POST-ORDEN--------------------");
        for (Integer l: lista)
            System.out.println(l.toString());
        
        lista = reco.numerosImparesMayoresQuePorNivel(arbol, 6);
        System.out.println("-------------POR-NIVEL--------------------");
        for (Integer l: lista)
            System.out.println(l.toString());
                    
    }    
}
