/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import implementacion.BinarySearchTree;
import implementacion.Diccionario;
import model.Curso;
import model.Estudiante;

/**
 *
 * @author Cesar Demian Quiroz Montijo 252975
 */
public class GestionSistemaService {
    private final BinarySearchTree<Estudiante> arbolEstudiantes = new BinarySearchTree<>();
    private final Diccionario<String,Curso> tablaCursos = new Diccionario<>(20);
    
    /**
     * Metodo para agregar un estudiante al arbol BST
     * @param est Estudiante a agregar
     */
    public void agregarEstudiante(Estudiante est){
        arbolEstudiantes.insertar(est);
        
        arbolEstudiantes.inOrder(); // metodo solo para comprobar que funciona el insertar
    }
    
    
    /**
     * Metodo para agregar un curso al Diccionario/Tabla de cursos
     * @param c Curso a insertar
     * @throws Exception si clave del curso ya existe en el diccionario.
     */
    public void agregarCurso(Curso c) throws Exception{
        tablaCursos.put(c.getClave(), c);
    }
    
    
    /**
     * Metodo para eliminar un curso del Catalogo de Cursos
     * @param clave
     * @throws Exception si la clave no se encuentra en el sistema
     */
    public void eliminarCurso(String clave) throws Exception{
        
        
        Curso eliminado = tablaCursos.remove(clave);
        
        if(eliminado == null){
            throw new Exception("El curso con la clave '" + clave + "' no se encuentra registrado en el sistema.");
        }
    }
    
    /**
     * Lista todos los cursos del catalogo de cursos
     */
    public void listarCursos(){
        tablaCursos.imprimirContenido();
    }
    
    
}
