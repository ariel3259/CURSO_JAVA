package com.ariel.Exercises.Ejercicio_1.Menu;

import com.ariel.Exercises.Ejercicio_1.Program.ProgramTraider;

import java.util.Scanner;

public class TraderMenu {
    private static TraderMenu instance;

    private TraderMenu(){
        ProgramTraider programTraider = ProgramTraider.getInstance();
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        int opc;
        while (!flag) {
            System.out.println("################################################################");
            System.out.println("\t\tWelcome to trader management");
            System.out.println("\t\t\tChose your option");
            System.out.println("\t\t1- Show all traders");
            System.out.println("\t\t2- Save trader");
            System.out.println("\t\t3- Modify trader");
            System.out.println("\t\t4- Delete trader");
            System.out.println("\t\t5- go to main menu");
            opc = sc.nextInt();
            switch(opc){
                case 1:
                    programTraider.ShowTraders();
                    break;
                case 2:
                    programTraider.insetTrader();
                    break;
                case 3:
                    programTraider.updateTrader();
                    break;
                case 4:
                    programTraider.deleteTrader();
                    break;
                case 5:
                    flag = true;
            }
        }
    }

    public static TraderMenu getInstance(){
        if(instance == null){
            instance = new TraderMenu();
        }
        return instance;
    }
}
