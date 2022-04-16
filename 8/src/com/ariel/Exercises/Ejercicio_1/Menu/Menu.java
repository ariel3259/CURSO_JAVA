package com.ariel.Exercises.Ejercicio_1.Menu;

import com.ariel.Exercises.Ejercicio_1.Program.ProgramClient;
import com.ariel.Exercises.Ejercicio_1.Program.ProgramTraider;

import java.util.Scanner;

public class Menu {

    public Menu(){
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        int opc;
        while(!flag){
            System.out.println("################################################################");
            System.out.println("\t\tWelcome to Store management program");
            System.out.println("\t\t\t Chose a management program");
            System.out.println("\t\t1- Client management");
            System.out.println("\t\t2- Trader management");
            System.out.println("\t\t3- Products management");
            System.out.println("\t\t4- Invoices management");
            System.out.println("\t\t5- Invoices products managements");
            System.out.println("\t\t6- Exit");
            opc = sc.nextInt();
            switch(opc){
                case 1:
                    ClientMenu.getInstance();
                    break;
                case 2:
                    TraderMenu.getInstance();
                    break;
                case 3:
                    ProductMenu.getInstance();
                    break;
                case 4:
                    InvoicingMenu.getInstance();
                    break;
                case 5:
                    InvoicingProductMenu.getInstance();
                    break;
                case 6:
                    System.out.println("Goodbye");
                    flag = true;
            }
        }

    }


}
