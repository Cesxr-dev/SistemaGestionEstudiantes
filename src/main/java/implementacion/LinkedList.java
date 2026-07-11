package implementacion;

import interfaces.IList;

/**
 * @author Julian Daniel Ramirez Garcia y Cesar Demian Quiroz Montijo 252975
 * @param <T>
 */
public class LinkedList<T> implements IList<T> {

    private class Nodo<T> {
        public Nodo<T> siguiente;
        public T dato;

        public Nodo(T dato) {
            this.siguiente = null;
            this.dato = dato;
        }

        public Nodo<T> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo<T> siguiente) {
            this.siguiente = siguiente;
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
        return this.tamanio;
    }

    @Override
    public void append(T o) {
        Nodo<T> nuevoNodo = new Nodo<>(o);
        
        
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> auxiliar = cabeza;
            while (auxiliar.getSiguiente() != null) {
                auxiliar = auxiliar.getSiguiente();
            }
            auxiliar.setSiguiente(nuevoNodo);
        }
        tamanio++;
    }
    
    @Override
    public void set(T o, int i) {
        
        if (i < 0 || i >= tamanio || cabeza == null) {
            return;
        }
        
        Nodo<T> auxiliar = cabeza;
        for (int j = 0; j < i; j++) {
            auxiliar = auxiliar.getSiguiente();
        }
        
        auxiliar.setDato(o);
    }
    
    public void setHead(T o) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.dato.equals(o)) {
                cabeza = actual;
                return;
            }
            actual = actual.getSiguiente();
        }
    }

    @Override
    public boolean remove(T o) throws Exception {
        if (cabeza == null) {
            return false;
        }
        
        if (cabeza.getDato().equals(o)) {
            cabeza = cabeza.getSiguiente();
            tamanio--;
            return true;
        }
        
        Nodo<T> auxiliar = cabeza;
        while (auxiliar.getSiguiente() != null) {
            if (auxiliar.getSiguiente().getDato().equals(o)) {
                auxiliar.setSiguiente(auxiliar.getSiguiente().getSiguiente());
                tamanio--;
                return true;
            }
            auxiliar = auxiliar.getSiguiente();
        }
        return false;
    }

    @Override
    public int indexOf(T o) {
        if (cabeza == null) {
            return -1;
        }
        
        int contador = 0;
        Nodo<T> auxiliar = cabeza;
        
        while (auxiliar != null) {
            if (auxiliar.getDato().equals(o)) {
                return contador;
            }
            contador++;
            auxiliar = auxiliar.getSiguiente();
        }
        return -1;
    }

    public void clear() {
        cabeza = null;
        tamanio = 0;   
    }
    
    public T get(int indice) {
        
        if (cabeza == null || indice < 0 || indice >= tamanio) {
            return null; // O IndexOutOfBoundsException
        }
        
        Nodo<T> auxiliar = cabeza;
        
        // Recorremos la lista
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