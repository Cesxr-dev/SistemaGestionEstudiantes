/*
 * 
 */
package interfaces;

//** @author Julian Daniel Ramirez Garcia

public interface IAccion {
    
    /**
     * hacer una accion del menu que proboque cambios permanentes al sistema
     */
    void hacer();
    
    /**
     * deshacer una accion de la pila que haya modificado el sistema
     */
    void deshacer();
}
