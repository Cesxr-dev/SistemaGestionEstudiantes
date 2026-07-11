/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementacion;

import interfaces.IStack;

/**
 *
 * @author julia
 */
public class LinkedListStack<T> implements IStack<T> {
    
    private class Nodo<T>{
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
    
    private Nodo<T> tope;  // la cima de la pila
    private int nElementos;   

    
    public LinkedListStack() {
        this.tope = null;     
        this.nElementos = 0;
    }
    
    
    @Override
    public void push(T o) {
        Nodo nuevoNodo = new Nodo(o);
        
        // El nuevo nodo se coloca arriba, apuntando al antiguo tope
        nuevoNodo.setSiguiente(tope);
        
        
        tope = nuevoNodo;
        nElementos++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila esta vacia");
        }
        
        
        T dato = tope.getDato();
        
        // Bajamos el tope al siguiente nodo en la pila
        tope = tope.getSiguiente();
        nElementos--;
        
        return dato;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila esta vacía");
        }
        
        return tope.getDato();
    }

    @Override
    public boolean isEmpty() {
        return tope == null;
    }
    
    @Override
    public int size() {
        return nElementos;
    }
}