package com.ariel.Exercises.Ejercicio_1.InterfacesImp.InvoicingProducts;

import com.ariel.Exercises.Ejercicio_1.Db.ConnectDB;
import com.ariel.Exercises.Ejercicio_1.Interfaces.IDelete;

import java.sql.PreparedStatement;

public class DeleteInvoicingProducts implements IDelete {
    private final ConnectDB con;
    private final String query;
    private static DeleteInvoicingProducts instance;

    private DeleteInvoicingProducts(){
        con = new ConnectDB();
        query = "DELETE FROM `invoicing_products` WHERE `id` = ?";
    }

    public static DeleteInvoicingProducts getInstance(){
        if(instance == null){
            instance = new DeleteInvoicingProducts();
        }
        return instance;
    }

    @Override
    public void deleteElement(int id) {
        con.createConnection();
        try{
            PreparedStatement ps = con.getCon().prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("Something is wrong: ");
            System.out.println(e.getMessage());
        }
    }
}
