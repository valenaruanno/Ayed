/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.Ej1;
/**
 *
 * @author valen
 */
public class Ej1 {
    
   public static void mostrarFor (int a, int b){
       for (;a <= b; a++){
           System.out.println(a);       }
   }
    
   public static void mostrarWhile (int a, int b){
       while (a <= b){
           System.out.println (a);
           a++;
       }
   }
   public static void mostrarRecursivo (int a, int b){
       if (a<=b){
           System.out.println (a);
           a++;
           Ej1.mostrarRecursivo(a, b);
       }
   }
    }

