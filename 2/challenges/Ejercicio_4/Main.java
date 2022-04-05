
package challenges.Ejercicio_4;

import java.util.LinkedList;
import java.util.List;

class Main{

    public static void main(String[] args) {
        
        //Ordenar un arreglo de Strings 
        //de la a a la l por cantidad de letras
        //de la l a la z de manera alfabetico

        String[] arregloDeTexto = {"coder", "devplace", "personas", "cursos", "alumnos", "leon", "zota"};

        ordenarFila(arregloDeTexto);

    }

    public static void ordenarFila(String[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].length() > array[j].length()) {
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        for(String cadena: array){
            System.out.println(cadena);
        }
    }
}