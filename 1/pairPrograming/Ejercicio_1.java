package pairPrograming;
import java.util.Scanner;

/*
    Ejercico 1: 
        Hacer una programa que realize la serie de fibonacci.

    
*/


public class Ejercicio_1{

    
    public static void main(String[] args){
        int numero,x = 0, y = 1, z = 1;

        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese un numero");
        numero = scan.nextInt();
        
        scan.close();

        for(int i = 0; i < numero; i++){
            z = x + y;
            System.out.println(z);
            x = y;
            y = z;
         }

    }
    
}