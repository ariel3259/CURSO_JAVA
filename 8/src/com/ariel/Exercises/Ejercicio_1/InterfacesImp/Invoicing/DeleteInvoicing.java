package com.ariel.Exercises.Ejercicio_1.InterfacesImp.Invoicing;

import com.ariel.Exercises.Ejercicio_1.Db.ConnectDB;
import com.ariel.Exercises.Ejercicio_1.Interfaces.IDelete;

import java.sql.PreparedStatement;

public class DeleteInvoicing implements IDelete {
    private final ConnectDB con;
    private final String query;
    private static DeleteInvoicing instance;

    private DeleteInvoicing(){
        con = new ConnectDB();
        query = "DELETE FROM `invoicing` WHERE `id` = ?";
    }

    public static DeleteInvoicing getInstance(){
        if(instance == null){
            instance = new DeleteInvoicing();
        }
        return instance;
    }

    @Override
    public void deleteElement(int id) {
        con.createConnection();
        try {
            PreparedStatement ps = con.getCon().prepareStatement(query);
            ps.setInt(0, id);
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("Something is wrong: ");
            System.out.println(e.getMessage());
        }
    }
}
