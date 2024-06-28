/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Grafos.GrafosEnunciado1;

/**
 *
 * @author valen
 */
class Ciudad {
    private String nombre;
    private String fase;

    public Ciudad(String nombre, String fase) {
        this.nombre = nombre;
        this.fase = fase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String cantDias) {
        this.fase = cantDias;
    }
    
}
