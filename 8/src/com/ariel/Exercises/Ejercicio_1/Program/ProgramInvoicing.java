package com.ariel.Exercises.Ejercicio_1.Program;

import com.ariel.Exercises.Ejercicio_1.Interfaces.IDelete;
import com.ariel.Exercises.Ejercicio_1.Interfaces.IInsert;
import com.ariel.Exercises.Ejercicio_1.Interfaces.ISelect;
import com.ariel.Exercises.Ejercicio_1.Interfaces.IUpdate;
import com.ariel.Exercises.Ejercicio_1.InterfacesImp.Invoicing.DeleteInvoicing;
import com.ariel.Exercises.Ejercicio_1.InterfacesImp.Invoicing.InsertInvoicing;
import com.ariel.Exercises.Ejercicio_1.InterfacesImp.Invoicing.SelectInvoicing;
import com.ariel.Exercises.Ejercicio_1.InterfacesImp.Invoicing.UpdateInvoicing;
import com.ariel.Exercises.Ejercicio_1.Models.Invoicing;
import java.util.List;
import java.util.Scanner;

public class ProgramInvoicing {
    private static ProgramInvoicing instance;
    private final Scanner sc;

    private ProgramInvoicing(){
        sc = new Scanner(System.in);
    }

    public static ProgramInvoicing getInstance(){
        if(instance == null){
            instance = new ProgramInvoicing();
        }
        return instance;
    }

    public void ShowInvoicing(){
        ISelect<Invoicing> invoicingISelect = SelectInvoicing.getInstance();
        List<Invoicing> invoicings = invoicingISelect.getElements();
        if(invoicings.isEmpty()){
            System.out.println("There is no invoices");
        }
        else{
            System.out.println("[");
            for(Invoicing invoicing: invoicings){
                System.out.println("\t{");
                System.out.println("\t\tId: " + invoicing.getId() + ",");
                System.out.println("\t\tId client: " + invoicing.getIdClient() + ",");
                System.out.println("\t\tId trader: " + invoicing.getIdTrader() + ",");
                System.out.println("\t\tTotal price: " + invoicing.getTotalPrice() + ",");
                System.out.println("\t\tBought date: " + invoicing.getBoughtDate());
                System.out.println("\t},");
            }
            System.out.println("]");
        }
    }

    public void SaveInvoicing(){
        int idClient, idTrader;
        IInsert<Invoicing> invoicingIInsert = InsertInvoicing.getInstance();

        System.out.println("Id client: ");
        idClient = sc.nextInt();

        System.out.println("Id trader: ");
        idTrader = sc.nextInt();


        invoicingIInsert.insertElement(new Invoicing(idClient, idTrader));

        System.out.println("Saved invoice");
    }

    public void UpdateInvoicing(){
        IUpdate<Invoicing> invoicingIUpdate = UpdateInvoicing.getInstance();
        int id, idClient, idTrader;

        System.out.println("Id invoice: ");
        id = sc.nextInt();

        System.out.println("client id: ");
        idClient = sc.nextInt();

        System.out.println("trader id: ");
        idTrader = sc.nextInt();

        invoicingIUpdate.updateElement(new Invoicing(id, idClient, idTrader));

        System.out.println("Updated invoice");
    }

    public void DeleteInvoicing(){
        IDelete invoicingDelete = DeleteInvoicing.getInstance();
        int id;

        System.out.println("Id: ");
        id = sc.nextInt();

        invoicingDelete.deleteElement(id);
    }
}
