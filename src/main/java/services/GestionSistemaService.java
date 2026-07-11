/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import implementacion.BinarySearchTree;
import implementacion.Diccionario;
import implementacion.DoubleLinkedListCircular;
import implementacion.LinkedList;
import model.Curso;
import model.Estudiante;

/**
 * @author Julian Daniel Ramirez Garcia & Cesar Demian Quiroz Montijo 252975
 */

public class GestionSistemaService {
    private final BinarySearchTree<Estudiante> arbolEstudiantes = new BinarySearchTree<>();
    private final Diccionario<String,Curso> tablaCursos = new Diccionario<>(20);
    private final LinkedList<Estudiante> inscritos = new LinkedList<>();
    private final DoubleLinkedListCircular<Estudiante> enEspera = new DoubleLinkedListCircular<>();
    
    /**
     * Metodo para agregar un estudiante al arbol BST
     * @param est Estudiante a agregar
     */
    public void agregarEstudiante(Estudiante est){
        arbolEstudiantes.insertar(est);
        
        arbolEstudiantes.inOrder(); // metodo solo para comprobar que funciona el insertar
    }
    
    
    public Estudiante  buscarEstudiante(String matricula){
        Estudiante temporal = new Estudiante(matricula); 
        return arbolEstudiantes.buscar(temporal);
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
    
    
    /**
     * Metodo que obtiene un estudiante del bst y el curso del diccionario , verifica que existan y si pasan la validacion se pasa a invocar la funcion
     * inscribirEstudiante(Estudiante est) de model.curso
     * @param matricula
     * @param claveCurso
     * @throws Exception 
     */
    public void inscribirEstudianteACurso(String matricula, String claveCurso) throws Exception {
        // Buscamos si el estudiante existe en el arbol BST
        Estudiante est = buscarEstudiante(matricula);
        if (est == null) {
            throw new Exception("El estudiante con matricula " + matricula + " no existe.");
        }

        // Buscamos si el curso existe en el Diccionario
        Curso curso = tablaCursos.get(claveCurso);
        if (curso == null) {
            throw new Exception("El curso con clave " + claveCurso + " no existe.");
        }

        // llamamos inscribirEstudiante de la clase curso (el ya sabe su capacidad y tiene sus listas)
        curso.inscribirEstudiante(est);
    }
    
    
    /**
     * Muestra todos los inscritos en x curso
     * @param claveCurso
     * @throws Exception 
     */
    public void mostrarInscritosDeCurso(String claveCurso) throws Exception {
        Curso curso = tablaCursos.get(claveCurso);
        if (curso == null) {
            throw new Exception("El curso con clave " + claveCurso + " no existe.");
        }
        
        curso.mostrarTodosLosInscritos();
    }
    
    
    /**
     * Muestra la fila de espera del curso, 
     * @param clave
     * @param n La cantidad que quieres que te muestre, en caso de ser mas alta que el tamanio de la lista, se muestran todos los estudiantes de la fila
     * @throws Exception si el curso con esa clave no existe
     */
    public void mostrarFilaEsperaDeCurso(String clave, int n) throws Exception {
        Curso curso = tablaCursos.get(clave);
        if (curso == null) {
            throw new Exception("El curso con clave " + clave + " no existe.");
        }
        
        curso.mostrarPrimerosEnEspera(n);
    }
    
    
}
