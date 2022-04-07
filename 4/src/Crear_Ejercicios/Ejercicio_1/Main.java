package Crear_Ejercicios.Ejercicio_1;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        /*
         Se asigna en ejecucion
         */
        var calculadoraDeLaLeyDeOhm = new Ohm();
        var potencia = 0.5;
        var intensidad = 0.5;
        var voltios = 0.5;
        var resistencia = 0.5;
        var flag = false;
        var opc = 0;
        var sc = new Scanner(System.in);

        while(!flag){
            System.out.println("Que desea calcular");
            System.out.println("1- Potencia");
            System.out.println("2- Intencidad");
            System.out.println("3- Resistencia");
            System.out.println("4- Tension");
            System.out.println("5- Salir");
            opc = sc.nextInt();
            switch (opc){
                case 1:
                    System.out.println("Ingrese el valor de la resistencia: ");
                    resistencia = sc.nextDouble();
                    System.out.println("Ingrese el valor de la intensidad: ");
                    intensidad = sc.nextDouble();
                    potencia = calculadoraDeLaLeyDeOhm.obtenerPotencia(resistencia, intensidad);
                    System.out.println("La potencia es de "+potencia+"w");
                    break;
                case 2:
                    System.out.println("Ingrese el valor de la potencia: ");
                    potencia = sc.nextDouble();
                    System.out.println("Ingrese el valor de la voltios: ");
                    voltios = sc.nextDouble();
                    intensidad = calculadoraDeLaLeyDeOhm.obtenerIntentcidad(potencia, voltios);
                    System.out.println("La intensidad es de "+intensidad+"A");
                    break;
                case 3:
                    System.out.println("Ingrese el valor de la voltios: ");
                    voltios = sc.nextDouble();
                    System.out.println("Ingrese el valor de la potencia: ");
                    potencia = sc.nextDouble();
                    resistencia = calculadoraDeLaLeyDeOhm.obtenerResistencia(voltios, potencia);
                    System.out.println("La resistencia es de "+resistencia+" ohmnios");
                    break;
                case 4:
                    System.out.println("Ingrese el valor de la potencia: ");
                    potencia = sc.nextDouble();
                    System.out.println("Ingrese el valor de la resistencia: ");
                    resistencia = sc.nextDouble();
                    voltios = calculadoraDeLaLeyDeOhm.obtenerTension(potencia, resistencia);
                    System.out.println("La tension es de "+voltios+"V");
                    break;
                case 5:
                    System.out.println("Adios");
                    flag = true;
                    break;
                default :
                    System.out.println("Ingrese una opcion valida");
            }
        }
        System.out.println("Potencia: "+potencia+" W");
        System.out.println("Resistencia: "+resistencia+" ohmnios");
        System.out.println("Intensidad: "+intensidad+" A");
        System.out.println("Tension: "+voltios+" V");
    }
}
