/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author Antonio Guzzo
 */
public class HashTable {
    private Nodo[] tabla;
    private int capacidad;
    private int size;
    
    public HashTable(int capacidad) {
        this.capacidad = capacidad;
        this.tabla = new Nodo[capacidad];
        this.size = 0;
    }
    
    /**
    * Calcula el índice hash correspondiente a un título
    * La función suma el valor ASCII de cada caracter del título y lo módulo la capacidad
    *
    * @param titulo título del artículo
    * @return índice hash donde debe almacenarse
    */
    public int hash(String titulo) {
        int hash = 0;
        for (int i = 0; i < titulo.length(); i++) {
            hash += titulo.charAt(i);
        }
        return hash % capacidad;
    }
    
    /**
    * Inserta un artículo en la tabla hash usando encadenamiento.
    * Si ya existe un artículo con el mismo título, no se inserta.
    *
    * @param titulo clave de almacenamiento del artículo
    * @param valor objeto Articulo asociado
    * @return true si fue insertado, false si ya existía
    */
    public boolean insertar(String titulo, Articulo valor) {
        int index = hash(titulo);
        
        valor.setHash(index);
        //int index = 00;
        Nodo actual = tabla[index];

        while (actual != null) {
            if (actual.getClave().equals(titulo)) {
                return false;
            }
            actual = actual.getSiguiente();
        }

        Nodo nuevo = new Nodo(titulo, valor);
        nuevo.setSiguiente(tabla[index]);
        tabla[index] = nuevo;
        size = size + 1;
        return true;
    }
    
    /**
    * Busca un artículo dentro de la tabla hash usando el título como clave.
    *
    * @param titulo título a buscar
    * @return el artículo encontrado, o null si no está registrado
    */
    public Articulo buscar(String titulo) {
        int index = hash(titulo);
        Nodo actual = tabla[index];

        while (actual != null) {
            if (actual.getClave().equals(titulo)) {
                return actual.getValor();
            }
            actual = actual.getSiguiente();
        }

        return null;
    }
    
    /**
    * Obtiene una ListaSimple con todos los títulos almacenados en la tabla hash.
    *
    * @return lista enlazada simple con los títulos
    */
    public ListaSimple obtenerListaTitulos() {
        ListaSimple lista = new ListaSimple();

        for (int i = 0; i < capacidad; i++) {
            Nodo actual = tabla[i];
            while (actual != null) {
                lista.AgregarNodo(actual.getClave());
                actual = actual.getSiguiente();
            }
        }
        return lista;
    }
}
