/*
 * 
 */
package interfaces;

//** @author Julian Daniel Ramirez Garcia

public interface IStack<T> {
    
    /**
     * agregar un elemento al tope de la pila
     * @param o elemento a agregar al tope de la pila
     */
    void push(T o);
    
    /**
     * remueve el elemento del tope de la pila y lo regresa
     * @return elemento en el tope de la pila
     */
    T pop();
    
    /**
     * devuelve el elemento del tope de la pila
     * @return elemento del tope de la pila
     */
    T peek();
    
    /**
     * devuelve verdadero si la pila esta vacia
     * @return verdadero o falso
     */
    boolean isEmpty();
    
    /**
     * devuelve el tamaño actual de la pila
     * @return tamaño de la pila
     */
    int size();
    
    /**
     * elimina todos los elementos de la pila, es decir la vacia
     */
    void clear();
}
