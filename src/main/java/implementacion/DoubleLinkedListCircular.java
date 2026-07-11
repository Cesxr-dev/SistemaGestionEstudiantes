/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementacion;

import interfaces.IList;

/**
 * @author Julian Daniel Ramirez Garcia y Cesar Demian Quiroz Montijo 252975
 * @param <T>
 */
public class DoubleLinkedListCircular<T> implements IList<T> {
    
    private class Nodo<T> {
        public Nodo<T> siguiente;
        public Nodo<T> anterior;
        public T dato;
        
        public Nodo(T dato) {
            this.siguiente = null;
            this.anterior = null;
            this.dato = dato;
        }

        public Nodo<T> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo<T> siguiente) {
            this.siguiente = siguiente;
        }

        public Nodo<T> getAnterior() {
            return anterior;
        }

        public void setAnterior(Nodo<T> anterior) {
            this.anterior = anterior;
        }

        public T getDato() {
            return dato;
        }

        public void setDato(T dato) {
            this.dato = dato;
        }

        
    }

    private Nodo<T> cabeza = null;
    private int tamanio = 0; 

    public int getTamanio() {
        return tamanio;
    }
    
    

    
    // Agregar al final
    @Override
    public void append(T o) {
        Nodo<T> nuevoNodo = new Nodo<>(o);

        if (cabeza == null) {
            cabeza = nuevoNodo;
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
        } else {
            Nodo<T> ultimo = cabeza.getAnterior();
            
            ultimo.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(ultimo);
            nuevoNodo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevoNodo);
        }
        tamanio++;
    }
    
    
    @Override
    public void set(T o, int i) {
        if (cabeza == null || i < 0 || i >= tamanio) return;
        
        Nodo<T> auxiliar = cabeza;
        for (int j = 0; j < i; j++) {
            auxiliar = auxiliar.getSiguiente();
        }
        
        auxiliar.setDato(o);
    }

    @Override
    public boolean remove(T o) throws Exception {
        if (cabeza == null) return false;
        
        Nodo<T> auxiliar = cabeza;
        
        do {
            if (auxiliar.getDato().equals(o)) {
                if (tamanio == 1) {
                    cabeza = null;
                } else {
                    auxiliar.getAnterior().setSiguiente(auxiliar.getSiguiente());
                    auxiliar.getSiguiente().setAnterior(auxiliar.getAnterior());
                    
                    if (auxiliar == cabeza) {
                        cabeza = auxiliar.getSiguiente();
                    }
                }
                tamanio--;
                return true;
            }
            auxiliar = auxiliar.getSiguiente();
        } while (auxiliar != cabeza);
        
        return false;
    }

    @Override
    public int indexOf(T o) {
        if (cabeza == null) return -1;
        
        Nodo<T> auxiliar = cabeza;
        int contador = 0;
        
        
        do {
            if (auxiliar.getDato().equals(o)) {
                return contador;
            }
            contador++;
            auxiliar = auxiliar.getSiguiente();
        } while (auxiliar != cabeza);
        
        return -1;
    }

    public void clear() {
        cabeza = null;
        tamanio = 0;
    }
    
    public T get(int indice) {
        if (cabeza == null || indice < 0 || indice >= tamanio) {
            return null;
        }
        
        Nodo<T> auxiliar = cabeza;
        
        for (int i = 0; i < indice; i++) {
            auxiliar = auxiliar.getSiguiente();
        }
        
        return auxiliar.getDato();
    }
    
    @Override
    public int size() {
        return tamanio;
    }
    
    @Override
    public boolean isEmpty() {
        return tamanio == 0;
    }
}
