package Challenges.Ejercicio_1;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        String[] countries = new String[5];
        String[][] cities = new String[5][3];

        Scanner scan = new Scanner(System.in);

        for(int i = 0; i < countries.length; i++){
            System.out.println("Ingrese un pais");
            countries[i] = scan.next();
        }

        for(int i = 0; i < 5; i++){
            scan.nextLine();
            for(int j = 0; j < 3; j++){
                System.out.println("Ingrese ciudad de "+countries[i]+": ");
                cities[i][j] = scan.nextLine();
            }
        }

        scan.close();

        System.out.println();

        for(int i = 0; i < 5; i++){
            System.out.println("\t Ciudades de "+countries[i]+": ");
            for(int j = 0; j < 3; j++){
                System.out.println("Ciudad "+ cities[i][j]);
            }
            System.out.println();
        }

    }
}