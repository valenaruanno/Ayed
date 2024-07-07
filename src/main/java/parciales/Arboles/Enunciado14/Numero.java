/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Arboles.Enunciado14;

/**
 *
 * @author valen
 */
public class Numero {
    private int num;
    private int nivel;

    public Numero(int num, int nivel) {
        this.num = num;
        this.nivel = nivel;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    public String toString (){
        return num + " nivel " + nivel;
    }
}
