package com.ariel.Exercises.Ejercicio_1.InterfacesImp.Invoicing;

import com.ariel.Exercises.Ejercicio_1.Db.ConnectDB;
import com.ariel.Exercises.Ejercicio_1.Interfaces.IInsert;
import com.ariel.Exercises.Ejercicio_1.Models.Invoicing;

import java.sql.PreparedStatement;

public class InsertInvoicing implements IInsert<Invoicing> {

    private final ConnectDB con;
    private final String query;
    private static InsertInvoicing instance;

    private InsertInvoicing(){
        con = new ConnectDB();
        query = "INSERT INTO `invoicing`(`id_client`, `id_traider`, `total_price`, `date_bought`) VALUE(?, ?, 0, CURRENT_DATE)";
    }

    public static InsertInvoicing getInstance(){
        if(instance == null){
            instance = new InsertInvoicing();
        }
        return instance;
    }

    @Override
    public void insertElement(Invoicing element) {
        con.createConnection();
        try{
            PreparedStatement ps = con.getCon().prepareStatement(query);
            ps.setInt(1, element.getIdClient());
            ps.setInt(2, element.getIdTrader());
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("Something is wrong: ");
            System.out.println(e.getMessage());
        }
    }
}
