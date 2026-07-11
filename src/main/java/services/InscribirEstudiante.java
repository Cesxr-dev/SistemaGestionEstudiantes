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
    
    @Override
    public void hacer() throws Exception {
        curso.inscribirEstudiante(estudiante);
        estudiante.getCalificaciones().
    }

    @Override
    public void deshacer() {
        
    }
}
