//Realizar una calculadora que realize las operaciones básicas
package challenges.Ejercicio_1;

import java.util.Scanner;

public class Main{

    public static void main(String args[]){
        int opc;
        float numero1, numero2;
        boolean salir=false;
        Scanner scanner = new Scanner(System.in);
        Calculadora calculadora;    
        
        System.out.println("Calculadora");
        while(!salir){
            System.out.println("1- Suma");
            System.out.println("2- Resta");
            System.out.println("3- Multiplicar");
            System.out.println("4- Dividir");
            System.out.println("5- Salir");
            System.out.println("Ingrese una opcion: ");
            opc = scanner.nextInt();



            switch(opc){
                case 1:
                    System.out.println("Ingrese un numero: ");
                    numero1 = scanner.nextFloat();
    
                    System.out.println("Ingrese otro numero: ");
                    numero2 = scanner.nextFloat();
    
                    calculadora = new Calculadora(numero1, numero2);
                    System.out.println("El resultado de la operacion es: "+ calculadora.Suma());
                    break;
                case 2:
                    System.out.println("Ingrese un numero: ");
                    numero1 = scanner.nextFloat();
    
                    System.out.println("Ingrese otro numero: ");
                    numero2 = scanner.nextFloat();
    
                    calculadora = new Calculadora(numero1, numero2);
                    System.out.println("El resultado de la operacion es: "+ calculadora.Resta());
                    break;
                case 3: 
                    System.out.println("Ingrese un numero: ");
                    numero1 = scanner.nextFloat();
    
                    System.out.println("Ingrese otro numero: ");
                    numero2 = scanner.nextFloat();
    
                    calculadora = new Calculadora(numero1, numero2);
                    System.out.println("El resultado de la operacion es: "+ calculadora.Multiplicar());
                    break;
                case 4:
                    System.out.println("Ingrese un numero: ");
                    numero1 = scanner.nextFloat();
    
                    System.out.println("Ingrese otro numero: ");
                    numero2 = scanner.nextFloat();
    
                    calculadora = new Calculadora(numero1, numero2);
                    System.out.println("El resultado de la operacion es: "+ calculadora.Dividir());
                    break;
                case 5:
                    System.out.println("Adios");
                    salir = true;
                    break;
                default: 
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
            
        }
        scanner.close();
    }
}