/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp5.ejercicio5;

/**
 *
 * @author valen aruanno
 */
public class Persona {
    private String tipo;
    private String nombre;
    private String domicilio;

    public Persona(String tipo, String nombre, String domicilio) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.domicilio = domicilio;
    }

    Persona() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getTipo() {
        return tipo;
    }

    private void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    private void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    
    
}
