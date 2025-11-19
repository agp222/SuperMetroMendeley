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
    
    
    public int hash(String titulo) {
        int hash = 0;
        for (int i = 0; i < titulo.length(); i++) {
            hash += titulo.charAt(i);
        }
        return hash % capacidad;
    }
    
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
    
}
