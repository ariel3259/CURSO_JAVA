package com.ariel.Exercises.Ejercicio_1.Program;

import com.ariel.Exercises.Ejercicio_1.Interfaces.IDelete;
import com.ariel.Exercises.Ejercicio_1.Interfaces.IInsert;
import com.ariel.Exercises.Ejercicio_1.Interfaces.ISelect;
import com.ariel.Exercises.Ejercicio_1.Interfaces.IUpdate;
import com.ariel.Exercises.Ejercicio_1.InterfacesImp.InvoicingProducts.DeleteInvoicingProducts;
import com.ariel.Exercises.Ejercicio_1.InterfacesImp.InvoicingProducts.InsertInvoicingProducts;
import com.ariel.Exercises.Ejercicio_1.InterfacesImp.InvoicingProducts.SelectInvoicingProducts;
import com.ariel.Exercises.Ejercicio_1.InterfacesImp.InvoicingProducts.UpdateInvoicingProducts;
import com.ariel.Exercises.Ejercicio_1.Models.InvoicingProducts;

import java.util.List;
import java.util.Scanner;

public class ProgramInvoicingProducts {

    private static ProgramInvoicingProducts instance;
    private final Scanner sc;

    private ProgramInvoicingProducts(){
        sc = new Scanner(System.in);
    }

    public static ProgramInvoicingProducts getInstance(){
        if(instance == null){
            instance = new ProgramInvoicingProducts();
        }
        return instance;
    }

    public void ShowInvoicingProduct(){
        ISelect<InvoicingProducts> invoicingProductsISelect = SelectInvoicingProducts.getInstance();
        List<InvoicingProducts> invoicingProducts = invoicingProductsISelect.getElements();
        if(invoicingProducts.isEmpty()){
            System.out.println("There is no products at the invoice");
        }
        else{
            System.out.println("[");
            for(InvoicingProducts invoicingProduct: invoicingProducts){
                System.out.println("\t{");
                System.out.println("\t\t Id: " + invoicingProduct.getId() + ",");
                System.out.println("\t\tId invoice: " + invoicingProduct.getIdInvoicing() + ",");
                System.out.println("\t\tId product: " + invoicingProduct.getIdProduct() + ",");
                System.out.println("\t\tItems: " + invoicingProduct.getLength() + ",");
                System.out.println("\t},");
            }
            System.out.println("]");
        }
    }

    public void SaveProductIntoInvoice(){
        IInsert<InvoicingProducts> invoicingProductsIInsert = InsertInvoicingProducts.getInstance();
        int idInvoice, idProduct, items;

        System.out.println("Id invoice: ");
        idInvoice = sc.nextInt();

        System.out.println("Id product: ");
        idProduct = sc.nextInt();

        System.out.println("Items: ");
        items = sc.nextInt();

        invoicingProductsIInsert.insertElement(new InvoicingProducts(idInvoice, idProduct, items));

        System.out.println("Saved product at invoice");
    }

    public void UpdateProductInvoice(){
        IUpdate<InvoicingProducts> invoicingProductsIUpdate = UpdateInvoicingProducts.getInstance();
        int idInvoice, idProduct, items, id;

        System.out.println("Id: ");
        id = sc.nextInt();

        System.out.println("Id invoice: ");
        idInvoice = sc.nextInt();

        System.out.println("Id product: ");
        idProduct = sc.nextInt();

        System.out.println("Items: ");
        items = sc.nextInt();

        invoicingProductsIUpdate.updateElement(new InvoicingProducts(id, idInvoice, idProduct, items));

        System.out.println("Updated product at invoice");
    }

    public void DeleteProductInvoice(){
        IDelete iDelete = DeleteInvoicingProducts.getInstance();
        int id;

        System.out.println("Id: ");
        id = sc.nextInt();

        iDelete.deleteElement(id);

        System.out.println("Deleted product at invoice ");

    }

}
