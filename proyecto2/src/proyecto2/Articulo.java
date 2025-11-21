/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author Antonio Guzzo
 */


/**
 * Representa un artículo académico o resumen con información asociada como titulo, autores, palabras clave.
 * 
 * Se llama en el HashTable
 * 
 */
public class Articulo {
    
    //Atributos
    private int hash;
    private String titulo;
    private String[] autores;
    private String resumenCompleto;
    private String[] palabrasClave;
    private int[] frecuenciaPalabras;

    
    /**
     * Crea un nuevo objeto con todos sus atributos inicializados.
     *
     * @param hash identificador hash único del articulo
     * @param titulo titulo del articulo
     * @param autores lista de autores
     * @param resumenCompleto texto completo del resumen
     * @param palabrasClave palabras clave asociadas
     * @param frecuenciaPalabras frecuencias de cada palabra clave
     */
    public Articulo(int hash, String titulo, String[] autores, String resumenCompleto, String[] palabrasClave, int[] frecuenciaPalabras) {
        this.hash = hash;
        this.titulo = titulo;
        this.autores = autores;
        this.resumenCompleto = resumenCompleto;
        this.palabrasClave = palabrasClave;
        this.frecuenciaPalabras = frecuenciaPalabras;
    }

    /**
     * Obtiene el identificador hash del articulo
     * @return el hash como {@code int}
     */
    public int getHash() {
        return hash;
    }
    
    /**
     * Establece el identificador hash del articulo
     * @param hash nuevo valor del hash
     */
    public void setHash(int hash) {
        this.hash = hash;
    }
    
    /**
     * Obtiene el titulo del articulo
     * @return el titulo como {@code String}
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el titulo del articulo
     * @param titulo nuevo titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene la lista de autores del articulo
     * @return un arreglo de {@code String} con los autores
     */
    public String[] getAutores() {
        return autores;
    }

    
    /**
     * Establece nueva lista de autores del articulo
     * @param autores nuevo arreglo de autores
     */
    public void setAutores(String[] autores) {
        this.autores = autores;
    }

    
    /**
     * Obtiene el resumen completo del articulo
     * @return el resumen como {@code String}
     */
    public String getResumenCompleto() {
        return resumenCompleto;
    }
    
    /**
     * Establece el resumen completo del articulo
     * @param resumenCompleto nuevo texto del resumen
     */
    public void setResumenCompleto(String resumenCompleto) {
        this.resumenCompleto = resumenCompleto;
    }

     /**
     * Obtiene las palabras clave asociadas al articulo
     * @return arreglo de {@code String} con las palabras clave
     */
    public String[] getPalabrasClave() {
        return palabrasClave;
    }

    /**
     * Establece las palabras clave del articulo
     * @param palabrasClave nuevo arreglo de palabras clave
     */
    public void setPalabrasClave(String[] palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    /**
     * Obtiene la frecuencia de cada palabra clave
     * @return arreglo de enteros con las frecuencias
     */
    public int[] getFrecuenciaPalabras() {
        return frecuenciaPalabras;
    }
    
    /**
     * Establece la frecuencia de cada palabra clave
     * @param frecuenciaPalabras nuevo arreglo de frecuencias
     */
    public void setFrecuenciaPalabras(int[] frecuenciaPalabras) {
        this.frecuenciaPalabras = frecuenciaPalabras;
    }
    
    
    public void mostrar(){
        System.out.println("Artículo creado:");
        System.out.println("Título: " + this.getTitulo());
        System.out.println("Autores: " + String.join(", ", this.getAutores()));
        System.out.println("Resumen: " + this.getResumenCompleto());
        System.out.println("Palabras Clave: " + String.join(", ", this.getPalabrasClave()));
        System.out.println("-----------------------------------");
    }
    
    public void analizarFrecuencias() {
        // Normalizar el texto
        String texto = resumenCompleto.toLowerCase();

        for (int i = 0; i < palabrasClave.length; i++) {
            String palabra = palabrasClave[i].toLowerCase().trim();
            int contador = 0;

            // Buscar ocurrencias sin expresiones regulares
            int index = texto.indexOf(palabra);
            while (index != -1) {
                contador++;
                index = texto.indexOf(palabra, index + palabra.length());
            }

            frecuenciaPalabras[i] = contador;
        }
    }

   
    
    public String reporteAnalisis() {
        String resultado = "Análisis del artículo:\n";
        resultado += "Título: " + titulo + "\n\n";
        resultado += "Palabras clave:\n";

        for (int i = 0; i < palabrasClave.length; i++) {
            resultado += "- " + palabrasClave[i] + " → " + frecuenciaPalabras[i] + " ocurrencias\n";
        }

        return resultado;
    }

   
}
