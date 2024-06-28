/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Grafos.ParcialGrafosSimulacro;

/**
 *
 * @author valen
 */
class Ciudad {
    private String nombre;
    private int cantDias;

    public Ciudad(int cantDias,String nombre) {
        this.nombre = nombre;
        this.cantDias = cantDias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantDias() {
        return cantDias;
    }

    public void setCantDias(int cantDias) {
        this.cantDias = cantDias;
    }
    
}
