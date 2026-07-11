package model;

/**
 * @author Julian Daniel Ramirez Garcia & Cesar Demian Quiroz Montijo
 */

import implementacion.DoubleLinkedListCircular;
import implementacion.LinkedList;


public class Curso implements Comparable<Curso> {
    private String clave, nombre;
    private int capacidad; // Capacidad maxima del curso
    
    private LinkedList<Estudiante> inscritos; // Estudiantes inscritos
    private DoubleLinkedListCircular<Estudiante> enEspera; // Estudiantes en espera
    
    /**
     * 
     * @param clave clave curso
     * @param nombre nombre curso
     * @param capacidad capacidad maxima del curso
     */
    public Curso(String clave, String nombre, int capacidad) {
        if (clave == null || clave.isBlank()) throw new IllegalArgumentException("La clave del curso no puede ser vacia");
        this.clave = clave;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.inscritos = new LinkedList<>();
        this.enEspera = new DoubleLinkedListCircular<>();
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Curso: " + "clave: " + clave + ", Nombre: " + nombre + ", Capacidad: " + capacidad + '}';
    }
    
    
    @Override
    public int compareTo(Curso o) {
        return this.clave.compareTo(o.clave);
    }
    
    /**
     * Si el tamano del curso es mayor que la cant de estudiantes inscritos, se inscribe al estudiante, en caso contrario se agrega a la lista de espera
     * @param estudiante 
     */
    public void inscribirEstudiante(Estudiante estudiante) throws Exception {
        
        if (estaInscrito(estudiante.getMatricula()) || estaEnEspera(estudiante.getMatricula())) {
            throw new Exception("El estudiante con matricula " + estudiante.getMatricula() 
                                + " ya esta registrado en el curso " + this.nombre + ".");
        }
        
        if (inscritos.getTamanio() < this.capacidad) { 
            inscritos.agregarNodoFinal(estudiante); // Inscrito
        } else {
            enEspera.agregarNodoFinal(estudiante); // Se va a lista de espera
        }
    }
    
    /**
     * Muestra la lista completa de todos los estudiantes inscritos
     */
    public void mostrarTodosLosInscritos() {
        int totalInscritos = inscritos.getTamanio();
        
        if (totalInscritos == 0) {
            System.out.println("No hay ningún estudiante inscrito actualmente.");
            return;
        }
        
        System.out.println("\n--- LISTA COMPLETA DE ESTUDIANTES INSCRITOS (" + totalInscritos + ") ---");
        
        for (int i = 0; i < totalInscritos; i++) {
            Estudiante est = inscritos.get(i);
            System.out.println((i + 1) + ". [" + est.getMatricula() + "] - " + est.getNombreCompleto());
        }
    }
    
    
    /**
     * Muestra los primeros 5 de la lista de espera
     */
    public void mostrarPrimerosEnEspera(int n) {
        int totalEspera = enEspera.getTamanio();
        
        if (totalEspera == 0) {
            System.out.println("La lista de espera esta vacia.");
            return;
        }
        
        // Si hay menos alumnos en la lista que los solicitados, nos detenemos en el total real
        int limite = Math.min(n, totalEspera);
        
        System.out.println("\n--- PRIMEROS " + limite + " EN LISTA DE ESPERA ---");
        
        for (int i = 0; i < limite; i++) {
            Estudiante est = enEspera.get(i);
            System.out.println((i + 1) + ". [" + est.getMatricula() + "] - " + est.getNombreCompleto());
        }
    }
    
    /**
     * Muestra todos los de la lista de espera
     */
    public void mostrarTodaLaListaEspera() {
        int totalEspera = enEspera.getTamanio();
        
        if (totalEspera == 0) {
            System.out.println("La lista de espera esta vacia.");
            return;
        }
        
        System.out.println("\n--- LISTA DE ESPERA COMPLETA (" + totalEspera + " alumnos) ---");
        
        
        for (int i = 0; i < totalEspera; i++) {
            Estudiante est = enEspera.get(i);
            System.out.println((i + 1) + ". [" + est.getMatricula() + "] - " + est.getNombreCompleto());
        }
        
    }
    
    /**
     * Verifica si el estudiante con x matricula ya se encuentra inscrito al curso
     * @param matricula
     * @return 
     */
    private boolean estaInscrito(String matricula) {
        int total = inscritos.getTamanio();
        for (int i = 0; i < total; i++) {
            Estudiante est = inscritos.get(i);
            if (est != null && est.getMatricula().equalsIgnoreCase(matricula)) {
                return true; // esta inscrito
            }
        }
        return false;
    }

    /**
     * Verifica si el estudiante con x matricula ya se encuentra en fila de espera del curso
     * @param matricula
     * @return true si
     */
    private boolean estaEnEspera(String matricula) {
        int total = enEspera.getTamanio();
        for (int i = 0; i < total; i++) {
            Estudiante est = enEspera.get(i);
            if (est != null && est.getMatricula().equalsIgnoreCase(matricula)) {
                return true; // esta en espera
            }
        }
        return false;
    }
    
    
}
