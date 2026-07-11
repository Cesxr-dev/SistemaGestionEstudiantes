/*
 * 
 */
package services;

import implementacion.Diccionario;
import interfaces.IAccion;
import model.Curso;

//** @author Julian Daniel Ramirez Garcia

public class AgregarCurso implements IAccion {

    private Diccionario<String, Curso> cursos;
    private Curso curso;

    public AgregarCurso(Diccionario<String, Curso> cursos, Curso curso) {
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
