package com.ariel.Exercises.Ejercicio_1.InterfacesImp.Invoicing;

import com.ariel.Exercises.Ejercicio_1.Db.ConnectDB;
import com.ariel.Exercises.Ejercicio_1.Interfaces.IUpdate;
import com.ariel.Exercises.Ejercicio_1.Models.Invoicing;
import com.ariel.Exercises.Ejercicio_1.Models.Products;

import java.sql.PreparedStatement;

public class UpdateInvoicing implements IUpdate<Invoicing> {

    private final ConnectDB con;
    private final String query;
    private static UpdateInvoicing instance;

    private UpdateInvoicing(){
        con = new ConnectDB();
        query = "UPDATE `invoicing` SET `id_client` = ?, `id_trader` = ? WHERE `id` = ?";
    }

    public static UpdateInvoicing getInstance(){
        if(instance == null){
            instance = new UpdateInvoicing();
        }
        return instance;
    }

    @Override
    public void updateElement(Invoicing element) {
        con.createConnection();
        try{
            PreparedStatement ps = con.getCon().prepareStatement(query);
            ps.setInt(1, element.getIdClient());
            ps.setInt(2, element.getIdTrader());
            ps.setInt(3, element.getId());
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("Something is wrong: ");
            System.out.println(e.getMessage());
        }
    }
}
