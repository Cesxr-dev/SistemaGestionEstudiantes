/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import implementacion.DynamicArray;

/**
 * @author Julian Daniel Ramirez Garcia & Cesar Demian Quiroz Montijo 252975
 */
public class Estudiante implements Comparable<Estudiante> {
    
    private class Calificaciones {
        DynamicArray<String> cursos;
        DynamicArray<Float> notas;
        
        public Calificaciones() {
            cursos = new DynamicArray<>();
            notas = new DynamicArray<>();
        }
        
        public boolean setCalificacion(String claveCurso, Float nota) {
            int i = cursos.indexOf(claveCurso);
            if(i != -1) {
                notas.set(nota, i);
                return true;
            }
            return false;
        }
        
        public boolean addCalificacion(String claveCurso, Float nota) {
            if(cursos.indexOf(claveCurso) != -1) {
                return false;
            }

            cursos.append(claveCurso);
            notas.append(nota);
            return true;
        }
        
        public boolean dropCalificacion(String claveCurso) throws Exception {
            int indice = cursos.indexOf(claveCurso);
            if (indice == -1) {
                return false;
            }

            cursos.remove(claveCurso);
            notas.remove(notas.get(indice));
            return true;
        }
        
        public Float obtenerCalificacion(String curso) {
            int indice = cursos.indexOf(curso);
            if(indice == -1) {
                return null;
            }
            return notas.get(indice);
        }
        
        public float calcularPromedio() {
            if(notas.isEmpty()) {
                return 0;
            }
            return calcularSuma(0) / notas.size();
        }
        
        private float calcularSuma(int indice) {
            if(indice == notas.size()) {
                return 0;
            }
            return notas.get(indice) + calcularSuma(indice + 1);
        }
        
        public int cantidadCursos() {
            return cursos.size();
        }
        
        public void mostrarCalificaciones() {
            for(int i = 0; i < cursos.size(); i++) {
                System.out.println(
                    cursos.get(i) + ": " + notas.get(i)
                );
            }
        }
    }
    
    private String matricula; // EJ: ABCD1234
    private String nombreCompleto;
    private String telefono;
    private String correo;
    private String direccionPostal; // calle,numero,colonia,ciudad
    private Calificaciones calificaciones;

    public Estudiante() {
    }

    public Estudiante(String matricula, String nombreCompleto, String telefono, String correo, String direccionPostal) {
        this.matricula = matricula;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.correo = correo;
        this.direccionPostal = direccionPostal;
        this.calificaciones = new Calificaciones();
    }
    
    public Estudiante(String matricula) {
        this.matricula = matricula;
        this.calificaciones = new Calificaciones();
    }
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccionPostal() {
        return direccionPostal;
    }

    public void setDireccionPostal(String direccionPostal) {
        this.direccionPostal = direccionPostal;
    }
    
    public Calificaciones getCalificaciones() {
        return calificaciones;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "matricula=" + matricula + ", nombreCompleto=" + nombreCompleto + ", telefono=" + telefono + ", correo=" + correo + ", direccionPostal=" + direccionPostal + '}';
    }
    
    @Override
    public int compareTo(Estudiante o) {
        return this.matricula.compareTo(o.getMatricula());
    }
}
