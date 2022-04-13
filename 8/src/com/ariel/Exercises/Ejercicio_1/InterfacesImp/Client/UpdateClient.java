package com.ariel.Exercises.Ejercicio_1.InterfacesImp.Client;

import com.ariel.Exercises.Ejercicio_1.Db.ConnectDB;
import com.ariel.Exercises.Ejercicio_1.Interfaces.IUpdate;
import com.ariel.Exercises.Ejercicio_1.Models.Client;

import java.sql.PreparedStatement;

public class UpdateClient implements IUpdate<Client> {

    private final ConnectDB con;
    private final String query;
    private static UpdateClient instance;

    private UpdateClient(){
        con = new ConnectDB();
        query = "UPDATE `client` SET `name` = ?, `last_name` = ?, `address` = ?, `dni` = ?, `year_of_born` = ? WHERE `id` = ? ";
    }

    public static UpdateClient getInstance(){
        if(instance == null){
            instance = new UpdateClient();
        }
        return instance;
    }

    @Override
    public void updateElement(Client element) {
        con.createConnection();
        try{
            PreparedStatement ps = con.getCon().prepareStatement(query);
            ps.setString(1, element.getName());
            ps.setString(2, element.getLastName());
            ps.setString(3, element.getAddress());
            ps.setInt(4, element.getDni());
            ps.setString(5, element.getYearOfBorn());
            ps.setInt(6, element.getId());
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("Something is wrong: ");
            System.out.println(e.getMessage());
        }
    }
}
