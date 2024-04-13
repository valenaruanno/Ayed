/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.Ej3;

/**
 *
 * @author valen
 */
public class Profesor {
    private String nombre;
    private String apellido;
    private String email;
    private int catedra;
    private String facultad;

    public Profesor(String nombre, String apellido, String email, int catedra, String facultad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.catedra = catedra;
        this.facultad = facultad;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCatedra() {
        return catedra;
    }

    public void setCatedra(int catedra) {
        this.catedra = catedra;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }
    
    public String tusDatos (){
        return ("Nombre: " + this.getNombre()+ ", apellido: " + this.getApellido()+ ", email: " 
                    + this.getEmail() + ", catedra: " + this.getCatedra() + ", facultad: " + this.getFacultad());
    }
}
