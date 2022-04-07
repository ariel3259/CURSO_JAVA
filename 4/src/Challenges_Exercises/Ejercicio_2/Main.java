package Challenges_Exercises.Ejercicio_2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Double numero1, numero2, numero3, numero4, resultado, resultado_test;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el primer numero");
        numero1 = sc.nextDouble();

        System.out.println("Ingrese el segundo numero");
        numero2 = sc.nextDouble();

        System.out.println("Ingrese el tercer numero");
        numero3 = sc.nextDouble();

        System.out.println("Ingrese el cuarto numero");
        numero4 = sc.nextDouble();

        resultado_test = numero1 + numero2 - numero3 * numero4;

        resultado = (numero1 + numero2 - numero3 * numero4) / resultado_test + 2.1;

        System.out.println(resultado);
    }
}
