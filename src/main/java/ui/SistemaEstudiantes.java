/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ui;

import java.util.Scanner;
import model.Estudiante;
import services.GestionSistemaService;

/**
 *
 * @author demib
 */
public class SistemaEstudiantes {
    private static final Scanner scanner = new Scanner(System.in);
    
    private static  GestionSistemaService gestionService = new GestionSistemaService();

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
            case "2" -> System.out.println("");
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
            case "1" -> System.out.println("");
            case "2" -> System.out.println("");
            case "3" -> System.out.println("");
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
            case "1" -> System.out.println("");
            case "2" -> System.out.println("");
            case "3" -> System.out.println("");
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
            case "1" -> System.out.println("");
            case "2" -> System.out.println("");
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
        String matricula = scanner.nextLine();

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
}
