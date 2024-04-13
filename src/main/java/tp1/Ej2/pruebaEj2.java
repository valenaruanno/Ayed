/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.Ej2;
import java.util.Scanner;
/**
 *
 * @author valen
 */
public class pruebaEj2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Ej2 prueba = new Ej2();
        int [] numeros;
        Scanner n = new Scanner(System.in);
        prueba.crear (n.nextInt()); 
        numeros = prueba.getNumeros();
        System.out.println ("------------------------------");
        for (int i = 0; i <= (numeros.length - 1); i++){
            System.out.println (numeros[i]);
        }
    }
    
}
