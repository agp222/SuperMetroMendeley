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
    private int valor;
    private int altura;
    private NodoAVL hijoIzquierdo;
    private NodoAVL hijoDerecho;
    

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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public NodoAVL getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoAVL hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoAVL getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoAVL hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }
    
    
}
