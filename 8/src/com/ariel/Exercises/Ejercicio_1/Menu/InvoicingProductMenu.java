package com.ariel.Exercises.Ejercicio_1.Menu;

import com.ariel.Exercises.Ejercicio_1.Program.ProgramInvoicingProducts;
import java.util.Scanner;

public class InvoicingProductMenu {
    private static InvoicingProductMenu instance;

    private InvoicingProductMenu(){
        ProgramInvoicingProducts programInvoicingProducts =  ProgramInvoicingProducts.getInstance();
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        int opc;
        while (!flag) {
            System.out.println("################################################################");
            System.out.println("\t\tWelcome to product at invoice management");
            System.out.println("\t\t\tChose your option");
            System.out.println("\t\t1- Show all products at invoices");
            System.out.println("\t\t2- Save product at invoice");
            System.out.println("\t\t3- Modify product at invoice");
            System.out.println("\t\t4- Delete product at invoice");
            System.out.println("\t\t5- go to main menu");
            opc = sc.nextInt();
            switch(opc){
                case 1:
                    programInvoicingProducts.ShowInvoicingProduct();
                    break;
                case 2:
                    programInvoicingProducts.SaveProductIntoInvoice();
                    break;
                case 3:
                    programInvoicingProducts.UpdateProductInvoice();
                    break;
                case 4:
                    programInvoicingProducts.DeleteProductInvoice();
                    break;
                case 5:
                    flag = true;
            }
        }
    }

    public static InvoicingProductMenu getInstance(){
        if(instance == null){
            instance = new InvoicingProductMenu();
        }
        return instance;
    }
}
