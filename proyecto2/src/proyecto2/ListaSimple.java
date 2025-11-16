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
    
    
    /**
     * Agrega un nuevo nodo con el valor especificado al final de la lista.
     * @param value el valor a almacenar en el nuevo nodo
     */
    public void AgregarNodo(String value) {
        NodoLista NuevoNodo = new NodoLista(value);

        if (this.isEmpty()) {
            this.pFirst = NuevoNodo;
            this.pLast = NuevoNodo;
        } else {
            this.pLast.setpNext(NuevoNodo);
            this.pLast = NuevoNodo;
        }

        this.size += 1;
    }
    
    /**
     * Elimina el primer nodo que contiene el valor especificado.
     * @param value el valor del nodo a eliminar
     */
    public void EliminarPorValor(String value) {
        if (this.isEmpty()) {
            System.out.println("Esta lista no se puede recorrer porque esta vacia");
        } else {
            NodoLista aux = pFirst;
            NodoLista anterior = null;

            while (aux != null) {
                if (aux.getValue().equals(value)) {
                    if (anterior == null) {
                        pFirst = aux.getpNext();
                    } else {
                        anterior.setpNext(aux.getpNext());
                    }

                    if (aux == pLast) {
                        pLast = anterior;
                    }

                    aux.setpNext(null);
                    this.size--;
                    break;
                }

                anterior = aux;
                aux = aux.getpNext();
            }
        }
    }
    
    /**
    * Verifica si un valor existe en la lista.
    * @param value el valor a buscar
    * @return true si el valor existe, false en caso contrario
    */
    public boolean contains(String value) {
       NodoLista aux = pFirst;
       while (aux != null) {
           if (aux.getValue().equals(value)) {
               return true;
           }
           aux = aux.getpNext();
       }
       return false;
   }
}
