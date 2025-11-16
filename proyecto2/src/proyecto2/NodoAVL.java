/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author adcd_
 */
public class NodoAVL {
    
    // Atributos
    int valor;
    int altura;
    NodoAVL hijoIzquierdo;
    NodoAVL hijoDerecho;
    

    /**
     * Constructor que crea un nodo con el valor dado.
     * Inicializa el nodo con el valor.
     *
     * @param value El valor que se almacena en el nodo
     */
    public NodoAVL(int valor) {
        this.valor = valor;
        this.altura = 1;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }
}
