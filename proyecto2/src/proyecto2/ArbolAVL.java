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
    
    //Atributos
    private NodoAVL root;

    
    /**
     * Constructor del árbol AVL. Inicializa la raíz como null.
     */
    public ArbolAVL() {
        root = null;
    }

    public NodoAVL getRoot() {
        return root;
    }
    
    public NodoAVL getRaiz() {
        return root;
    }

    
    /**
     * Obtiene la altura del nodo especificado
     * 
     * @param nodo nodo del cual se quiere conocer la altura
     * @return la altura del nodo o 0 si es null
     */
    private int obtenerAltura(NodoAVL nodo) {
        if (nodo == null){
            return 0;
        }else{
            return nodo.getAltura();
        }
    }

    /**
     * Calcula el factor de balance de un nodo
     * El balance es igual a altura(izquierdo) - altura(derecho)
     * 
     * @param nodo nodo al cual se le calcula el balance
     * @return entero con el valor del balance
     */
    private int obtenerBalance(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        }
        
        int altura = obtenerAltura(nodo.getIzquierdo()) - obtenerAltura(nodo.getDerecho());
        return altura;
    }
    
    /**
     * Realiza una rotacion simple a la derecha
     * 
     * @param nodoActual nodo desbalanceado
     * @return nuevo nodo raiz del subarbol rotado
     */
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
    
    /**
     * Realiza una rotacion simple a la izquierda
     * 
     * @param nodoActual nodo desbalanceado
     * @return nuevo nodo raiz del subarbol rotado
     */
    private NodoAVL rotacionIzquierda(NodoAVL nodoActual) {
        NodoAVL nodoDerecho = nodoActual.getDerecho();
        NodoAVL subArbolIzquierdo = nodoDerecho.getIzquierdo();

        nodoDerecho.setIzquierdo(nodoActual);
        nodoActual.setDerecho(subArbolIzquierdo);

        nodoActual.setAltura(1 + Math.max(obtenerAltura(nodoActual.getIzquierdo()), obtenerAltura(nodoActual.getDerecho())));
        nodoDerecho.setAltura(1 + Math.max(obtenerAltura(nodoDerecho.getIzquierdo()), obtenerAltura(nodoDerecho.getDerecho())));

        return nodoDerecho;
    }
    
    
    /**
     * Inserta una clave en el arbol junto con el titulo del articulo donde aparece.
     * Si la clave existe, solamente agrega el titulo a la lista
     * 
     * @param key clave que se desea insertar
     * @param tituloArticulo título del articulo donde aparece la clave
     */
    public void insertar(String key, String tituloArticulo) {
        if (key == null || tituloArticulo == null) return;

        key = key.toLowerCase().trim();
        tituloArticulo = tituloArticulo.trim();

        root = insertarRec(root, key, tituloArticulo);
    }
    
    /**
     * Insercion recursiva de claves en el arbol. Se encarga de mantener el balance mediante rotaciones
     * 
     * @param nodo nodo actual
     * @param key clave a insertar
     * @param tituloArticulo titulo asociado a la clave
     * @return nodo raiz actualizado del subarbol
     */
    private NodoAVL insertarRec(NodoAVL nodo, String key, String tituloArticulo) {
        key = (String) normalizar(key.trim()); 
        tituloArticulo = tituloArticulo.trim();
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
    
    /**
     * Busca una clave dentro del arbol
     * 
     * @param key clave que se desea encontrar
     * @return nodo que contiene la clave, o null si no existe
     */
    public NodoAVL buscar(String key) {
        if (key == null){
            return null;
        }else{
            return buscarRec(root, key.toLowerCase().trim());
        }
        
    }

    /**
     * Buqueda recursiva de una clave en el arbol
     * 
     * @param nodo nodo actual
     * @param key clave a buscar
     * @return nodo donde se encuentra la clave o null si no está
     */
    private NodoAVL buscarRec(NodoAVL nodo, String key) {
        if (nodo == null) {
            return null;
        }else{

            int comparacion = normalizar(key).compareTo(normalizar(nodo.getKey()));
            
            if (comparacion == 0) {
                return nodo;
            }
            if (comparacion < 0) {
                return buscarRec(nodo.getIzquierdo(), key);
            }
            
            return buscarRec(nodo.getDerecho(), key);
        }
    }
    
    /**
     * Realiza un recorrido in-orden del árbol.
     */
    public void inOrden() {
        inOrdenRec(root);
    }
    
    /**
     * Recorrido in-orden recursivo.
     * 
     * @param nodo nodo actual.
     */
    private void inOrdenRec(NodoAVL nodo) {
        if (nodo != null){
            inOrdenRec(nodo.getIzquierdo());
            System.out.println(nodo.getKey());
            inOrdenRec(nodo.getDerecho());
        } 
    }
    
    public String[] obtenerInOrdenArray() {
        ListaSimple lista = obtenerListaDeClaves();
        String[] arr = new String[lista.getSize()];

        NodoLista actual = lista.getpFirst();
        int i = 0;

        while (actual != null) {
            arr[i++] = (String) actual.getValue();
            actual = actual.getpNext();
        }

        return arr;
    }
    
    public ListaSimple obtenerListaDeClaves() {
        ListaSimple lista = new ListaSimple();
        obtenerClavesRec(root, lista);
        return lista;
    }

    private void obtenerClavesRec(NodoAVL nodo, ListaSimple lista) {
        if (nodo != null) {
            obtenerClavesRec(nodo.getIzquierdo(), lista);
            lista.AgregarNodo(nodo.getKey());
            obtenerClavesRec(nodo.getDerecho(), lista);
        }
    }

    
    public String listarTitulos(String key) {
        NodoAVL nodo = buscar(key);

        if (nodo == null) {
            return "No se encontraron investigaciones asociadas.";
        }

        NodoLista actual = nodo.getTitulos().getpFirst();
        String resultado = "";

        while (actual != null) {
            resultado += actual.getValue() + "\n";
            actual = actual.getpNext();
        }

        return resultado;
    }
    
    public String obtenerInOrden() {
        return obtenerInOrdenRec(root);
    }

    private String obtenerInOrdenRec(NodoAVL nodo) {
        if (nodo == null) {
            return "";
        }

        String izquierda = obtenerInOrdenRec(nodo.getIzquierdo());
        String actual = nodo.getKey() + "\n";
        String derecha = obtenerInOrdenRec(nodo.getDerecho());

        return izquierda + actual + derecha;
    }

    
    private String normalizar(String texto) {
        texto = texto.toLowerCase();

        texto = texto.replace("á","a")
                     .replace("é","e")
                     .replace("í","i")
                     .replace("ó","o")
                     .replace("ú","u")
                     .replace("ü","u")
                     .replace("ñ","n");

        return texto;
    }

    
}
