/*
 * 
 */
package services;

import implementacion.Diccionario;
import implementacion.DoubleLinkedListCircular;
import implementacion.LinkedList;
import interfaces.IAccion;
import model.Curso;
import model.Estudiante;

//** @author Julian Daniel Ramirez Garcia

public class EliminarCurso implements IAccion {

    private Diccionario<String, Curso> cursos;
    private Curso curso;

    public EliminarCurso(Diccionario<String, Curso> cursos, Curso curso) {
        if (cursos == null || curso == null) throw new IllegalArgumentException();
        this.cursos = cursos;
        this.curso = curso;
    }
    
    @Override
    public void hacer() {
        
    }

    @Override
    public void deshacer() {
        
    }
}
