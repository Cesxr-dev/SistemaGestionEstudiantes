/* 
 * 
 */
package interfaces;

//** @author Julian Daniel Ramirez Garcia

public interface IDictionary<K, V> {
    
    /**
     * pone en la clave del paramentro el valor del parametro
     * @param clave clave a la que se modificara su valor
     * @param valor nuevo valor al que apuntara la clave
     */
    void put(K clave, V valor);
    
    /**
     * obtiene el valor guardado en la clave
     * @param clave donde buscar su valor
     * @return valor encontrado en la clave
     */
    V get(K clave);
    
    /**
     * remueve la clave junto con su valor del diccionario
     * @param clave clave a remover
     * @return valor que guardaba la clave
     */
    V remove(K clave);
    
    /**
     * verdadero si el diccionario contiene una clave
     * @param clave clave a buscar en el diccionario
     * @return verdadero o falso
     */
    boolean containsKey(K clave);
    
    /**
     * tamaño actual del diccionario
     * @return tamaño del diccionario
     */
    int size();
    
    /**
     * elimina todas las claves y valores del diccionario, es decir lo vacia
     */
    void clear();
}
