/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ejercicio4;

/**
 *
 * @author valen aruanno
 */
public class AreaEmpresa {
    String representacion;
    int retardo;
    
    public AreaEmpresa (String representacion, int retardo){
        this.representacion = representacion;
        this.retardo = retardo;
    }

    public String getRepresentacion() {
        return representacion;
    }

    public void setRepresentacion(String representacion) {
        this.representacion = representacion;
    }

    public int getRetardo() {
        return retardo;
    }

    public void setRetardo(int retardo) {
        this.retardo = retardo;
    }
    
}
