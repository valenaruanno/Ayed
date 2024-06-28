/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciales.Grafos.ParcialNoviembre2022;

/**
 *
 * @author valen
 */
class Estadios {
    private String nombre;
    private String nombreCiudad;

    public Estadios( String nombreCiudad, String nombre) {
        this.nombre = nombre;
        this.nombreCiudad = nombreCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
    
    
}
