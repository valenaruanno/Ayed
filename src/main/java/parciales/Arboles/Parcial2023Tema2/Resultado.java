/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Arboles.Parcial2023Tema2;

import java.util.List;

/**
 *
 * @author valen
 */
public class Resultado {
    private List<Integer> lista;
    private int cantImpares;
    
    public Resultado (List<Integer> lista, int cantImpares){
        this.lista = lista;
        this.cantImpares = cantImpares;
    }

    public List<Integer> getLista() {
        return lista;
    }

    public void setLista(List<Integer> lista) {
        this.lista = lista;
    }

    public int getCantImpares() {
        return cantImpares;
    }

    public void setCantImpares(int cantImpares) {
        this.cantImpares = cantImpares;
    }
    
    
}
