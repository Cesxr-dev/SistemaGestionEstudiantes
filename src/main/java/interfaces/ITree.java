/*
 * 
 */
package interfaces;

//** @author Julian Daniel Ramirez Garcia

public interface ITree<T> {
    
    /**
     * agrega el elemento en el arbol
     * @param o elemento a agregar
     * @return verdadero si se agrego correctamente
     */
    boolean insert(T o);
    
    /**
     * remueve un elemento del arbol
     * @param o elemento a remover
     * @return verdadero si se removio correctamente
     */
    boolean remove(T o);
    
    /**
     * encuentra un objeto dentro del arbol
     * @param o objeto a buscar
     * @return el objeto del arbol que encontro
     */
    T find(T o);
    
    /**
     * devuelve verdadero si el arbol esta vacia, falso si no lo esta
     * @return verdadero o falso
     */
    boolean isEmpty();
}
