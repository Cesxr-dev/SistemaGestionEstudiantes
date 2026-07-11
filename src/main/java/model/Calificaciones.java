/*
 * 
 */
package model;

import implementacion.DynamicArray;

//** @author Julian Daniel Ramirez Garcia

public class Calificaciones {
        DynamicArray<String> cursos;
        DynamicArray<Double> notas;
        
        public Calificaciones() {
            cursos = new DynamicArray<>();
            notas = new DynamicArray<>();
        }
        
        public boolean setCalificacion(String claveCurso, Double nota) {
            int i = cursos.indexOf(claveCurso);
            if(i != -1) {
                notas.set(nota, i);
                return true;
            }
            return false;
        }
        
        public boolean addCalificacion(String claveCurso, Double nota) {
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
        
        public Double obtenerCalificacion(String curso) {
            int indice = cursos.indexOf(curso);
            if(indice == -1) {
                return null;
            }
            return notas.get(indice);
        }
        
        public Double calcularPromedio() {
            if(notas.isEmpty()) {
                return 0.0;
            }
            return calcularSuma(0) / notas.size();
        }
        
        private Double calcularSuma(int indice) {
            if(indice == notas.size()) {
                return 0.0;
            }
            return notas.get(indice) + calcularSuma(indice + 1);
        }
        
        public int cantidadCursos() {
            return cursos.size();
        }
        
        public void mostrarCalificaciones() {
            for(int i = 0; i < cursos.size(); i++) {
                System.out.println(cursos.get(i) + ": " + notas.get(i));
            }
        }
        
        @Override
        public String toString() {
            if (cursos.isEmpty()) {
                return "Sin cursos inscritos";
            }
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < cursos.size(); i++) {
                sb.append(cursos.get(i)).append(": ").append(notas.get(i));
                if (i < cursos.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("] (Promedio: ").append(calcularPromedio()).append(")");
            return sb.toString();
        }
    }
