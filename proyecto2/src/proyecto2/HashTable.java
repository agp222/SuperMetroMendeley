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
    
    
    public boolean insertar(String clave, Articulo valor) {
        //int index = hash(clave);
        int index = 00;
        Nodo actual = tabla[index];

        while (actual != null) {
            if (actual.getClave().equals(clave)) {
                return false;
            }
            actual = actual.getSiguiente();
        }

        Nodo nuevo = new Nodo(clave, valor);
        nuevo.setSiguiente(tabla[index]);
        tabla[index] = nuevo;
        size = size + 1;
        return true;
    }
    
}
