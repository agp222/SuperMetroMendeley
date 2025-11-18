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
 * La clase {@code Nodo} representa un elemento dentro del Hastable. Cada nodo almacena una clave, un Articulo
 * y una referencia al siguiente nodo en la lista enlazada para manejar colisiones
 * 
 */
public class Nodo {
    
    //Atributos
    private String clave;
    private Articulo valor;
    private Nodo siguiente;

    /**
     * Crea un nuevo nodo con la clave y el valor especificados
     *
     * @param clave la clave única asociada al nodo
     * @param valor el objeto {@link Articulo} que se almacena en el nodo
     */
    Nodo(String clave, Articulo valor) {
        this.clave = clave;
        this.valor = valor;
    }

    
    /**
     * Obtiene la clave del nodo
     * @return la clave como {@code String}
     */
    public String getClave() {
        return clave;
    }

    /**
     * Establece la clave del nodo
     * @param clave nueva clave
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * Obtiene el valor almacenado en el nodo
     * @return el objeto {@link Articulo} asociado
     */
    public Articulo getValor() {
        return valor;
    }

    /**
     * Establece el valor almacenado en el nodo
     * @param valor nuevo objeto {@link Articulo}
     */
    public void setValor(Articulo valor) {
        this.valor = valor;
    }

    /**
     * Obtiene el siguiente nodo en la lista enlazada
     * @return el siguiente nodo o {@code null} si no existe
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    
    /**
     * Establece el siguiente nodo en la lista enlazada
     * @param siguiente referencia al siguiente nodo
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
