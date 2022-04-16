package com.ariel.Exercises.Ejercicio_1.InterfacesImp.InvoicingProducts;

import com.ariel.Exercises.Ejercicio_1.Db.ConnectDB;
import com.ariel.Exercises.Ejercicio_1.Interfaces.IUpdate;
import com.ariel.Exercises.Ejercicio_1.Models.InvoicingProducts;

import java.sql.PreparedStatement;

public class UpdateInvoicingProducts implements IUpdate<InvoicingProducts> {
    private final ConnectDB con;
    private final String query;
    private static UpdateInvoicingProducts instance;

    private UpdateInvoicingProducts(){
        con = new ConnectDB();
        query = "UPDATE `invoicing_products` SET `id_invoicing` = ?, `id_product` = ?, `length` = ?, WHERE id = ?";
    }

    public static UpdateInvoicingProducts getInstance(){
        if(instance == null){
            instance = new UpdateInvoicingProducts();
        }
        return instance;
    }

    @Override
    public void updateElement(InvoicingProducts element) {
        con.createConnection();
        try{
            PreparedStatement ps = con.getCon().prepareStatement(query);
            ps.setInt(1, element.getIdInvoicing());
            ps.setInt(2, element.getIdProduct());
            ps.setInt(3, element.getLength());
            ps.setInt(4, element.getId());
        }catch (Exception e){
            System.out.println("Something is wrong: ");
            System.out.println(e.getMessage());
        }
    }
}
