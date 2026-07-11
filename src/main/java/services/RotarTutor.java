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
    public void hacer() throws Exception {
        tutorAnterior = curso.getTutor();
        curso.rotarTutor();
        System.out.println("Tutor Acutual: " + curso.getTutor());
    }

    @Override
    public void deshacer() {
        curso.setTutor(tutorAnterior);
        System.out.println("Tutor Actual: " + curso.getTutor());
    }
}
