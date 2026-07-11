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

public class AVLTree<T extends Comparable<T>>{
    
    private class Nodo<T> {
        T dato;
        Nodo<T> hijoIzq;
        Nodo<T> hijoDer;
        int altura;

        public Nodo(T dato) {
            this.dato = dato;
            this.hijoIzq = null;
            this.hijoDer = null;
            this.altura = 1; // Todo nodo nuevo inicia con altura 1
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

        public int getAltura() {
            return altura;
        }

        public void setAltura(int altura) {
            this.altura = altura;
        }
    }
    
    private Nodo<T> raiz;
    
    private int obtenerAltura(Nodo<T> nodo) {
        if(nodo == null){
            return 0;
        }else{
            return nodo.getAltura();
        }

    }

    private int obtenerFactorBalance(Nodo<T> nodo) {
        if(nodo == null){
            return 0;
        }else{
            return obtenerAltura(nodo.getHijoIzq()) - obtenerAltura(nodo.getHijoDer());
        }
        
    }
    
    // Rotacion simple a la derecha
    private Nodo<T> rotarDerecha(Nodo<T> y) {
        Nodo<T> x = y.getHijoIzq();
        Nodo<T> T2 = x.getHijoDer();

        // Hacer la rotacion
        x.setHijoDer(y);
        y.setHijoIzq(T2);

        // Actualizar alturas
        y.setAltura(Math.max(obtenerAltura(y.getHijoIzq()), obtenerAltura(y.getHijoDer())) + 1);
        x.setAltura(Math.max(obtenerAltura(x.getHijoIzq()), obtenerAltura(x.getHijoDer())) + 1);

        return x; // Nueva raiz del subarbol
    }

    // Rotacion simple a la izquierda
    private Nodo<T> rotarIzquierda(Nodo<T> x) {
        Nodo<T> y = x.getHijoDer();
        Nodo<T> T2 = y.getHijoIzq();

        // Hacer la rotacion
        y.setHijoIzq(x);
        x.setHijoDer(T2);

        // Actualizar alturas
        x.setAltura(Math.max(obtenerAltura(x.getHijoIzq()), obtenerAltura(x.getHijoDer())) + 1);
        y.setAltura(Math.max(obtenerAltura(y.getHijoIzq()), obtenerAltura(y.getHijoDer())) + 1);

        return y; // Nueva raiz del subarbol
    }
    
    public void insertar(T dato) {
        raiz = insertar(raiz, dato);
    }
    
    private Nodo<T> insertar(Nodo<T> nodo, T dato) {
        if (nodo == null) {
            return new Nodo<>(dato);
        }

        int comparacion = dato.compareTo(nodo.getDato());

        if (comparacion < 0) {
            nodo.setHijoIzq(insertar(nodo.getHijoIzq(), dato));
        } else if (comparacion > 0) {
            nodo.setHijoDer(insertar(nodo.getHijoDer(), dato));
        } else {
            return nodo; // Evita duplicados
        }

        //Actualizar la altura de este nodo ancestro
        nodo.setAltura(Math.max(obtenerAltura(nodo.getHijoIzq()), obtenerAltura(nodo.getHijoDer())) + 1);

        //Obtener el factor de balance para revisar si se desbalanceo
        int balance = obtenerFactorBalance(nodo);

        //Si se desbalanceo, aplicar uno de los 4 casos posibles:

        // Caso Izquierda - Izquierda (Rotacion Derecha)
        if (balance > 1 && dato.compareTo(nodo.getHijoIzq().getDato()) < 0) {
            return rotarDerecha(nodo);
        }

        // Caso Derecha - Derecha (Rotacion Izquierda)
        if (balance < -1 && dato.compareTo(nodo.getHijoDer().getDato()) > 0) {
            return rotarIzquierda(nodo);
        }

        // Caso Izquierda - Derecha (Rotacion Izquierda-Derecha)
        if (balance > 1 && dato.compareTo(nodo.getHijoIzq().getDato()) > 0) {
            nodo.setHijoIzq(rotarIzquierda(nodo.getHijoIzq()));
            return rotarDerecha(nodo);
        }

        // Caso Derecha - Izquierda (Rotacion Derecha-Izquierda)
        if (balance < -1 && dato.compareTo(nodo.getHijoDer().getDato()) < 0) {
            nodo.setHijoDer(rotarDerecha(nodo.getHijoDer()));
            return rotarIzquierda(nodo);
        }

        return nodo; // Retorna el nodo sin cambios si sigue balanceado
    }
    
    public T buscar(T dato){
        return buscar(raiz, dato);
    }
    
    private T buscar(Nodo<T> nodo, T dato){
        if (nodo == null) {
            return null;
        }
        
        int comparacion = dato.compareTo(nodo.getDato());
        
        if (comparacion == 0){
            return nodo.getDato();
        } else if (comparacion < 0) {
            return buscar(nodo.getHijoIzq(), dato);
        } else {
            return buscar(nodo.getHijoDer(), dato);
        }
    }

    public void preOrder(){
        preOrder(raiz); 
    }
    
    private void preOrder(Nodo<T> nodo){
        
        if (nodo != null){
            
            System.out.print(nodo.getDato() + " ");
            preOrder(nodo.getHijoIzq());
            preOrder(nodo.getHijoDer());
        }
    }

    public void inOrder(){
        inOrder(raiz); 
    }
    
    private void inOrder(Nodo<T> nodo){
        if (nodo != null){
            
            inOrder(nodo.getHijoIzq());
            System.out.print(nodo.getDato() + " ");
            inOrder(nodo.getHijoDer());
        }
    }

    public void postOrder(){ 
        postOrder(raiz); 
    }
    
    private void postOrder(Nodo<T> nodo){
        if (nodo != null){
            
            postOrder(nodo.getHijoIzq());
            postOrder(nodo.getHijoDer());
            System.out.print(nodo.getDato() + " ");
        }
    }
    
    
}
