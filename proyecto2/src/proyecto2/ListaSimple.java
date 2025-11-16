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
 * Clase de una lista enlazada simple.
 * Cada elemento de la lista es un nodo (Nodo) que contiene un valor y una referencia al siguiente nodo.
 */
public class ListaSimple {
    private NodoLista pFirst;  
    private NodoLista pLast;
    private int size;
    
    /**
     * Constructor por defecto. Inicializa una lista vacía.
     */
    public ListaSimple() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    /** @return el primer nodo de la lista */
    public NodoLista getpFirst() {
        return pFirst;
    }

    /** @param pFirst nodo a establecer como primer nodo de la lista */
    public void setpFirst(NodoLista pFirst) {
        this.pFirst = pFirst;
    }

    /** @return el último nodo de la lista */
    public NodoLista getpLast() {
        return pLast;
    }

    /** @param pLast nodo a establecer como último nodo de la lista */
    public void setpLast(NodoLista pLast) {
        this.pLast = pLast;
    }

    /** @return el tamaño de la lista */
    public int getSize() {
        return size;
    }

    /** @param size tamaño a establecer para la lista */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Verifica si la lista está vacía.
     * @return true si la lista está vacía, false en caso contrario
     */
    public boolean isEmpty() {
        return pFirst == null;
    }
}
