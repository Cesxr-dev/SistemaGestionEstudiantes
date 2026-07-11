/*
 * 
 */
package services;

import interfaces.IAccion;
import model.Curso;
import model.Estudiante;

//** @author Julian Daniel Ramirez Garcia

public class InscribirEstudiante implements IAccion {

    private Curso curso;
    private Estudiante estudiante;

    public InscribirEstudiante(Curso curso, Estudiante estudiante) {
        this.curso = curso;
        this.estudiante = estudiante;
    }
    
    @Override
    public void hacer() throws Exception {
        curso.inscribirEstudiante(estudiante);
        estudiante.getCalificaciones().addCalificacion(curso.getClave(), null);
    }
    
    
    @Override
    public void deshacer() throws Exception {
        curso.eliminarEstudiante(estudiante);
        estudiante.getCalificaciones().dropCalificacion(curso.getClave());
    }
}
