/*
 * 
 */
package interfaces;

//** @author Julian Daniel Ramirez Garcia

public interface IAccion {
    
    /**
     * hacer una accion del menu que proboque cambios permanentes al sistema
     * @throws java.lang.Exception se cede la exception
     */
    void hacer() throws Exception;
    
    /**
     * deshacer una accion de la pila que haya modificado el sistema
     * @throws java.lang.Exception se cede la exception
     */
    void deshacer() throws Exception;
}
