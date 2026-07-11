/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

/**
 *
 * @author Cesar Demian Quiroz Montijo 252975 
 */
public interface IList<T> {
    /**
     * reemplaza el elemento que se encuentra en la
        posición i de la lista por el objeto del parámetro. 
     * 
     * @param o
     * @param i 
     */
    void set(T o, int i);
    
    
    /**
     * elimina la primera ocurrencia del elemento del
        parámetro si existe. El método regresa true si el elemento existe en la lista, false
        en caso contrario. El método lanza una excepción del tipo Exception Si la lista
        esta vacía.
     * 
     * @param o
     * @return 
     */
    boolean remove(T o) throws Exception;
    
    /**
     * regresa el índice de la primera ocurrencia del elemento del
        parámetro en la lista, o -1 si el elemento no existe.
     * @param o
     * @return 
     */
    int indexOf(T o);
    
    /**
     * elimina todos los elementos de la lista.
     */
    void clear();
}
