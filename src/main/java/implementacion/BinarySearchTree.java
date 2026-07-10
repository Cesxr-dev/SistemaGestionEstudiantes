/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementacion;

/**
 *
 * @author Cesar Demian Quiroz Montijo 252975
 * @param <T>
 */

public class BinarySearchTree<T extends Comparable<T>>{
    
    private class Nodo<T>{
        T dato;
        Nodo<T> hijoIzq;
        Nodo<T> hijoDer;

        public Nodo(T dato) {
            this.dato = dato;
            this.hijoIzq = null;
            this.hijoDer = null;
        }

        public T getDato() {
            return dato;
        }

        public void setDato(T dato) {
            this.dato = dato;
        }

        public Nodo<T> getHijoIzq() {
            return hijoIzq;
        }

        public void setHijoIzq(Nodo<T> hijoIzq) {
            this.hijoIzq = hijoIzq;
        }

        public Nodo<T> getHijoDer() {
            return hijoDer;
        }

        public void setHijoDer(Nodo<T> hijoDer) {
            this.hijoDer = hijoDer;
        }
    }
    
    private Nodo<T> raiz;
    
    //PRE ORDER
    public void preOrder() {
        preOrder(raiz);
    }

    private void preOrder(Nodo<T> nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + " ");
            preOrder(nodo.getHijoIzq());
            preOrder(nodo.getHijoDer());
        }
    }

    
    //IN ORDER
    public void inOrder() {
        inOrder(raiz);
    }

    private void inOrder(Nodo<T> nodo) {
        if (nodo != null) {
            inOrder(nodo.getHijoIzq());
            System.out.print(nodo.getDato() + " ");
            inOrder(nodo.getHijoDer());
        }
    }

    
    //POST ORDER
    
    public void postOrder() {
        postOrder(raiz);
    }

    private void postOrder(Nodo<T> nodo) {
        if (nodo != null) {
            postOrder(nodo.getHijoIzq());
            postOrder(nodo.getHijoDer());
            System.out.print(nodo.getDato() + " ");
        }
    }
    
    public void insertar(T dato) {
        raiz = insertar(raiz, dato);
    }
    
    
    private Nodo<T> insertar(Nodo<T> nodo, T dato) {
        
        if (nodo == null) {
            // encuentra un nodo vacio, se inserta el nuevo
            return new Nodo<>(dato);
        }

        // compara el dato nuevo con el del nodo actual
        int comparacion = dato.compareTo(nodo.getDato());

        if (comparacion < 0) {

            nodo.setHijoIzq(insertar(nodo.getHijoIzq(), dato));
        } else if (comparacion > 0) {

            nodo.setHijoDer(insertar(nodo.getHijoDer(), dato));
        }
        // comparacion == 0 es porque el dato existe asi que no se hace nada para evitar duplicacion

        return nodo;
    }
    
    
    public T buscar(T dato) {
        return buscar(raiz, dato);
    }
    
    private T buscar(Nodo<T> nodo, T dato) {
        
        if (nodo == null) {
            return null; // no encontrado
        }
        
        int comparacion = dato.compareTo(nodo.getDato());
        
        if (comparacion == 0) {
            return nodo.getDato();
        } else if (comparacion < 0) {
            return buscar(nodo.getHijoIzq(), dato);
        } else {
            return buscar(nodo.getHijoDer(), dato);
        }
    }
}
