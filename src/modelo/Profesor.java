/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Milka
 */
public class Profesor {
    private String cProf;
    private String nombre;
    private String grado;
    private String fechaIngreso;

    public Profesor() {
    }

    public Profesor(String cProf, String nombre, String grado, String fechaIngreso) {
        this.cProf = cProf;
        this.nombre = nombre;
        this.grado = grado;
        this.fechaIngreso = fechaIngreso;
    }

    public String getCProf() {
        return cProf;
    }

    public void setCProf(String cProf) {
        this.cProf = cProf;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    
}
