/*
 * 
 */
package services;

import interfaces.IAccion;
import model.Curso;
import model.Estudiante;

//** @author Julian Daniel Ramirez Garcia

public class RotarTutor implements IAccion {

    private Curso curso;
    private Estudiante tutorAnterior;
    
    @Override
    public void hacer() {
        tutorAnterior = curso.getTutor();
        curso.
    }

    @Override
    public void deshacer() {
        
    }
}
