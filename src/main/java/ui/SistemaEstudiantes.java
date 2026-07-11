/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ui;

import java.util.Scanner;
import model.Curso;
import model.Estudiante;
import model.SolicitudCalificacion;
import services.GestionSistemaService;

/**
 * @author Julian Daniel Ramirez Garcia & Cesar Demian Quiroz Montijo 252975
 */

public class SistemaEstudiantes {
    private static final Scanner scanner = new Scanner(System.in);
    
    private static final  GestionSistemaService gestionService = new GestionSistemaService();

    public static void main(String[] args) {
        menuPrincipal();
    }
    
    public static void menuPrincipal() {
        int opcionPrincipal;
        
        do {

            System.out.println("--- SISTEMA DE GESTION DE ESTUDIANTES ---");

            System.out.println("1. Estudiantes");
            System.out.println("2. Cursos");
            System.out.println("3. Inscripciones");
            System.out.println("4. Calificaciones");
            System.out.println("5. Acciones");
            System.out.println("6. Reportes");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: ");
            
            try {
                opcionPrincipal = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcionPrincipal = 0;
            }

            switch (opcionPrincipal) {
                case 1 -> subMenuEstudiantes();
                case 2 -> subMenuCursos();
                case 3 -> subMenuInscripciones();
                case 4 -> subMenuCalificaciones();
                case 5 -> subMenuAcciones();
                case 6 -> subMenuReportes();
                case 7 -> System.out.println("\nSaliendo del sistema...");
                default -> System.out.println("\nOpcion no valida. Intente de nuevo.");
            }
        } while (opcionPrincipal != 7);
    }
    
    private static void subMenuEstudiantes() {
        System.out.println("\n--- SUBMENU: ESTUDIANTES ---");
        System.out.println("1. Registrar estudiante");
        System.out.println("2. Buscar estudiante por matricula");
        System.out.println("3. Volver al menu principal");
        System.out.print("Seleccione una opcion: ");
        String op = scanner.nextLine();
        
        switch (op) {
            case "1" -> ejecutarRegistroEstudiante();
            case "2" -> buscarEstudiantePorMatricula();
            case "3" -> {}
            default -> System.out.println("\nOpcion no valida.");
        }
    }

    private static void subMenuCursos() {
        System.out.println("\n--- SUBMENU: CURSOS ---");
        System.out.println("1. Agregar curso");
        System.out.println("2. Eliminar curso");
        System.out.println("3. Listar cursos");
        System.out.println("4. Volver al menu principal");
        System.out.print("Seleccione una opcion: ");
        String op = scanner.nextLine();
        
        switch (op) {
            case "1" -> agregarCursoAlCatalogo();
            case "2" -> eliminarCurso();
            case "3" -> listarCatalogoCursos();
            case "4" -> {}
            default -> System.out.println("\nOpcion no valida.");
        }
    }

    private static void subMenuInscripciones() {
        System.out.println("\n--- SUBMENU: INSCRIPCIONES ---");
        System.out.println("1. Inscribir estudiante en curso");
        System.out.println("2. Mostrar lista de inscritos de un curso");
        System.out.println("3. Mostrar lista de espera de un curso");
        System.out.println("4. Volver al menu principal");
        System.out.print("Seleccione una opcion: ");
        String op = scanner.nextLine();
        
        switch (op) {
            case "1" -> inscribirEstudiante();
            case "2" -> mostrarListaCursoInscritos();
            case "3" -> mostrarListaCursoEnEspera();
            case "4" -> {}
            default -> System.out.println("\nOpcion no valida.");
        }
    }

    private static void subMenuCalificaciones() {
        System.out.println("\n--- SUBMENU: CALIFICACIONES ---");
        System.out.println("1. Enviar solicitud de calificacion (colas)");
        System.out.println("2. Procesar siguiente solicitud");
        System.out.println("3. Volver al menu principal");
        System.out.print("Seleccione una opcion: ");
        String op = scanner.nextLine();
        
        switch (op) {
            case "1" -> enviarSolicitudCalificacion();
            case "2" -> procesarSolicitudCalificacion();
            case "3" -> {}
            default -> System.out.println("\nOpcion no valida.");
        }
    }

    private static void subMenuAcciones() {
        System.out.println("\n--- SUBMENU: ACCIONES ---");
        System.out.println("1. Deshacer ultima accion");
        System.out.println("2. Volver al menu principal");
        System.out.print("Seleccione una opcion: ");
        String op = scanner.nextLine();
        
        switch (op) {
            case "1" -> System.out.println("");
            case "2" -> {}
            default -> System.out.println("\nOpcion no valida.");
        }
    }

    private static void subMenuReportes() {
        System.out.println("\n--- SUBMENU: REPORTES ---");
        System.out.println("1. Listar estudiantes ordenados por promedio");
        System.out.println("2. Rotar rol de tutor/lider de proyecto");
        System.out.println("3. Volver al menu principal");
        System.out.print("Seleccione una opcion: ");
        String op = scanner.nextLine();
        
        switch (op) {
            case "1" -> System.out.println("");
            case "2" -> System.out.println("");
            case "3" -> {}
            default -> System.out.println("\nOpcion no valida.");
        }
    }
    
    private static void ejecutarRegistroEstudiante(){
        System.out.println("\n=== REGISTRO DE NUEVO ESTUDIANTE ===");
    
        System.out.print("Matricula (Ej. ABC1234): ");
        String matricula = scanner.nextLine().toUpperCase();

        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();

        System.out.print("Telefono (solo numeros): ");
        String telefono = scanner.nextLine();

        System.out.print("Correo electronico: ");
        String correo = scanner.nextLine();

        System.out.print("Direccion Postal (calle, numero, colonia, ciudad): ");
        String direccionPost = scanner.nextLine();
        
        Estudiante nuevoEstudiante = new Estudiante(matricula, nombre, telefono, correo, direccionPost);
        
        try{
            gestionService.agregarEstudiante(nuevoEstudiante);
            
            System.out.println("Estudiante registrado con exito!");
            
        }catch(Exception e){
            System.out.println("Error:" + e.getMessage());
            System.out.println("No se pudo completar el registro. Intente de nuevo.");
        }
    }
    
    private static void buscarEstudiantePorMatricula(){
        System.out.println("\n=== BUSQUEDA DE ESTUDIANTE POR MATRICULA ===");
    
        System.out.print("Matricula (Ej. ABC1234): ");
        String matricula = scanner.nextLine().toUpperCase();
        
        
        while(matricula.isBlank()){
            System.out.println(" ERROR: Debes llenar todos los campos.");
            
            System.out.print("Matricula (Ej. ABC1234): ");
            matricula = scanner.nextLine().toUpperCase();
        }
        
        try{
            Estudiante encontrado = gestionService.buscarEstudiante(matricula);
            System.out.println("Estudiante encontrado!: " + encontrado.toString() );
        }catch(Exception e){
            
            System.out.println("Estudiante no encontrado.");
        }
        
        
    }
    
    
    private static void agregarCursoAlCatalogo(){
        System.out.println("\n=== REGISTRO DE NUEVO CURSO ===");
        
        
    
        System.out.print("Clave del curso (Ej. MAT-123): ");
        String clave = scanner.nextLine().trim().toUpperCase();

        
        System.out.print("Nombre del curso: ");
        String nombre = scanner.nextLine().toUpperCase();
        
        System.out.print("Capacidad maxima del curso: ");
        int capacidad = Integer.parseInt(scanner.nextLine());
        
        //validacion para que obligatoriamente el usuario llene tanto la clave como el nombre
        while(clave.isBlank() || nombre.isBlank()){
            System.out.println(" ERROR: Debes llenar todos los campos.");
            
            System.out.print("Clave del curso (Ej. MAT-123): ");
            clave = scanner.nextLine().trim().toUpperCase();


            System.out.print("Nombre del curso: ");
            nombre = scanner.nextLine().toUpperCase();
            
            System.out.print("Capacidad maxima del curso: ");
            capacidad = Integer.parseInt(scanner.nextLine());
        }
        
        Curso curso = new Curso(clave,nombre,capacidad);
        
        try{
            gestionService.agregarCurso(curso);
            System.out.println("Curso registrado con exito!");
            
        }catch(Exception e){
            System.out.println("Error:" + e.getMessage());
            System.out.println("No se pudo completar el registro del curso. Intente de nuevo.");
        }
    }
    
    private static void eliminarCurso(){
        System.out.println("\n=== ELIMINAR CURSO ===");
        
        System.out.print("Clave del curso a eliminar (Ej. MAT-123): ");
        String clave = scanner.nextLine().trim().toUpperCase();
        
        //validacion para que obligatoriamente el usuario llene el campo clave
        while (clave.isBlank()) {
            System.out.println(" ERROR: La clave no puede estar vacia");
            clave = scanner.nextLine().trim().toUpperCase();
        }
        
        try{
            gestionService.eliminarCurso(clave);
            System.out.println("Curso eliminado con exito!");
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            System.out.println("No se pudo completar la eliminacion del curso. Intente de nuevo.");
        }
        
    }
    
    private static void listarCatalogoCursos(){
        gestionService.listarCursos();
    }
    
    private static void inscribirEstudiante(){
        System.out.println("\n=== INSCRIPCION ESTUDIANTE A CURSO ===");
        
        
    
        System.out.print("Matricula del Estudiante(Ej. ABC-123): ");
        String matricula = scanner.nextLine().trim().toUpperCase();
        
        System.out.print("Clave del curso(Ej. MAT-123): ");
        String clave = scanner.nextLine().trim().toUpperCase();
        
        try{
            gestionService.inscribirEstudianteACurso(matricula, clave);
            System.out.println("Estudiante con matricula: " + matricula + " inscrito al curso: " + clave + " con exito!");
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            System.out.println("No se pudo completar la eliminacion del curso. Intente de nuevo.");
        }
    }
    
    private static void mostrarListaCursoInscritos(){
        System.out.println("\n=== MOSTRAR LISTA DE INSCRITOS A CURSO ===");
        
        System.out.print("Clave del curso a listar(Ej. MAT-123): ");
        String clave = scanner.nextLine().trim().toUpperCase();
        
        
        try{
            gestionService.mostrarInscritosDeCurso(clave);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            System.out.println("No se pudo completar la eliminacion del curso. Intente de nuevo.");
        }
        
    }
    
    private static void mostrarListaCursoEnEspera(){
        
        System.out.print("Clave del curso(Ej. MAT-123): ");
        String clave = scanner.nextLine().trim().toUpperCase();
        
        System.out.print("Cuantos de la fila de espera desea mostrar?: ");
        int n = Integer.parseInt(scanner.nextLine());
        
        try{
            gestionService.mostrarFilaEsperaDeCurso(clave,n);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            System.out.println("No se pudo completar la eliminacion del curso. Intente de nuevo.");
        }
    }
    
    private static void  enviarSolicitudCalificacion(){
        System.out.println("\n=== CREAR SOLICITUD DE CALIFICACION ===");
        
        System.out.print("Matricula del Estudiante(Ej. ABC-123): ");
        String matricula = scanner.nextLine().trim().toUpperCase();
        
        System.out.print("Clave del curso(Ej. MAT-123): ");
        String clave = scanner.nextLine().trim().toUpperCase();
        
        System.out.print("Capacidad maxima del curso: ");
        double calif = Double.parseDouble(scanner.nextLine());
        
        SolicitudCalificacion solicitud = new SolicitudCalificacion(matricula, clave, calif);
        
        try{
            gestionService.enviarSolicitud(solicitud);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            System.out.println("No se pudo completar la eliminacion del curso. Intente de nuevo.");
        }
        
    }
    
    private static void procesarSolicitudCalificacion(){

        System.out.println("\n=== PROCESANDO SOLICITUD DE CALIFACION ===");

        
        try{
            String mensajeResultado = gestionService.procesarSiguienteSolicitud();
            
            System.out.println(">> " + mensajeResultado);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            System.out.println("No se pudo completar la eliminacion del curso. Intente de nuevo.");
        }
        

        
        
        
    }
}

