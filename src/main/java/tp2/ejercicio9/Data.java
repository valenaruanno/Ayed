/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2.ejercicio9;

/**
 *
 * @author valen aruanno
 */
public class Data {
    int sum;
    int dif;
    
    public Data (int sum, int dif){
        this.sum = sum;
        this.dif = dif;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getDif() {
        return dif;
    }

    public void setDif(int dif) {
        this.dif = dif;
    }
    
    public String toString (){
        return this.getSum() +"|"+ this.getDif();
    }
}
