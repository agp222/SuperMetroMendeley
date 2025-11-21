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
    
    private NodoAVL rotacionDerecha(NodoAVL nodoActual) {
        NodoAVL nodoIzquierdo = nodoActual.getIzquierdo();
        NodoAVL subArbolDerecho = nodoIzquierdo.getDerecho();

        // Rotación
        nodoIzquierdo.setDerecho(nodoActual);
        nodoActual.setIzquierdo(subArbolDerecho);

        // Actualizar alturas
        nodoActual.setAltura(1 + Math.max(obtenerAltura(nodoActual.getIzquierdo()), obtenerAltura(nodoActual.getDerecho())));
        nodoIzquierdo.setAltura(1 + Math.max(obtenerAltura(nodoIzquierdo.getIzquierdo()), obtenerAltura(nodoIzquierdo.getDerecho())));

        return nodoIzquierdo;
    }
    
    
    private NodoAVL rotacionIzquierda(NodoAVL nodoActual) {
        NodoAVL nodoDerecho = nodoActual.getDerecho();
        NodoAVL subArbolIzquierdo = nodoDerecho.getIzquierdo();

        nodoDerecho.setIzquierdo(nodoActual);
        nodoActual.setDerecho(subArbolIzquierdo);

        nodoActual.setAltura(1 + Math.max(obtenerAltura(nodoActual.getIzquierdo()), obtenerAltura(nodoActual.getDerecho())));
        nodoDerecho.setAltura(1 + Math.max(obtenerAltura(nodoDerecho.getIzquierdo()), obtenerAltura(nodoDerecho.getDerecho())));

        return nodoDerecho;
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
        int comparacion = key.compareTo(nodo.getKey());

        if (comparacion < 0) {
            nodo.setIzquierdo(insertarRec(nodo.getIzquierdo(), key, tituloArticulo));
        } 
        else if (comparacion > 0) {
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
    
    
    public NodoAVL buscar(String key) {
        if (key == null){
            return null;
        }else{
            return buscarRec(root, key.toLowerCase().trim());
        }
        
    }

    private NodoAVL buscarRec(NodoAVL nodo, String key) {
        if (nodo == null) {
            return null;
        }else{

            int comparacion = key.compareTo(nodo.getKey());

            if (comparacion == 0) {
                return nodo;
            }
            if (comparacion < 0) {
                return buscarRec(nodo.getIzquierdo(), key);
            }
            
            return buscarRec(nodo.getDerecho(), key);
        }
    }
    
    
    public void inOrden() {
        inOrdenRec(root);
    }

    private void inOrdenRec(NodoAVL nodo) {
        if (nodo != null){
            inOrdenRec(nodo.getIzquierdo());
            System.out.println(nodo.getKey());
            inOrdenRec(nodo.getDerecho());
        } 
    }
}
