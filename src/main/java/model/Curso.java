/*
 * 
 */
package model;

//** @author Julian Daniel Ramirez Garcia

public class Curso implements Comparable<Curso> {
    private String clave, nombre;
    
    public Curso(String clave, String nombre) {
        if (clave == null || clave.isBlank()) throw new IllegalArgumentException("La clave del curso no puede ser vacia");
        this.clave = clave;
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public int compareTo(Curso o) {
        return this.clave.compareTo(o.clave);
    }
}
