/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author Antonio Guzzo
 */
public class Articulo {
    
    //Atributos
    private String hash;
    private String titulo;
    private String[] autores;
    private String resumenCompleto;
    private String[] palabrasClave;
    private int[] frecuenciaPalabras;

    public Articulo(String hash, String titulo, String[] autores, String resumenCompleto, String[] palabrasClave, int[] frecuenciaPalabras) {
        this.hash = hash;
        this.titulo = titulo;
        this.autores = autores;
        this.resumenCompleto = resumenCompleto;
        this.palabrasClave = palabrasClave;
        this.frecuenciaPalabras = frecuenciaPalabras;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String[] getAutores() {
        return autores;
    }

    public void setAutores(String[] autores) {
        this.autores = autores;
    }

    public String getResumenCompleto() {
        return resumenCompleto;
    }

    public void setResumenCompleto(String resumenCompleto) {
        this.resumenCompleto = resumenCompleto;
    }

    public String[] getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(String[] palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    public int[] getFrecuenciaPalabras() {
        return frecuenciaPalabras;
    }

    public void setFrecuenciaPalabras(int[] frecuenciaPalabras) {
        this.frecuenciaPalabras = frecuenciaPalabras;
    }

    
   
    
    
   
}
