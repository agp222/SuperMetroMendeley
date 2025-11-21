/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author Antonio Guzzo
 */
public class ArbolAVL {
    private NodoAVL root;

    public ArbolAVL() {
        root = null;
    }

    public NodoAVL getRoot() {
        return root;
    }
    
    public NodoAVL getRaiz() {
        return root;
    }

    private int obtenerAltura(NodoAVL nodo) {
        if (nodo == null){
            return 0;
        }
        return nodo.getAltura();
    }

    private int obtenerBalance(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        }
        
        int altura = obtenerAltura(nodo.getIzquierdo()) - obtenerAltura(nodo.getDerecho());
        return altura;
    }
}
