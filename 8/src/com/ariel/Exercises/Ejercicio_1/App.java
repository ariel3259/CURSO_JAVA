package com.ariel.Exercises.Ejercicio_1;

import com.ariel.Exercises.Ejercicio_1.Program.ProgramClient;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ProgramClient programClient = new ProgramClient();
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        int opc;
        while (!flag) {
            System.out.println("################################################################");
            System.out.println("\t\tWelcome to client management");
            System.out.println("\t\t\tChose your option");
            System.out.println("\t\t1- Show all clients");
            System.out.println("\t\t2- Save client");
            System.out.println("\t\t3- Modify client");
            System.out.println("\t\t4- Delete client");
            System.out.println("\t\t5- Exit");
            opc = sc.nextInt();
            switch(opc){
                case 1:
                    programClient.ShowClients();
                    break;
                case 2:
                    programClient.insetClient();
                    break;
                case 3:
                    programClient.updateClient();
                    break;
                case 4:
                    programClient.deleteClient();
                    break;
                case 5:
                    System.out.println("Goodbye");
                    flag = true;
            }
        }

    }
}
