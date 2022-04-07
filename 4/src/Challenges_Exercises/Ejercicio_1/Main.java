package Challenges_Exercises.Ejercicio_1;

import Challenges_Exercises.Ejercicio_1.Exceptions.DemasiadoRapidoException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DemasiadoRapidoException {
        Scanner sc = new Scanner(System.in);
        int opc;
        boolean flag = false;
        Menu menu = new Menu();

        while(!flag){
            System.out.println(" Adquirir vehiculo ");
            System.out.println("1- Auto en particular");
            System.out.println("2- Auto de carga");
            System.out.println("3- salir");
            opc = sc.nextInt();
            switch (opc){
                case 1:
                    menu.vehiculoParticularMenu();
                    break;
                case 2:
                    menu.vehiculoCargaMenu();
                    break;
                case 3:
                        System.out.println("ADIOS");
                        flag = true;
            }
        }
    }
}
