/*
 * 
 */
package implementacion;

import interfaces.IList;

//** @author Julian Daniel Ramirez Garcia

public class DynamicArray<T> implements IList<T> {

    private T[] datos;
    private int elementos;
    private int capacidad;
    
    @SuppressWarnings("unchecked")
    public DynamicArray(int capacidadInicial){
        datos = (T[]) new Object[capacidadInicial];
        capacidad = capacidadInicial;
        elementos = 0;
    }
    
    @Override
    public void append(T o) {
        if(elementos == capacidad){
            resize();
        }
        datos[elementos] = o;
        elementos++;
    }

    @Override
    public T get(int i) {
        if(i < 0 || i >= elementos){
            throw new IndexOutOfBoundsException();
        }
        return datos[i];
    }

    @Override
    public void set(T o, int i) {
        if (i < 0 || i >= elementos) {
            throw new IndexOutOfBoundsException();
        }
        datos[i] = o;
    }

    @Override
    public boolean remove(T o) throws Exception {
        int posicion = indexOf(o);
        if (posicion == -1) {
            return false;
        }
        
        for (int i = posicion; i < elementos - 1; i++) {
            datos[i] = datos[i + 1];
        }

        datos[elementos - 1] = null;
        elementos--;
        return true;
    }

    @Override
    public int indexOf(T o) {
        for(int i = 0; i < elementos; i++) {
            if(datos[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return elementos;
    }

    @Override
    public boolean isEmpty() {
        return elementos == 0;
    }
    
    //** metodo para redimencionar el arreglo (solo puede creecer)
    private void resize(){
        capacidad *= 2;
        T[] nuevo = (T[]) new Object[capacidad];
        for(int i = 0; i < elementos; i++){
            nuevo[i] = datos[i];
        }
        datos = nuevo;
    }
}
