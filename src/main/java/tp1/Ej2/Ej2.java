/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.Ej2;

/**
 *
 * @author valen
 */
public class Ej2 {
    private static int [] numeros;
    
    public static int[] crear (int n){
        numeros = new int[n];
        int mult;
        int i = 0;
        while ((i+1) <= n){
            mult = (i+1)*n;
            numeros [i] = mult;
            i++;
        }
        return numeros;
    }

    public int[] getNumeros() {
        return numeros;
    }

    public void setNumeros(int[] numeros) {
        this.numeros = numeros;
    }
}
