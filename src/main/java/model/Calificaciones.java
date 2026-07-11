/*
 * 
 */
package model;

import implementacion.DynamicArray;

//** @author Julian Daniel Ramirez Garcia

public class Calificaciones {
    private DynamicArray<String> cursos;
    private DynamicArray<Float> notas;

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
