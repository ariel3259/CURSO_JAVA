//Realizar una calculadora que realize las operaciones básicas
package challenges.Ejercicio_1;

import java.util.Scanner;

public class Main{

    public static void main(String args[]){
        char opc;
        float numero1, numero2;
        boolean salir=false;
        Scanner scanner = new Scanner(System.in);
        Calculadora calculadora;    
        
        System.out.println("Calculadora");
        while(!salir){
            System.out.println("a- Suma");
            System.out.println("b- Resta");
            System.out.println("c- Multiplicar");
            System.out.println("d- Dividir");
            System.out.println("f- Salir");
            System.out.println("Ingrese una opcion: ");
            opc = scanner.next().charAt(0);



            switch(opc){
                case 'a':
                    System.out.println("Ingrese un numero: ");
                    numero1 = scanner.nextFloat();
    
                    System.out.println("Ingrese otro numero: ");
                    numero2 = scanner.nextFloat();
    
                    calculadora = new Calculadora(numero1, numero2);
                    System.out.println("El resultado de la operacion es: "+ calculadora.Suma());
                    break;
                case 'b':
                    System.out.println("Ingrese un numero: ");
                    numero1 = scanner.nextFloat();
    
                    System.out.println("Ingrese otro numero: ");
                    numero2 = scanner.nextFloat();
    
                    calculadora = new Calculadora(numero1, numero2);
                    System.out.println("El resultado de la operacion es: "+ calculadora.Resta());
                    break;
                case 'c': 
                    System.out.println("Ingrese un numero: ");
                    numero1 = scanner.nextFloat();
    
                    System.out.println("Ingrese otro numero: ");
                    numero2 = scanner.nextFloat();
    
                    calculadora = new Calculadora(numero1, numero2);
                    System.out.println("El resultado de la operacion es: "+ calculadora.Multiplicar());
                    break;
                case 'd':
                    System.out.println("Ingrese un numero: ");
                    numero1 = scanner.nextFloat();
    
                    System.out.println("Ingrese otro numero: ");
                    numero2 = scanner.nextFloat();
    
                    calculadora = new Calculadora(numero1, numero2);
                    System.out.println("El resultado de la operacion es: "+ calculadora.Dividir());
                    break;
                case 'f':
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