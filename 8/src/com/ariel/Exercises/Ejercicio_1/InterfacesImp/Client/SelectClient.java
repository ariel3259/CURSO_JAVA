package com.ariel.Exercises.Ejercicio_1.InterfacesImp.Client;

import com.ariel.Exercises.Ejercicio_1.Db.ConnectDB;
import com.ariel.Exercises.Ejercicio_1.Interfaces.ISelect;
import com.ariel.Exercises.Ejercicio_1.Models.Client;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectClient implements ISelect<Client> {

    private final ConnectDB con;
    private final String query;
    private static SelectClient instance;

    private SelectClient(){
        con = new ConnectDB();
        query = "SELECT * FROM `client` WHERE `deleted`='N'";
    }

    public static SelectClient getInstance(){
        if(instance == null){
            instance = new SelectClient();
        }
        return instance;
    }

    @Override
    public List<Client> getElements() {
        List<Client> clients = new ArrayList<>();
        con.createConnection();
        try{
            Statement stm = con.getCon().createStatement();
            ResultSet rs = stm.executeQuery(query);

            while(rs.next()){
                clients.add(new Client(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(5),
                        rs.getInt(4),
                        rs.getString(7)
                ));
            }

            return clients;
        }catch (Exception e){

            System.out.println("Something is wrong: ");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
