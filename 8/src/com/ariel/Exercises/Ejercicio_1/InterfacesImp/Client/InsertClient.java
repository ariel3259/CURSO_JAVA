package com.ariel.Exercises.Ejercicio_1.InterfacesImp.Client;

import com.ariel.Exercises.Ejercicio_1.Db.ConnectDB;
import com.ariel.Exercises.Ejercicio_1.Interfaces.IInsert;
import com.ariel.Exercises.Ejercicio_1.Models.Client;

import java.sql.PreparedStatement;

public class InsertClient implements IInsert<Client> {

    private final ConnectDB con;
    private final String query;
    private static InsertClient instance;

    private InsertClient(){
        con = new ConnectDB();
        query = "INSERT INTO `client`(`name`, `last_name`, `address`, `dni`, `year_of_born`, `deleted` ) VALUE(?, ?, ?, ?, ?, 'N')";
    }

    public static InsertClient getInstance(){
        if(instance == null){
            instance = new InsertClient();
        }
        return instance;
    }

    @Override
    public void insertElement(Client element) {
        con.createConnection();
        try{
            PreparedStatement ps = con.getCon().prepareStatement(query);
            ps.setString(1, element.getName());
            ps.setString(2, element.getLastName());
            ps.setString(3, element.getAddress());
            ps.setInt(4, element.getDni());
            ps.setString(5, element.getYearOfBorn());
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("Something is wrong: ");
            System.out.println(e.getMessage());
        }
    }
}
