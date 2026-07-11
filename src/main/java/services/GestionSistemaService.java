/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import implementacion.AVLTree;
import implementacion.BinarySearchTree;
import implementacion.Diccionario;
import implementacion.LinkedListQueue;
import interfaces.IAccion;
import interfaces.IQueue;
import java.util.Stack;
import model.Curso;
import model.Estudiante;
import model.PromedioEstudiante;
import model.SolicitudCalificacion;

/**
 * @author Julian Daniel Ramirez Garcia & Cesar Demian Quiroz Montijo 252975
 */

public class GestionSistemaService {
    private final BinarySearchTree<Estudiante> arbolEstudiantes = new BinarySearchTree<>();
    private final Diccionario<String,Curso> tablaCursos = new Diccionario<>(20);
    private IQueue<SolicitudCalificacion> colaSolicitudes = new LinkedListQueue<>();
    private Stack<IAccion> pilaAcciones = new Stack<>();
    
    
    /**
     * Metodo para agregar un estudiante al arbol BST
     * @param est Estudiante a agregar
     */
    public void agregarEstudiante(Estudiante est){
        RegistrarEstudiante accion = new RegistrarEstudiante(arbolEstudiantes, est);
        accion.hacer();
        pilaAcciones.push(accion);
    }
    
    
    public Estudiante  buscarEstudiante(String matricula){
        Estudiante temporal = new Estudiante(matricula); 
        return arbolEstudiantes.find(temporal);
    }
    
    /**
     * Metodo para agregar un curso al Diccionario/Tabla de cursos
     * @param c Curso a insertar
     * @throws Exception si clave del curso ya existe en el diccionario.
     */
    public void agregarCurso(Curso c) throws Exception{
        AgregarCurso accion = new AgregarCurso(tablaCursos, c);
        accion.hacer();
        pilaAcciones.push(accion);
    }
    
    
    /**
     * Metodo para eliminar un curso del Catalogo de Cursos
     * @param clave
     * @throws Exception si la clave no se encuentra en el sistema
     */
    public void eliminarCurso(String clave) throws Exception{
        EliminarCurso accion = new EliminarCurso(tablaCursos, tablaCursos.get(clave));
        accion.hacer();
        pilaAcciones.push(accion);
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
        InscribirEstudiante accion = new InscribirEstudiante(tablaCursos.get(claveCurso), buscarEstudiante(matricula));
        accion.hacer();
        pilaAcciones.push(accion);
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
    
    
    /**
     * Envia una solicitud de calificacion a la cola generica (FIFO) tras validar
     * que sea estructuradamente correcta y que el estudiante exista en el sistema.
     * 
     * @param solicitud La solicitud a encolar.
     * @throws IllegalArgumentException Si la solicitud es nula o contiene datos invalidos.
     * @throws NullPointerException Si el estudiante no existe en el Arbol Binario (BST).
     */
    public void enviarSolicitud(SolicitudCalificacion solicitud) {
        // 1Validar que el objeto solicitud exista
        if (solicitud == null) {
            throw new IllegalArgumentException("Error: La solicitud no puede ser nula.");
        }
        
        // Validar consistencia de los datos internos de la solicitud
        if (solicitud.getMatricula() == null || solicitud.getMatricula().trim().isEmpty()) {
            throw new IllegalArgumentException("Error: La matricula de la solicitud no es valida.");
        }
        if (solicitud.getClave()== null || solicitud.getClave().trim().isEmpty()) {
            throw new IllegalArgumentException("Error: La clave del curso no puede estar vacia.");
        }
        // Validar que la nota este en un rango logico escolar (ejemplo: 0.0 a 10.0 o 0 a 100)
        if (solicitud.getNota() < 0.0 || solicitud.getNota() > 10.0) { 
            throw new IllegalArgumentException("Error: La calificacion debe estar en el rango de 0.0 a 10.0.");
        }

        // Validar existencia previa del estudiante
        Estudiante estTemp = new Estudiante(solicitud.getMatricula());
        if (arbolEstudiantes.find(estTemp) == null) {
            throw new NullPointerException("Error: No se puede encolar la solicitud porque el estudiante con matricula " 
                    + solicitud.getMatricula() + " no esta registrado en el sistema.");
        }

        // Si paso todos los filtros, entra a la cola
        colaSolicitudes.enqueue(solicitud);
    }
    
    /**
     * Procesa la siguiente solicitud en la cola.
     * Busca al estudiante en el BST y actualiza o añade la calificacion.
     * 
     * @return Mensaje con el resultado de la operacion para mostrar en la UI
     */
    public String procesarSiguienteSolicitud() {
        // Validar si hay elementos en la cola genérica
        if (colaSolicitudes.isEmpty()) {
            return "No hay solicitudes pendientes en la cola.";
        }
        
        // Desencolar (Dequeue) la solicitud correspondiente 
        SolicitudCalificacion solicitud = colaSolicitudes.dequeue();
        
        // Buscar al estudiante en el Árbol Binario de Búsqueda (BST)
        // Creamos un estudiante temporal con la matrícula para la comparación del BST
        Estudiante estudianteTemp= new Estudiante(solicitud.getMatricula());
        Estudiante estudianteEncontrado = arbolEstudiantes.find(estudianteTemp);
        
        if (estudianteEncontrado == null) {
            return "Error: El estudiante con matricula " + solicitud.getMatricula() + " no existe en el sistema.";
        }
        
        // Intentar actualizar la calificación del curso (setCalificacion)
        // Si el curso ya existia, se modifica y devuelve true.
        boolean actualizada = estudianteEncontrado.getCalificaciones().setCalificacion(
            solicitud.getClave(), 
            solicitud.getNota()
        );
        
        // Si no se pudo actualizar (porque es un curso nuevo), se agrega (addCalificacion)
        if (!actualizada) {
            estudianteEncontrado.getCalificaciones().addCalificacion(
                solicitud.getClave(), 
                solicitud.getNota()
            );
            return "Nueva calificacion agregada con exito al estudiante: " + estudianteEncontrado.getNombreCompleto() 
                    + " en el curso [" + solicitud.getClave()+ "].";
        }
        
        return "Calificacion modificada con exito para el estudiante: " + estudianteEncontrado.getNombreCompleto() 
                + " en el curso [" + solicitud.getClave() + "].";
    }
    
    public void rotarTutor() throws Exception {
        RotarTutor accion = new RotarTutor();
        accion.hacer();
        pilaAcciones.push(accion);
    }
    
    public void listarEstudiantesPorPromedio() {
        AVLTree<PromedioEstudiante> estudiantesPromedio = new AVLTree<>();
        for(Estudiante estudiante : arbolEstudiantes) {
            Double promedio = estudiante.getCalificaciones().calcularPromedio();
            PromedioEstudiante dato = new PromedioEstudiante(promedio, estudiante);
            estudiantesPromedio.insert(dato);
        }
        estudiantesPromedio.inOrder();
    }
    
    public void deshacerUltimaAccion() throws Exception {
        pilaAcciones.pop().deshacer();
    }
}
