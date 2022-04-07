package Crear_Ejercicios.Ejercicio_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var capital = 0.5;
        var razon = 0.5;
        var tiempo = 0;
        var interes = 0.5;
        var sc = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de capital");
        capital = sc.nextDouble();

        System.out.println("Ingrese la cantidad de meses");
        tiempo = sc.nextInt();

        System.out.println("Ingrese la tasa de interes");
        razon = sc.nextDouble();

        interes = (capital * razon * tiempo) / (100 * 12);
        capital += interes;
        System.out.println("El interes a pagar es: "+ interes);
        System.out.println("Total a cobrar: "+ capital);
    }
}
