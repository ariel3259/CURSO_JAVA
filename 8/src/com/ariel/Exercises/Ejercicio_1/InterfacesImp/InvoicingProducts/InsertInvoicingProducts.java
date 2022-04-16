package com.ariel.Exercises.Ejercicio_1.InterfacesImp.InvoicingProducts;

import com.ariel.Exercises.Ejercicio_1.Db.ConnectDB;
import com.ariel.Exercises.Ejercicio_1.Interfaces.IInsert;
import com.ariel.Exercises.Ejercicio_1.Models.InvoicingProducts;
import java.sql.PreparedStatement;


public class InsertInvoicingProducts implements IInsert<InvoicingProducts> {

    private final ConnectDB con;
    private final String query;
    private static InsertInvoicingProducts instance;

    private InsertInvoicingProducts(){
        con = new ConnectDB();
        query = "INSERT INTO `invoicing_products`(`id_invoicing`, `id_product`, `length`) VALUE(?, ?, ?)";
    }

    public static InsertInvoicingProducts getInstance(){
        if(instance == null){
            instance = new InsertInvoicingProducts();
        }
        return instance;
    }

    @Override
    public void insertElement(InvoicingProducts element) {
        con.createConnection();
        try{
            PreparedStatement ps = con.getCon().prepareStatement(query);
            ps.setInt(1, element.getIdInvoicing());
            ps.setInt(2, element.getIdProduct());
            ps.setInt(3, element.getLength());
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("Something is wrong: ");
            System.out.println(e.getMessage());
        }
    }
}
