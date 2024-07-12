/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Arboles.Parcial2023Tema1;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author valen
 */
public class Resultado {
    private List<Integer> lista = new LinkedList<Integer> ();
    private int cantPares = 0;

    public Resultado (List<Integer> lista, int cantPares){
        this.lista = lista;
        this.cantPares = cantPares;
    }
    
    public List<Integer> getLista() {
        return lista;
    }

    public void setLista(List<Integer> lista) {
        this.lista = lista;
    }

    public int getCantPares() {
        return cantPares;
    }

    public void setCantPares(int cantPares) {
        this.cantPares = cantPares;
    }
    
}
