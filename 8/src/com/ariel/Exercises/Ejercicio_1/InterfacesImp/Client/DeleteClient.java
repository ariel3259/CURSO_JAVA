package com.ariel.Exercises.Ejercicio_1.InterfacesImp.Client;

import com.ariel.Exercises.Ejercicio_1.Db.ConnectDB;
import com.ariel.Exercises.Ejercicio_1.Interfaces.IDelete;

import java.sql.PreparedStatement;

public class DeleteClient implements IDelete {

    private final ConnectDB con;
    private final String query;
    private static DeleteClient instance;

    private DeleteClient(){
        con = new ConnectDB();
        query = "UPDATE `client` SET `deleted` = 'Y' WHERE `id` = ?";
    }

    public static DeleteClient getInstance(){
        if(instance == null){
            instance = new DeleteClient();
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
