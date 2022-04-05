
package challenges.Ejercicio_4;

import java.util.LinkedList;
import java.util.List;

class Main{

    public static void main(String[] args) {
        
        //Ordenar un arreglo de Strings 
        //de la a a la l por cantidad de letras
        //de la l a la z de manera alfabetico

        String[] arregloDeTexto = {"coder", "devplace", "personas", "cursos", "alumnos"};

        List<String> arregloOrdenadoPorCantidadDeLetras = new LinkedList<>();

        int a = (int) 'a', l = (int) 'l', z = (int) 'z' ;

        for(int i = 0; i < arregloDeTexto.length; i++){
            int letra = (int) arregloDeTexto[i].charAt(1);
            if((letra >= a) && (letra <= l )){

            }
        }


    }
}