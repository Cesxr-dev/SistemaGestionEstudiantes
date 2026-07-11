/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementacion;

import interfaces.ITree;
import java.util.Iterator;

/**
 *
 * @author Cesar Demian Quiroz Montijo 252975
 * @param <T>
 */

public class BinarySearchTree<T extends Comparable<T>> implements ITree<T>, Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return new IteradorBST();
    }
    
    private class IteradorBST implements Iterator<T> {
        private LinkedListStack<Nodo> pila;

        public IteradorBST() {
            pila = new LinkedListStack<>();
            agregarIzquierdos(raiz);
        }

        /**
         * Agrega todos los nodos izquierdos desde un nodo dado
         */
        private void agregarIzquierdos(Nodo nodo) {
            while (nodo != null) {
                pila.push(nodo);
                nodo = nodo.hijoIzq;
            }
        }


        @Override
        public boolean hasNext() {
            return !pila.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            Nodo<T> actual = pila.pop();

            // Después de visitar un nodo,
            // revisamos su rama derecha
            agregarIzquierdos(actual.hijoDer);

            return actual.dato;
        }

    }
    
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
    
    @Override
    public boolean insert(T dato) {
        if (find(dato) != null) {
            return false;
        }
        raiz = insert(raiz, dato);
        return true;
    }
    
    
    private Nodo<T> insert(Nodo<T> nodo, T dato) {
        
        if (nodo == null) {
            // encuentra un nodo vacio, se inserta el nuevo
            return new Nodo<>(dato);
        }

        // compara el dato nuevo con el del nodo actual
        int comparacion = dato.compareTo(nodo.getDato());

        if (comparacion < 0) {

            nodo.setHijoIzq(insert(nodo.getHijoIzq(), dato));
        } else if (comparacion > 0) {

            nodo.setHijoDer(insert(nodo.getHijoDer(), dato));
        }
        // comparacion == 0 es porque el dato existe asi que no se hace nada para evitar duplicacion

        return nodo;
    }
    
    @Override
    public boolean remove(T dato) {
        if (find(dato) == null) {
            return false;
        }
        raiz = remove(raiz, dato);
        return true;
    }
    
    private Nodo<T> remove(Nodo<T> nodo, T dato) {
        if (nodo == null) return null;

        int comparacion = dato.compareTo(nodo.getDato());
        if (comparacion < 0) {
            nodo.hijoIzq = remove(nodo.hijoIzq, dato);
        } else if (comparacion > 0) {
            nodo.hijoDer = remove(nodo.hijoDer, dato);
        } else {
            // Caso 1: hoja
            if (nodo.hijoIzq == null && nodo.hijoDer == null) {
                return null;
            }
            // Caso 2: un solo hijo derecho
            if (nodo.hijoIzq == null) {
                return nodo.hijoDer;
            }
            // Caso 3: un solo hijo izquierdo
            if (nodo.hijoDer == null) {
                return nodo.hijoIzq;
            }
            // Caso 4: dos hijos
            Nodo<T> sucesor = findSmallest(nodo.hijoDer);

            nodo.setDato(sucesor.getDato());

            nodo.hijoDer = remove(nodo.hijoDer, sucesor.getDato());
        }
        return nodo;
    }
    
    
    @Override
    public T find(T dato) {
        return find(raiz, dato);
    }
    
    private T find(Nodo<T> nodo, T dato) {
        
        if (nodo == null) {
            return null; // no encontrado
        }
        
        int comparacion = dato.compareTo(nodo.getDato());
        
        if (comparacion == 0) {
            return nodo.getDato();
        } else if (comparacion < 0) {
            return find(nodo.getHijoIzq(), dato);
        } else {
            return find(nodo.getHijoDer(), dato);
        }
    }
    
    private Nodo<T> findSmallest(Nodo<T> nodo) {
        while (nodo.hijoIzq != null) {
            nodo = nodo.hijoIzq;
        }
        return nodo;
    }
    
    @Override
    public boolean isEmpty() {
        return raiz == null;
    }
    
    
}
