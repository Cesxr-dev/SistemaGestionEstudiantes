/* 
 * 
 */
package interfaces;

//** @author Julian Daniel Ramirez Garcia

public interface IQueue<T> {
    
    /**
     * agrega un elemento al final de la cola
     * @param o elemento a agregar al final de la cola
     */
    void enqueue(T o);
    
    /**
     * remueve el elemento del inicio de la cola y lo regresa
     * @return elemento en el inicio de la cola
     */
    T dequeue();
    
    /**
     * devuelve el elemento del inicio de la cola
     * @return elemento al inicio de la cola
     */
    T peek();
    
    /**
     * devuelve verdadero si la cola esta vacia
     * @return verdadero o falso
     */
    boolean isEmpty();
    
    /**
     * devuelve el tamaño actual de la cola
     * @return tamaño de la cola
     */
    int size();
}
