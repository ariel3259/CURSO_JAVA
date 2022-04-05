
package challenges.Ejercicio_3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Integer[] numeros = new Integer[10];
        int max=0, min=99999;

        for(int i = 0; i < numeros.length; i++){
            System.out.println("Ingrese numero "+(i+1)+": ");
            numeros[i] = scan.nextInt();
        }

        scan.close();

        for(int i = 0; i < numeros.length; i++){
            if(numeros[i] > max) max = numeros[i];
            if(numeros[i] < min) min = numeros[i];
        }

        System.out.println("Numero mayor: "+ max);
        System.out.println("Numero menor: "+ min);

        System.out.println("Numeros pares: ");
        for(int i = 0; i < numeros.length; i++){
            if(numeros[i]%2 == 0) System.out.println(numeros[i]);
        }

    

        System.out.println("Numeros impares:");
        for(int i = 0; i < numeros.length; i++){
            if(numeros[i]%2 == 1) System.out.println(numeros[i]);
        }
        

        System.out.println("Numeros ordenados de menor a mayor: ");
        Arrays.sort(numeros);
        for(int i = 0; i < numeros.length; i++){
            System.out.println(numeros[i]);
        }

        System.out.println("Numeros ordenados de mayor a menor");
        Arrays.sort(numeros, Collections.reverseOrder()); 
        for(int i = 0; i < numeros.length; i++){
            System.out.println(numeros[i]);
        }

    }
} 