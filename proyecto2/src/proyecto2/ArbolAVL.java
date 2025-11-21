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
    
    private NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.getIzquierdo();
        NodoAVL T2 = x.getDerecho();

        // Rotación
        x.setDerecho(y);
        y.setIzquierdo(T2);

        // Actualizar alturas
        y.setAltura(1 + Math.max(obtenerAltura(y.getIzquierdo()), obtenerAltura(y.getDerecho())));
        x.setAltura(1 + Math.max(obtenerAltura(x.getIzquierdo()), obtenerAltura(x.getDerecho())));

        return x;
    }
    
    
    private NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.getDerecho();
        NodoAVL T2 = y.getIzquierdo();

        y.setIzquierdo(x);
        x.setDerecho(T2);

        x.setAltura(1 + Math.max(obtenerAltura(x.getIzquierdo()), obtenerAltura(x.getDerecho())));
        y.setAltura(1 + Math.max(obtenerAltura(y.getIzquierdo()), obtenerAltura(y.getDerecho())));

        return y;
    }
    
    public void insertar(String key, String tituloArticulo) {
        if (key == null || tituloArticulo == null) return;

        key = key.toLowerCase().trim();
        tituloArticulo = tituloArticulo.trim();

        root = insertarRec(root, key, tituloArticulo);
    }
    
    private NodoAVL insertarRec(NodoAVL nodo, String key, String tituloArticulo) {
        if (nodo == null) {
            NodoAVL nuevo = new NodoAVL(key);
            nuevo.getTitulos().AgregarNodo(tituloArticulo);
            return nuevo;
        }

        // Comparación directa con compareTo()
        int cmp = key.compareTo(nodo.getKey());

        if (cmp < 0) {
            nodo.setIzquierdo(insertarRec(nodo.getIzquierdo(), key, tituloArticulo));
        } 
        else if (cmp > 0) {
            nodo.setDerecho(insertarRec(nodo.getDerecho(), key, tituloArticulo));
        } 
        else {
            if (!nodo.getTitulos().contains(tituloArticulo)) {
                nodo.getTitulos().AgregarNodo(tituloArticulo);
            }
            return nodo;
        }

        // Actualizar altura
        nodo.setAltura(1 + Math.max(obtenerAltura(nodo.getIzquierdo()), obtenerAltura(nodo.getDerecho())));
        int balance = obtenerBalance(nodo);


        // Casos de rotacion
        if (balance > 1 && key.compareTo(nodo.getIzquierdo().getKey()) < 0) {
            return rotacionDerecha(nodo);
        }

        if (balance < -1 && key.compareTo(nodo.getDerecho().getKey()) > 0) {
            return rotacionIzquierda(nodo);
        }

        if (balance > 1 && key.compareTo(nodo.getIzquierdo().getKey()) > 0) {
            nodo.setIzquierdo(rotacionIzquierda(nodo.getIzquierdo()));
            return rotacionDerecha(nodo);
        }

        if (balance < -1 && key.compareTo(nodo.getDerecho().getKey()) < 0) {
            nodo.setDerecho(rotacionDerecha(nodo.getDerecho()));
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }
}
