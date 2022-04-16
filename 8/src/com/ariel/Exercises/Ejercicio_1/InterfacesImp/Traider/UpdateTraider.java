package com.ariel.Exercises.Ejercicio_1.InterfacesImp.Traider;

import com.ariel.Exercises.Ejercicio_1.Db.ConnectDB;
import com.ariel.Exercises.Ejercicio_1.Interfaces.IUpdate;
import com.ariel.Exercises.Ejercicio_1.Models.Traider;

import java.sql.PreparedStatement;

public class UpdateTraider implements IUpdate<Traider> {

    private final ConnectDB con;
    private final String query;
    private static UpdateTraider instance;

    private UpdateTraider(){
        con = new ConnectDB();
        query = "UPDATE `traider` SET `name` = ?, `last_name` = ?, `address` = ?, `dni` = ?, `salary` = ?, `year_of_born` = ? WHERE `id` = ? ";
    }

    public static UpdateTraider getInstance(){
        if(instance == null){
            instance = new UpdateTraider();
        }
        return instance;
    }

    @Override
    public void updateElement(Traider element) {
        con.createConnection();
        try{
            PreparedStatement ps = con.getCon().prepareStatement(query);
            ps.setString(1, element.getName());
            ps.setString(2, element.getLastName());
            ps.setString(3, element.getAddress());
            ps.setInt(4, element.getDni());
            ps.setDouble(5, element.getSalary());
            ps.setDate(6, element.getYearOfBorn());
            ps.setInt(7, element.getId());
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("Something is wrong: ");
            System.out.println(e.getMessage());

        }
    }
}
