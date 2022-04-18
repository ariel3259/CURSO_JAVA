package com.ariel.Exercises.Ejercicio_1.InterfacesImp.Invoicing;

import com.ariel.Exercises.Ejercicio_1.Db.ConnectDB;
import com.ariel.Exercises.Ejercicio_1.Interfaces.ISelect;
import com.ariel.Exercises.Ejercicio_1.Models.Invoicing;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectInvoicing implements ISelect<Invoicing> {

    private final ConnectDB con;
    private final String query;
    private static SelectInvoicing instance;

    private SelectInvoicing(){
        con = new ConnectDB();
        query = "SELECT * FROM `invoicing`";
    }

    public static SelectInvoicing getInstance(){
        if(instance == null){
            instance = new SelectInvoicing();
        }
        return instance;
    }

    @Override
    public List<Invoicing> getElements() {
        con.createConnection();
        List<Invoicing> invoicings = new ArrayList<>();
        try{
            Statement stm = con.getCon().createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                invoicings.add(new Invoicing(
                        rs.getInt(1),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getDate(2)
                ));
            }
            return invoicings;
        }catch (Exception e){
            System.out.println("Something is wrong: ");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
