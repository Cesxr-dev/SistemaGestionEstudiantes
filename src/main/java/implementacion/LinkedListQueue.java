package implementacion;

import interfaces.IQueue;

/**
 *
 * @author Cesar Demian Quiroz Montijo 252975
 */
public class LinkedListQueue<T> implements IQueue<T>{
    
    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
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
    
    private Nodo<T> cabeza;      
    private Nodo<T> fin;         
    private int nElementos;   
    
    public LinkedListQueue() {
        this.cabeza = null;
        this.fin = null;
        this.nElementos = 0;
    }
    
    @Override
    public void enqueue(T dato){
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        
        if (isEempty()) {
            cabeza = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
        }
        
        fin = nuevoNodo;
        nElementos++;
    }

    @Override
    public T dequeue(){
        if (isEempty()) {
            throw new IllegalStateException("La cola esta vacia");
        }
        
        T dato = cabeza.getDato();
        cabeza = cabeza.getSiguiente();
        
        if (cabeza == null) {
            fin = null;
        }
        
        nElementos--;
        return dato;
    }
    
    @Override
    public T peek(){
        if (isEempty()) {
            throw new IllegalStateException("La cola esta vacia");
        }
        return cabeza.getDato();
    }
    
    public boolean isEempty(){

        return cabeza == null;
        
    }
    
    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}