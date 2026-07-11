/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementacion;

import interfaces.IDictionary;

/**
 *
 * @author Cesar Demian Quiroz Montijo 252975
 */
public class Diccionario<K, V> implements IDictionary<K, V> {

    private static class HashNode<K, V> {
        K key;
        V value;
        HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private HashNode<K, V>[] buckets;
    private int capacidad;
    private int tamanio;

    @SuppressWarnings("unchecked")
    public Diccionario(int capacidad) {
        this.capacidad = capacidad;
        this.buckets = new HashNode[capacidad];
        this.tamanio = 0;
    }

    private int obtenerIndiceBucket(K key) {
        return Math.abs(key.hashCode() % capacidad);
    }

    @Override
    public void put(K key, V value) throws Exception {
        int bucketIndex = obtenerIndiceBucket(key);
        HashNode<K, V> head = buckets[bucketIndex];

        HashNode<K, V> temp = head;
        while (temp != null) {
            if (temp.key.equals(key)) {
                throw new Exception("La clave del curso ya existe en el diccionario.");
            }
            temp = temp.next;
        }

        HashNode<K, V> nuevoNodo = new HashNode<>(key, value);
        nuevoNodo.next = head;
        buckets[bucketIndex] = nuevoNodo;
        tamanio++;
    }

    @Override
    public V get(K key) {
        int bucketIndex = obtenerIndiceBucket(key);
        HashNode<K, V> head = buckets[bucketIndex];

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int bucketIndex = obtenerIndiceBucket(key);
        HashNode<K, V> head = buckets[bucketIndex];
        HashNode<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                break;
            }
            prev = head;
            head = head.next;
        }

        if (head == null) return null;

        tamanio--;
        if (prev != null) {
            prev.next = head.next;
        } else {
            buckets[bucketIndex] = head.next;
        }

        return head.value;
    }

    // Metodo para imprimir o listar los cursos sin exponer los nodos al exterior
    public void imprimirContenido() {
        for (int i = 0; i < capacidad; i++) {
            HashNode<K, V> temp = buckets[i];
            while (temp != null) {
                // Aquí temp.value sera el objeto Curso, se imprimira usando su toString()
                System.out.println(temp.value); 
                temp = temp.next;
            }
        }
    }
    
    @Override
    public int size() {
        return tamanio;
    }
}
