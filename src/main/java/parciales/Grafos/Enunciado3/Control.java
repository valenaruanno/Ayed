/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Grafos.Enunciado3;

/**
 *
 * @author valen
 */
public class Control {
    private String lugar;
    private String controlado;

    public Control(String lugar, String controlado) {
        this.lugar = lugar;
        this.controlado = controlado;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getControlado() {
        return controlado;
    }

    public void setControlado(String controlado) {
        this.controlado = controlado;
    }
    
    
}
