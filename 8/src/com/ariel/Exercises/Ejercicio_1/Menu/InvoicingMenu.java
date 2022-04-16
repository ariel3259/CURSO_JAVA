package com.ariel.Exercises.Ejercicio_1.Menu;

import com.ariel.Exercises.Ejercicio_1.Program.ProgramInvoicing;
import java.util.Scanner;

public class InvoicingMenu {

    private static InvoicingMenu instance;

    private InvoicingMenu(){
        ProgramInvoicing programInvoicing = ProgramInvoicing.getInstance();
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        int opc;
        while (!flag) {
            System.out.println("################################################################");
            System.out.println("\t\tWelcome to invoice management");
            System.out.println("\t\t\tChose your option");
            System.out.println("\t\t1- Show all invoices");
            System.out.println("\t\t2- Save invoice");
            System.out.println("\t\t3- Modify invoice");
            System.out.println("\t\t4- Delete invoice");
            System.out.println("\t\t5- go to main menu");
            opc = sc.nextInt();
            switch(opc){
                case 1:
                    programInvoicing.ShowInvoicing();
                    break;
                case 2:
                    programInvoicing.SaveInvoicing();
                    break;
                case 3:
                    programInvoicing.UpdateInvoicing();
                    break;
                case 4:
                    programInvoicing.DeleteInvoicing();
                    break;
                case 5:
                    flag = true;
            }
        }
    }

    public static InvoicingMenu getInstance(){
        if(instance == null){
            instance = new InvoicingMenu();
        }
        return instance;
    }
}
