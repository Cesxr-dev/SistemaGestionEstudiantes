/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * @author Julian Daniel Ramirez Garcia & Cesar Demian Quiroz Montijo 252975
 */
public class Estudiante implements Comparable<Estudiante> {

    private String matricula; // EJ: ABCD1234
    private String nombreCompleto;
    private String telefono;
    private String correo;
    private String direccionPostal; // calle,numero,colonia,ciudad
    private Calificaciones calificaciones;


    public Estudiante(String matricula, String nombreCompleto, String telefono, String correo, String direccionPostal) {
        this.matricula = matricula;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.correo = correo;
        this.direccionPostal = direccionPostal;
        this.calificaciones = new Calificaciones();
    }
    
    public Estudiante(String matricula) {
        this.matricula = matricula;
        this.calificaciones = new Calificaciones();
    }
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccionPostal() {
        return direccionPostal;
    }

    public void setDireccionPostal(String direccionPostal) {
        this.direccionPostal = direccionPostal;
    }
    
    public Calificaciones getCalificaciones() {
        return calificaciones;
    }

    @Override
    public String toString() {
        return "Estudiante{" + 
                "matricula='" + matricula + '\'' + 
                ", nombreCompleto='" + nombreCompleto + '\'' + 
                ", telefono='" + telefono + '\'' + 
                ", correo='" + correo + '\'' + 
                ", direccionPostal='" + direccionPostal + '\'' + 
                ", calificaciones=" + calificaciones.toString() + 
                '}';
    }

    
    
    
    
    @Override
    public int compareTo(Estudiante o) {
        return this.matricula.compareTo(o.getMatricula());
    }
}
