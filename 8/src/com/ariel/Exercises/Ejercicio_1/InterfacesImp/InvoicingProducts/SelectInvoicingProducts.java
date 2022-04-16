package com.ariel.Exercises.Ejercicio_1.InterfacesImp.InvoicingProducts;

import com.ariel.Exercises.Ejercicio_1.Db.ConnectDB;
import com.ariel.Exercises.Ejercicio_1.Interfaces.ISelect;
import com.ariel.Exercises.Ejercicio_1.Models.InvoicingProducts;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectInvoicingProducts implements ISelect<InvoicingProducts> {

    private final ConnectDB con;
    private final String query;
    private static SelectInvoicingProducts instance;

    private SelectInvoicingProducts(){
        con = new ConnectDB();
        query = "SELECT * FROM `invoicing_products`";
    }

    public static SelectInvoicingProducts getInstance(){
        if(instance == null){
            instance = new SelectInvoicingProducts();
        }
        return instance;
    }

    @Override
    public List<InvoicingProducts> getElements() {
        con.createConnection();
        List<InvoicingProducts> invoicingProducts = new ArrayList<>();
        try {
            Statement stm = con.getCon().createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                invoicingProducts.add(new InvoicingProducts(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4)
                ));
            }
            return invoicingProducts;
        }catch (Exception e){
            System.out.println("Something is wrong: ");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
