package com.ariel.Exercises.Ejercicio_1.InterfacesImp.Traider;

import com.ariel.Exercises.Ejercicio_1.Db.ConnectDB;
import com.ariel.Exercises.Ejercicio_1.Interfaces.IInsert;
import com.ariel.Exercises.Ejercicio_1.Models.Traider;

import java.sql.PreparedStatement;

public class InsertTraider implements IInsert<Traider> {

    private final ConnectDB con;
    private final String query;
    private static InsertTraider instance;

    private InsertTraider(){
        con = new ConnectDB();
        query = "INSERT INTO `traider`(`name`, `last_name`, `address`, `dni`, `salary`, `year_of_born`, `deleted`) VALUE (?, ?, ?, ?, ?, ?, 'N')";
    }

    public static InsertTraider getInstance(){
        if(instance == null){
            instance = new InsertTraider();
        }
        return instance;
    }

    @Override
    public void insertElement(Traider element) {
        con.createConnection();
        try {
            PreparedStatement ps = con.getCon().prepareStatement(query);
            ps.setString(1, element.getName());
            ps.setString(2, element.getLastName());
            ps.setString(3, element.getAddress());
            ps.setInt(4, element.getDni());
            ps.setDouble(5, element.getSalary());
            ps.setDate(6, element.getYearOfBorn());
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("Something is wrong: ");
            System.out.println(e.getMessage());
        }
    }
}
