/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.Ej4;

/**
 *
 * @author valen
 */
public class SwapValores {
    public static void swap1 (int x, int y) {
        if (x < y) {
        int tmp = x ;
        x = y ;
        y = tmp;
        }
    }
    public static void swap2 (Integer x, Integer y) {
        if (x < y) {
        int tmp = x ;
        x = y ;
        y = tmp;
        }
    }
}
