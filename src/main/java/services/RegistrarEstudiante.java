/*
 * 
 */
package services;

import implementacion.BinarySearchTree;
import interfaces.IAccion;
import model.Estudiante;

//** @author Julian Daniel Ramirez Garcia

public class RegistrarEstudiante implements IAccion {

    private BinarySearchTree<Estudiante> estudiantes;
    private Estudiante estudiante;

    public RegistrarEstudiante(BinarySearchTree<Estudiante> estudiantes, Estudiante estudiante) {
        if (estudiantes == null || estudiante == null) throw new IllegalArgumentException();
        this.estudiantes = estudiantes;
        this.estudiante = estudiante;
    }
    
    @Override
    public void hacer() {
        estudiantes.insert(estudiante);
    }

    @Override
    public void deshacer() {
        estudiantes.remove(estudiante);
    }
}
