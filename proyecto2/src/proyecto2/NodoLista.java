/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author Antonio Guzzo
 */
/**
 * Representa un nodo en una lista simple.
 * Cada nodo contiene un valor y una referencia al siguiente nodo en la lista.
 */
public class NodoLista<T> {
    // Atributos
    private T value;  
    private NodoLista<T> pNext;

    /**
     * Constructor que crea un nodo con el valor dado.
     * Inicializa el nodo con el valor y establece la referencia al siguiente nodo como null.
     *
     * @param value El valor que se almacena en el nodo
     */
    public NodoLista(T value) {
        this.value = value;
        this.pNext = null;
    }

    /**
     * @return El valor del nodo
     */
    public T getValue() {
        return value;
    }
    /**
     * @param value El valor que se desea establecer en el nodo
     */
    public void setValue(T value) {
        this.value = value;
    }
    /**
     * @return El siguiente nodo
     */
    public NodoLista getpNext() {
        return pNext;
    }
    /**
     * @param pNext El nodo que debe ser el siguiente en la lista
     */
    public void setpNext(NodoLista pNext) {
        this.pNext = pNext;
    }  
}
