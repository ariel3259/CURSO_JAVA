package com.ariel.Exercises.Ejercicio_1.InterfacesImp.Traider;

import com.ariel.Exercises.Ejercicio_1.Db.ConnectDB;
import com.ariel.Exercises.Ejercicio_1.Interfaces.IDelete;

import java.sql.PreparedStatement;

public class DeleteTraider implements IDelete {

    private final ConnectDB con;
    private final String query;
    private static DeleteTraider instance;

    private DeleteTraider(){
        con = new ConnectDB();
        query = "UPDATE `traider` SET `deleted` = 'Y' WHERE id = ?";
    }

    public static DeleteTraider getInstance(){
        if(instance == null){
            instance = new DeleteTraider();
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
