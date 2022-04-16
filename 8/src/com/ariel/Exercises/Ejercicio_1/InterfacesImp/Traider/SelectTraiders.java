package com.ariel.Exercises.Ejercicio_1.InterfacesImp.Traider;

import com.ariel.Exercises.Ejercicio_1.Db.ConnectDB;
import com.ariel.Exercises.Ejercicio_1.Interfaces.ISelect;
import com.ariel.Exercises.Ejercicio_1.Models.Traider;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectTraiders implements ISelect<Traider> {

    private final ConnectDB con;
    private final String query;
    private static SelectTraiders instance;

    private SelectTraiders(){
        con = new ConnectDB();
        query = "SELECT * FROM `traider` WHERE `deleted` = 'N'";
    }

    public static SelectTraiders getInstance(){
        if(instance == null){
            instance = new SelectTraiders();
        }
        return instance;
    }

    @Override
    public List<Traider> getElements() {
        con.createConnection();
        List<Traider> traiders = new ArrayList<>();
        try{
            Statement stm = con.getCon().createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                traiders.add(new Traider(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getDouble(7),
                        rs.getDate(8)
                ));
            }
            return traiders;
        }catch (Exception e){
            System.out.println("Something is wrong: ");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
