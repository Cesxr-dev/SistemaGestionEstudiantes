/*
 * 
 */
package model;

//** @author Julian Daniel Ramirez Garcia

public class PromedioEstudiante implements Comparable<PromedioEstudiante> {
    
    private Double promedio;
    private Estudiante estudiante;

    public PromedioEstudiante(Double promedio, Estudiante estudiante) {
        this.promedio = promedio;
        this.estudiante = estudiante;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public int compareTo(PromedioEstudiante o) {
        return Double.compare(promedio, o.promedio);
    }
    
    @Override
    public String toString() {
        return "Promedio: " + promedio + ", Estudiante: " + estudiante.getMatricula();
    }
}
