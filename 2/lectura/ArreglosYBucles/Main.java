package lectura.ArreglosYBucles;

import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        int opc; 
        boolean salir=false;

        Scanner scan = new Scanner(System.in);

        while(!salir){

            System.out.println("1- Opcion 1");
            System.out.println("2- Opcion 2");
            System.out.println("3- Opcion 3");
            System.out.println("4- Salir");
            System.out.println("Ingrese una opcion");
            opc = scan.nextInt();

            switch(opc){
                case 1:
                    System.out.println("Opcion 1 seleccionada");
                    break;
                case 2:
                    System.out.println("Opcion 1 seleccionada");
                    break;
                case 3:
                    System.out.println("Opcion 1 seleccionada");
                    break;
                case 4:
                    System.out.println("Adios");
                    salir = true;
                    break;
                default: 
                    System.out.println("Ingrese una opcion valida");
                    break;
            }

        }
        scan.close();

    }
}