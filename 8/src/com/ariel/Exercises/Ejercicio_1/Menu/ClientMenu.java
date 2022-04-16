package com.ariel.Exercises.Ejercicio_1.Menu;

import com.ariel.Exercises.Ejercicio_1.Program.ProgramClient;

import java.util.Scanner;

public class ClientMenu {

    private static ClientMenu instance;

    private ClientMenu(){
        ProgramClient programClient =  ProgramClient.getInstance();
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
            System.out.println("\t\t5- go to main menu");
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
                    flag = true;
            }
        }
    }

    public static ClientMenu getInstance(){
        if(instance == null){
            instance = new ClientMenu();
        }
        return instance;
    }
}
