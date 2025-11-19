/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author Antonio Guzzo
 */
public class NodoAVL {
    
    // Atributos
    private String key;
    private int altura;
    private NodoAVL izquierdo;
    private NodoAVL derecho;
    private ListaSimple titulos;

    

    /**
     * Constructor que crea un nodo con el valor dado.
     * Inicializa el nodo con el valor.
     *
     * @param value El valor que se almacena en el nodo
     */
    
    public NodoAVL(String key) {
        this.key = key;
        this.altura = 1;
        this.izquierdo = null;
        this.derecho = null;
        this.titulos = new ListaSimple();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public NodoAVL getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoAVL izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoAVL getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoAVL derecho) {
        this.derecho = derecho;
    }

    public ListaSimple getTitulos() {
        return titulos;
    }

    public void setTitulos(ListaSimple titulos) {
        this.titulos = titulos;
    }
    
    
    
    
    
    
}
